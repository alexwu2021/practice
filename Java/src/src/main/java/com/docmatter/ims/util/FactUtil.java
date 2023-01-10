package com.docmatter.ims.util;

import com.docmatter.ims.domain.Fact;
import com.docmatter.ims.setting.MeasuredOperation;

public class FactUtil {
    public static Fact convertToFact(Long userId, Integer measuredOperationId){
        MeasuredOperation measuredOperation = new MeasuredOperation(measuredOperationId);
        return new Fact(userId, measuredOperation);
    }
}
