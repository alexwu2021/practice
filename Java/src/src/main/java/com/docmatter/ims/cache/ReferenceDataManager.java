package com.docmatter.ims.cache;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.MathUtil;
//import com.docmatter.util.StringUtil;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.docmatter.ims.constant.ImsConstant.MB_SIZE;

@Component
public class ReferenceDataManager {


    private Set<Long>userIdSet;
    private Map<Long, Long>userIdToUserSeqMap;
    private Map<Long, Long> userSeqToUserIdMap;

    private Set<Long> communityIdSet;
    private Set<Long> productGroupIdSet;
    private Map<Long, Set<Long>> userId2NugIdSetMap;
    private Map<Long, Set<Long>> nugId2NugIdSetMap;

    private static ReferenceDataManager me = new ReferenceDataManager();
    public ReferenceDataManager() {
        this.userIdSet = new HashSet<>();
        this.userIdToUserSeqMap = new HashMap<>();
        this.userSeqToUserIdMap = new HashMap<>();

        this.communityIdSet = new HashSet<>();
        this.productGroupIdSet = new HashSet<>();
        this.userId2NugIdSetMap = new HashMap<>();
        this.nugId2NugIdSetMap = new HashMap<>();
    }

    public static ReferenceDataManager me(){
        return me;
    }

    public Set<Long> getUserIdSet(){
        return this.userIdSet;
    }

    public Map<Long, Long> getUserIdToUserSeqMap() { return this.userIdToUserSeqMap;}

    public Map<Long, Long> getUserSeqToUserIdMap() { return this.userSeqToUserIdMap;}

    public Set<Long> getCommunityIdSet(){
        return this.communityIdSet;
    }

    public Set<Long> getProductGroupIdSet(){
        return this.productGroupIdSet;
    }

    public Map<Long, Set<Long>> getUserId2NugIdSetMap(){
        return this.userId2NugIdSetMap;
    }

    public Map<Long, Set<Long>> getNugId2NugIdSetMap(){
        return this.nugId2NugIdSetMap;
    }


    public void processBaseReferenceDataFiles() throws FileNotFoundException {
        System.out.println("starting processBaseReferenceDataFiles()");
        populateNugIdSet();

        // step 1: build 2 data structures: a total user id set, and a userid to nug id set map
        populateUserIdToUserSeqMap();

        populateNugIdToNugIdMapping();

        populateUserId2NugIdSetMap();

        updateUserIdToNugIdSetMapping();


        // step 2: materialize them
        exportUserIdCollectionsToFile();

        exportUserToUgSetMappingToFile();

        System.out.println("ended processBaseReferenceDataFiles()");
    }

    /**
     * select c.ctxtype, c.ctxid, c.state, c.name, u.UID
     */
    private void populateUserIdToUserSeqMap() throws FileNotFoundException {
        String fileName = FileUtil.getAbsoluteFilePath(ImsConstant.CTX_ENTITY_INPUT_FILE);
        try {
            int lineCount = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                Long uid = Long.valueOf(sa[4]);
                if(this.userIdSet.contains(uid)){
                    this.userIdToUserSeqMap.put(uid, MathUtil.encodeForEntity(Integer.valueOf(sa[0]), Integer.valueOf(sa[1])));
                }
                lineCount++;
                if(lineCount % 10000 == 0){
                    System.out.println("RefDt saver's run, processing line number: " + lineCount);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("");
        }
    }

    private void exportUserIdCollectionsToFile() throws FileNotFoundException {
        System.out.println("starting exportUserIdCollectionsToFile()");

        String relativeFileName = ImsConstant.REFERENCE_DATA_USER_COLLECTION_FILE_NAME;  //"userIds.ref"
        FileUtil.deleteIfExistsAndReCreate(relativeFileName);

        //TODO: WHY THIS AWU??
        String fileName = FileUtil.getResultingExplodedFileName(relativeFileName);
        BufferedWriter bufferedWriter = null;
        Writer writer = null;
        BufferedWriter out = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(fileName, false), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(writer, ImsConstant.DEFAULT_CHAR_BUFFER_SIZE);
            for (Long userId: this.userIdSet) {
                bufferedWriter.write(userId + "\n");
            }
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                File file = new File(fileName);
                long fileSize = FileUtil.getFileSize(file);
                System.out.println("The size of file " + fileName + " is " + (double)fileSize/(double) MB_SIZE + " MB.");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("done exportUserIdCollectionsToFile()");
        }
    }

