package com.docmatter.ims.domain.bizlogic.reference;

import com.docmatter.ims.domain.model.ImsUser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UgRefCache {
    private Map<Integer, Integer> _nugId2NugId;
    private Map<ImsUser, List<Integer>> _userId2NugIdList;

    public UgRefCache(){
        this._nugId2NugId = new HashMap<>();
        this._userId2NugIdList = new HashMap<>();
    }

    public void exportToFile(){

    }

    public void populateNugForest(){

    }

    public void populateUser2NugList(){

    }
}
