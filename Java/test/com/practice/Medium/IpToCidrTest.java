package com.practice.Medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IpToCidrTest {

    @Test
    public void ipToCIDR() {
        IpToCidr ipToCidr = new IpToCidr();
        String str = "255.0.0.7";
        int n = 10;
        List<String> ans = ipToCidr.ipToCIDR(str, n);
        assert(ans.size() == 3 );
        assert(ans.contains("255.0.0.7/32"));
        assert(ans.contains("255.0.0.8/29"));
        assert(ans.contains("255.0.0.16/32"));
    }
}