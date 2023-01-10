package com.docmatter.ims.util;

import com.docmatter.ims.constant.ImsConstant;
import org.springframework.core.io.FileSystemResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {


    public static String getFileCountUnderAFolder(String folder) {
        long count = 0;
        try (Stream<Path> files = Files.list(Paths.get(folder))) {
            count = files.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "number of files under folder" + folder + " is " + count;
    }

    public static String readAll(final String filePath) {
        String ret = "";
        try {
            ret = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8).stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String readAll(final File file) {
       return readAll(file.getAbsolutePath());
    }

    public static List<String> readNTailLinesFromAFile(String file, int nLine){
        List<String> ret = new ArrayList<>();
        try {
            List<String> temp = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8).stream().collect(Collectors.toList());
            int count = 0;
            for(int i = temp.size()-1; i>= 0; i--){
                ret.add(temp.get(i));
                count++;
                if(i >= nLine)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }



    public static long getFileSize(File file) {
        long length = file.length();
        return length;
    }

    public static void cleanupOutputFolder(String pathToFolder, boolean toRecreate){
        try{
            Path path= Paths.get(pathToFolder);
            if(path.toFile() != null && path.toFile() != null){
                for (File file : path.toFile().listFiles()){
                    Files.deleteIfExists(file.toPath());
                    if(toRecreate){
                        Files.createFile(file.toPath());
                        System.out.println("file " + file.getAbsolutePath() + " has been cleaned up");
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("folder " + pathToFolder + " has been cleaned up");
        }
    }

    public static void deleteIfExistsAndReCreate(String relativeFilePathName) {
        try{
            Path newFilePath = Paths.get(relativeFilePathName);
            if(Files.exists(newFilePath)){
                try {
                    Files.deleteIfExists(newFilePath);
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }

            FileSystemResource fsr = new FileSystemResource(newFilePath);
            //Resource resource = fsr.createRelative(relativeFilePathName);
            //System.out.println("resource " + resource.getFilename() + " just created");
            if(fsr.isWritable()){
                System.out.println(" and it is writeable");

            }else{
                System.out.println(" and it is not writeable");
            }
            fsr.getFile().createNewFile();

        } catch (Exception e2){
            e2.printStackTrace();
        }finally {
            System.out.println("file " + relativeFilePathName + " deleted and recreated.");
        }
    }

    public static String getResultingExplodedFileName(String pureFileName) throws FileNotFoundException {
        pureFileName = pureFileName.replace(ImsConstant.FACT_FILE_EXT, ImsConstant.EXPLODED_FACT_FILE_EXT);
        return FileUtil.getAbsoluteFilePath(ImsConstant.EXPLODED_FACT_FILE_OUTPUT_FOLDER + pureFileName);
    }

    public static String getAbsoluteFilePath(String relativePath) throws FileNotFoundException {
      return relativePath;
    }


    public static BufferedReader getBufferReader(String relativePath){
        System.out.println("relativePath: " + relativePath);
        InputStream inputStream = FileUtil.class.getResourceAsStream(relativePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) ;
        return reader;
    }


//    public static void outputStreamWriter(String file, String data) throws IOException {
//        try (OutputStream out = new FileOutputStream(file);
//             Writer writer = new OutputStreamWriter(out,"UTF-8")) {
//            writer.write(data);
//        }
//    }
}
