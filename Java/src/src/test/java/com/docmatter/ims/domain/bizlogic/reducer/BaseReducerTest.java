package com.docmatter.ims.domain.bizlogic.reducer;

import com.docmatter.ims.domain.model.ProcessingErrorCodeEnum;
import com.docmatter.ims.domain.model.ProcessingResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseReducerTest {

    @Test
    void getReducerFile() {
    }

    @Test
    void doReductionFor() {
        BaseReducer baseReducer = new BaseReducer(20200101, 20200701);
        ProcessingResult processingResult = baseReducer.doReductionFor();
        Assertions.assertTrue(processingResult.getErrorCode() == ProcessingErrorCodeEnum.success);


    }


}