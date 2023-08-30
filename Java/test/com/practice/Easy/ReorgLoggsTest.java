package com.practice.Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReorgLoggsTest {

    @Test
    public void reorderLogFiles() {
        ReorgLoggs reorgLoggs = new ReorgLoggs();
        String[] sa = new String[]{ "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo" };
        String[] ret = reorgLoggs.reorderLogFiles(sa);
        assert(ret != null && ret.length == 5 && ret[1].equals("1ab iadf"));
    }
}