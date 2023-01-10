//package com.docmatter.ims.service.auxiliary;
//
//import java.math.BigInteger;
//
//public class SyncSequenceGenerator implements ISequenceGenerator {
//
//    private long value;
//
//    private SyncSequenceGenerator(){};
//
//    public SyncSequenceGenerator(long seed){
//        this.value = seed;
//    };
//
//    @Override
//    public synchronized long getNext() {
//        return value++;
//    }
//}