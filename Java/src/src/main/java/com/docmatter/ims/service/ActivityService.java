package com.docmatter.ims.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActivityService implements IActivityService{
    private static List<Integer> userActivityLists = Arrays.asList(new Integer[]{1, 2, 4, 8, 11, 12, 14, 18, 26, 27,
            33, 55, 77, 101, 222, 233, 234, 235, 255, 277, 300, 301, 302, 303, 304, 305, 306, 307, 310, 333, 345, 346,
            401, 423, 435, 439, 470, 471, 475, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 501, 503, 505, 506, 507
    });

    @Override
    public Set<Integer> getAllSupportedActivities(int subjectId) {
        Set<Integer> ret = new HashSet<>();
        switch (subjectId){
            case 1: // users
                for(Integer a: userActivityLists)
                    ret.add(a);
                break;
            default: break;
        }
        return ret;
    }
}
