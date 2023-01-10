package com.docmatter.ims.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;


public class FileWriterPool {

    private static FileWriterPool pool = new FileWriterPool();

    public static FileWriterPool me() {
        return pool;
    }

    private HashMap<String, Writer> writers;

    public FileWriterPool() {
        writers = new HashMap<>();
    }

    public synchronized Writer getWriter(File file) {
        Writer w = writers.get(file.getAbsolutePath());
        if (null == w){
            synchronized (this) {
                w = writers.get(file.getAbsolutePath());
                if (null == w) {
                    try {
                        w = new BufferedWriter(new FileWriter(file, true));
                        writers.put(file.getAbsolutePath(), w);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // in case when the underlying stream has been closed
        try{
            w.flush();
        }catch (Exception e){
            try{
                w = new BufferedWriter(new FileWriter(file, true));
                writers.put(file.getAbsolutePath(), w);
            }catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return w;
    }

    public void close(File file) {
        close(file.getAbsolutePath());
    }

    private synchronized void close(String path) {
        Writer w = writers.get(path);
        if (null != w) {
            try {
                w.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writers.remove(path);
            }
        }
    }

    public void close() {
        for (Writer w : writers.values()) {
            try {
                w.close();
            } catch (IOException e) {}
        }
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

}