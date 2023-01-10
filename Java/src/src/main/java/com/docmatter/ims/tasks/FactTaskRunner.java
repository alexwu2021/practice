package com.docmatter.ims.tasks;

import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.db.jpa.DimReferenceDataStructureEntity;
import com.docmatter.ims.db.jpa.DimUsersEntity;
import com.docmatter.ims.db.jpa.FactsEntity;
import com.docmatter.ims.exception.ImsException;
import com.docmatter.ims.repository.dw.*;
import com.docmatter.ims.util.DateTimeUtil;
import com.docmatter.ims.util.FileUtil;
import com.docmatter.ims.util.HashUtil;
import com.docmatter.ims.util.MyStringUtil;
//import com.docmatter.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class FactTaskRunner implements CommandLineRunner {

    @Autowired
    IDimUserEntityRepository iDimUserEntityRepository;

    @Autowired
    IDimReferenceDataStructureEntityRepository iDimReferenceDataStructureEntityRepository;


    @Autowired
    IDimCommunitiesEntityRepository iDimCommunitiesEntityRepository;


    @Autowired
    IDimProductGroupEntityRepository iDimProductGroupEntityRepository;


    @Autowired
    IFactsEntityRepository iFactsEntityRepository;

    @Value("${app.debugMode}")
    private boolean debugMode;

    private Set<Long> uidSet = new HashSet<>();

    @Override
    public void run(String... args) throws Exception {
        try{
            System.out.println("----------starting the run method in FactTaskRunner-------------");
//            // prepare the sorting group by deleting the records from the previous runs
//            deleteDynamicTableContent();
//
//            // store to dim tables
//            instantiateUidSetAndstoreDimUsersToDw();
//
//            storeRelevantReferenceDataStructureToDw();
//
//            // store to the center table
//            storeFactsToDw();

            System.out.println("----------end the run method in FactTaskRunner---------------");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void deleteDynamicTableContent() {
        try{
            this.iFactsEntityRepository.deleteAll();
            this.iDimReferenceDataStructureEntityRepository.deleteAll();
            this.iDimUserEntityRepository.deleteAll();
            this.iDimCommunitiesEntityRepository.deleteAll();
            this.iDimProductGroupEntityRepository.deleteAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("all the dynamic table content have been deleted");
        }
    }


    /**
     * v.NOTIFICATION_EMAIL_ID, " +
     *             "        v.EMAIL_TO_UID," +
     *             "        date(v.VIEW_DATE) as VIEW_DATE," +
     *             "        nm.msid, " +
     *             "        pc.ctxtype," +
     *             "        pc.ctxid, " +
     *             "        pc.access_ctxtype, " +
     *             "        pc.access_ctxid, " +
     *             "        m.THREAD_MSID ";
     */
    private void storeFactsToDw() {
        List<FactsEntity>factsEntities = new ArrayList<>();
        try{
            iFactsEntityRepository.deleteAll();
            String fileName = FileUtil.getAbsoluteFilePath(ImsConstant.EMAIL_OPEN_UDT_INPUT_FILE);
            if(!Files.exists(Paths.get(fileName)))
                return;

            int lineCount = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(ImsConstant.SPLITTER);
                String viewDate = sa[2]; //view date
                Integer measuredOperationId  = 5;
                Integer actionTargetId = 1;
                Long uid = Long.valueOf(sa[1]);
                if(uid <= 0 || !this.uidSet.contains(uid)) {
                    line = bufferedReader.readLine();
                    continue;
                }

                FactsEntity factsEntity = new FactsEntity();
                factsEntity.setActionUserId(uid);
                factsEntity.setFactUuidHash(HashUtil.getUuidHash());
                factsEntity.setActionTargetId(actionTargetId);
                factsEntity.setExtractionDateId(DateTimeUtil.getDefaultDimDateId());
                factsEntity.setEventDateId(DateTimeUtil.getDimDateIdFromDateString(viewDate));
                factsEntity.setOperationId(measuredOperationId);
                factsEntity.setProcessingStatusId(11);

                factsEntities.add(factsEntity);
                lineCount++;
                if(lineCount % 10000 == 0){
                    System.out.println("In storeFactsToDw, processing line number: " + lineCount);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            if(debugMode){
                if(factsEntities.size() == 0){
                    throw new ImsException("Error: expected to see at least one records in dimReferenceDataStructureEntities!");
                }
            }
            iFactsEntityRepository.saveAll(factsEntities);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(factsEntities.size() + " facts saved to table");
        }
    }

    private void storeRelevantReferenceDataStructureToDw() throws FileNotFoundException {
        String ctxEntityMpiFile = FileUtil.getAbsoluteFilePath(ImsConstant.REFERENCE_DATA_USER_2_NUGLIST_FILE_NAME);
        if(!Files.exists(Paths.get(ctxEntityMpiFile)))
            return;

        List<DimReferenceDataStructureEntity>dimReferenceDataStructureEntities = new ArrayList<>();
        int lineCount = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(ctxEntityMpiFile));
            String line = bufferedReader.readLine();
            while (line != null && line.length() > 0) {
                String[] sa = line.split(":");
                Long uid = Long.valueOf(sa[0]);
                if(uid <= 0 || !this.uidSet.contains(uid)) {
                    line = bufferedReader.readLine();
                    continue;
                }

                DimReferenceDataStructureEntity dimReferenceDataStructureEntity = new DimReferenceDataStructureEntity();
                dimReferenceDataStructureEntity.setUid(uid);
                dimReferenceDataStructureEntity.setNugIds(MyStringUtil.removeTrailingComma(sa[1]));
                dimReferenceDataStructureEntity.setDateId(DateTimeUtil.getDefaultDimDateId());
                dimReferenceDataStructureEntities.add(dimReferenceDataStructureEntity);
                lineCount++;
                if(lineCount % 10000 == 0){
                    System.out.println("In storeReferenceDataStructureToDw, processing line number: " + lineCount);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            if(debugMode){
                if(dimReferenceDataStructureEntities.size() == 0){
                    throw new ImsException("Error: expected to have at least one record in dimReferenceDataStructureEntities!");
                }
            }
            iDimReferenceDataStructureEntityRepository.saveAll(dimReferenceDataStructureEntities);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(dimReferenceDataStructureEntities.size() + " reference data structure records saved to table");
        }

    }


    /**
     * TODO: RESOLVE THE MYSTERY AWU
     *
     * A concern is that the user's UID is NOT following 1 to 1 mapping to user seq
     * which is a coded value: val_ctxType + val_ctxId * 1000_000
     * we may see 4000 unique user's UIDs while less than 100 userSeq
     * that is the main reason we see less records in dw
     *
     *
     *
     * 28173898,64593,20211007,87827,200,10165,200,10165,87827
     *
     *
     *     " a.NOTIFICATION_EMAIL_ID," +                    // 0
     *             " a.EMAIL_TO_UID, " +                    // 1
     *             " date(a.VIEW_DATE) as VIEW_DATE, " +    // 2
     *             " a.msid, " +                            // 3
     *             " a.ctxtype, " +                         // 4
     *             " a.ctxid, " +                           // 5
     *             " a.access_ctxtype, " +                  // 6
     *             " a.access_ctxid, " +                    // 7
     *             "  a.THREAD_MSID,                        // 8
     *            // a.USER_TYPE,                             // 9
     *            // a.FULL_NAME  ";                          // 10
     */
    private void instantiateUidSetAndstoreDimUsersToDw() {
        try{
            iDimUserEntityRepository.deleteAllInBatch();
            String ctxEntityMpiFile = FileUtil.getAbsoluteFilePath(ImsConstant.EMAIL_OPEN_UDT_INPUT_FILE);
            if(!Files.exists(Paths.get(ctxEntityMpiFile))){
                System.out.println("In populateNugIdToNugIdMapping, file " + ctxEntityMpiFile + " not available.");
                return;
            }

            uidSet.clear();
            List<DimUsersEntity>userList = new ArrayList<>();
            int lineCount = 0;
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(ctxEntityMpiFile));
                String line = bufferedReader.readLine();
                while (line != null && line.length() > 0) {
                    String[] sa = line.split(ImsConstant.SPLITTER);
                    Long uid = Long.valueOf(sa[1]);
                    if(uid <= 0 || uidSet.contains(uid)) {
                        line = bufferedReader.readLine();
                        continue;
                    }
                    uidSet.add(uid);
                    DimUsersEntity dimUsersEntity = new DimUsersEntity();
                    dimUsersEntity.setUid(uid);
                    userList.add(dimUsersEntity);
                    lineCount++;
                    if(lineCount % 10000 == 0){
                        System.out.println("In populateNugIdToNugIdMapping, processing line number: " + lineCount);
                    }
                    line = bufferedReader.readLine();
                }
                bufferedReader.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            iDimUserEntityRepository.saveAll(userList);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("----------storeDimUsersToDw() done---------");
        }
    }
}
