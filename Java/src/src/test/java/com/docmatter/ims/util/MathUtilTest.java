package com.docmatter.ims.util;



import com.docmatter.ims.constant.ImsConstant;
import com.docmatter.ims.exception.ImsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @Test
    void encodeDecodeForEntity() {
        int ctxType = 200, ctxId = 101013;
        Long seq = MathUtil.encodeForEntity(ctxType, ctxId);

        int[] res = MathUtil.decodeForEntity(seq);
        Assertions.assertTrue(res[0] == ctxType && res[1] == ctxId);
    }


    @Test
    void encodeDecodeForOperation() {
        int actionTarget = 2, action = 3;
        Long seq = MathUtil.encodeForEntity(actionTarget, action);

        int[] res = MathUtil.decodeForEntity(seq);
        Assertions.assertTrue(res[0] == actionTarget && res[1] == action);
    }


    @Test
    void getValueFromIntegerString() {

//        final File folder = new File(ImsConstant.EXPLODED_FACT_FILE_OUTPUT_FOLDER);
//        Integer beginDate = 20101015, endDate = 20221115;
//
//        List<String> list = new ArrayList<>();
//        for (final File fileEntry : folder.listFiles()) {
//            String pureFileName = fileEntry.getName();
//            try {
//                Integer intVal = MathUtil.getValueFromIntegerString(pureFileName);
//                if (intVal <= endDate && intVal >= beginDate) {
//                    list.add(pureFileName);
//                }
//            } catch (ImsException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("list size: " + list.size());
    }
}