    private void exportUserToUgSetMappingToFile() {
        System.out.println("starting exportUserToUgSetMappingToFile()");
        String fileName = ImsConstant.REFERENCE_DATA_USER_2_NUGLIST_FILE_NAME;
        FileUtil.deleteIfExistsAndReCreate(fileName);
        BufferedWriter bufferedWriter = null;
        Writer fstream = null;
        BufferedWriter out = null;
        try {
            fstream = new OutputStreamWriter(new FileOutputStream(fileName, false), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(fstream, ImsConstant.DEFAULT_CHAR_BUFFER_SIZE);

            for (Long userId: this.userId2NugIdSetMap.keySet()) {
                bufferedWriter.write(userId + ": ");
                Set<Long>set = this.userId2NugIdSetMap.get(userId);
                int i = 0;
                for(Long ele : set){
                    if(i++ < set.size())
                        bufferedWriter.write(ele + ",");
                    else
                        bufferedWriter.write(ele + "");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                File file = new File(fileName);
                long fileSize = FileUtil.getFileSize(file);
                System.out.println("The size of file " + fileName + " is " + (double)fileSize/(double) MB_SIZE + " MB.");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("done exportUserToUgSetMappingToFile()");
        }
    }

    /**
     * based on the recursive nature of community to community membership and product group to product group membership
     * update the map
     */
    private void updateUserIdToNugIdSetMapping() {
        System.out.println("to update the user id to nug id set mapping with nugid to nugid mapping");
        for(Long userId : this.userId2NugIdSetMap.keySet()){
            Set<Long>nugIds = this.userId2NugIdSetMap.get(userId);
            for(Long nugId: this.nugId2NugIdSetMap.keySet()){
                boolean changed = false;
                if(nugIds.contains(nugId)){
                    nugIds.addAll(this.nugId2NugIdSetMap.get(nugId));
                    changed = true;
                }
                // to be safe, let me call it explicitly
                if(changed)
                    this.userId2NugIdSetMap.put(userId, nugIds);
            }
        }
    }

    private void populateNugIdToNugIdMapping() throws FileNotFoundException {
        System.out.println("starting populateNugIdToNugIdMapping()");
        String fileName = FileUtil.getAbsoluteFilePath(ImsConstant.CTX_ENTITY_REL_INPUT_FILE);
        int lineCount = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                Long fromNugId = MathUtil.encodeForEntity(Integer.valueOf(sa[0]), Integer.valueOf(sa[1]));
                if(this.communityIdSet.contains(fromNugId) || this.productGroupIdSet.contains(fromNugId)) {
                    Long toNugId = MathUtil.encodeForEntity(Integer.valueOf(sa[2]), Integer.valueOf(sa[3]));
                    if(this.communityIdSet.contains(toNugId) || this.productGroupIdSet.contains(toNugId)) {
                        this.nugId2NugIdSetMap.put(fromNugId, this.nugId2NugIdSetMap.computeIfAbsent(fromNugId, x->new HashSet<>())).add(toNugId);
                    }

//                    // no idea how to utilzee this info for now
//                    Long accessNugId = MathUtil.encodeForEntity(Integer.valueOf(sa[4]), Integer.valueOf(sa[5]));
//                    {
//                    }
                }
                lineCount++;
                if(lineCount % 10000 == 0){
                    System.out.println("In populateNugIdToNugIdMapping, processing line number: " + lineCount);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Done populateNugIdToNugIdMapping, with size of nugId2NugIdSetMap as " + this.nugId2NugIdSetMap.size());
        }
    }

    private void populateUserId2NugIdSetMap() throws FileNotFoundException {
        String[] saFileNames = new String[]{FileUtil.getAbsoluteFilePath(ImsConstant.USER_COMMUNITY_INPUT_FILE), FileUtil.getAbsoluteFilePath(ImsConstant.USER_PRODUCT_GROUP_INPUT_FILE)};
        for(String fileName : saFileNames){
            System.out.println("getting info from " + fileName + " to populate userId2NugIdSetMap ...");
            int lineCount = 0;
            try {
                BufferedReader freader = new BufferedReader(new FileReader(fileName));
                String line = freader.readLine();
                while (line != null && line.length() > 0) {
                    String[] sa = line.split(ImsConstant.SPLITTER);
                    Long userId = Long.valueOf(sa[0]);
                    Long nugId = Long.valueOf(sa[1]);
                    this.userIdSet.add(userId);
                    this.userId2NugIdSetMap.put(userId, this.userId2NugIdSetMap.computeIfAbsent(userId, x->new HashSet<>())).add(nugId);
                    line = freader.readLine();
                    lineCount++;
                    if(lineCount % 10000 == 0){
                        System.out.println("In populateUserId2NugIdSetMap, processing line number: " + lineCount);
                    }
                }
                freader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("userId2NugIdSetMap has been successfully populated, with the key size of " + userId2NugIdSetMap.size());
    }

    /**
     * from both files: community and product group input files
     */
    private void populateNugIdSet() throws FileNotFoundException {
        String fileName = FileUtil.getAbsoluteFilePath(ImsConstant.COMMUNITY_INPUT_FILE);
        populateNugIdSetHelper(fileName, this.communityIdSet);
        System.out.println("valid Community NUG IDs extracted, with size of " + this.communityIdSet.size());

        fileName = FileUtil.getAbsoluteFilePath(ImsConstant.PRODUCT_GROUP_INPUT_FILE);
        populateNugIdSetHelper(fileName, this.productGroupIdSet);
        System.out.println("valid Product Group NUG IDs extracted, with size of " + this.productGroupIdSet.size());
    }

    /**
     * @param fileName
     * @param set: the resulting container that eventually holds all the nug ids
     */
    private void populateNugIdSetHelper(String fileName, Set<Long>set) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                set.add(MathUtil.encodeForEntity(Integer.valueOf(sa[0]), Integer.valueOf(sa[1])));
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
