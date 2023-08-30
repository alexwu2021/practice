package com.practice.Easy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SubdomainVisitCountTest {

    @Test
    public void subdomainVisits() {

        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        String[] sa = new String[]{"9001 discuss.leetcode.com"};
        List<String> res = subdomainVisitCount.subdomainVisits(sa);
        assert(res.size() == 3);
    }
}