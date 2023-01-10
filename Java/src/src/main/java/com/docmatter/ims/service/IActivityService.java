package com.docmatter.ims.service;

import java.util.Set;

public interface IActivityService {
    Set<Integer> getAllSupportedActivities(int subjectId);
}
