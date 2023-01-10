package com.docmatter.ims.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDataFeedService {

    void populateInMemoryDataStructure(Map<Integer, Map<Integer, Map<Integer, Integer>>> mp, List<Integer> users, List<Integer>days, List<Integer> activities);
}
