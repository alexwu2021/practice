package com.docmatter.ims.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ImsFileUtil {
    public static void WriteToFile(String _filePathName, String stringToWrite) throws IOException {
        BufferedWriter bufferedWriter = null;
        Writer fstream = null;
        BufferedWriter out = null;
        int defaultCharBufferSize = 100_000;
        try {
            fstream = new OutputStreamWriter(new FileOutputStream(_filePathName, true), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(fstream, defaultCharBufferSize);
            bufferedWriter.write(stringToWrite);
            bufferedWriter.newLine();
        }catch (Exception ex){
            fstream = new OutputStreamWriter(new FileOutputStream(_filePathName, false), StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(fstream, defaultCharBufferSize);
            bufferedWriter.write(stringToWrite);
        }finally {
            bufferedWriter.close();
            fstream.close();
        }
    }
}
