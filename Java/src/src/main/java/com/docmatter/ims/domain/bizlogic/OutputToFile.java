package com.docmatter.ims.domain.bizlogic;

import com.docmatter.ims.context.SpringContext;
import com.docmatter.ims.service.MeasuredOperationService;

import java.util.Map;

public class OutputToFile {
    protected MeasuredOperationService getOperationService() {
        return SpringContext.getBean(MeasuredOperationService.class);
    }
}
