package com.docmatter.ims.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class ReferenceDataManagerTest {

    @Test
    void processBaseReferenceDataFiles() {
        try {
            ReferenceDataManager.me().processBaseReferenceDataFiles();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(ReferenceDataManager.me().getUserIdSet().size() > 0 );
        Assertions.assertTrue(ReferenceDataManager.me().getUserId2NugIdSetMap().size() > 0 );
    }

    @Test
    void saveToDatabase() {
        //String referenceDataUser2NuglistFileName = ImsConstant.REFERENCE_DATA_USER_2_NUGLIST_FILE_NAME;

    }
}