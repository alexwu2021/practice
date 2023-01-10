package com.docmatter.ims.service;

import com.docmatter.ims.setting.MeasuredOperation;

public interface IMeasuredOperationService {
    Integer getMappedValueByMeasuredOperation(MeasuredOperation measuredOperation);

    Integer getMappedValueByMeasuredOperationRepr(String repr);
}
