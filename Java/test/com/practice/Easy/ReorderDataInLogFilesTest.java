package com.practice.Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ReorderDataInLogFilesTest {

    @Test
    public void reorderLogFiles() {

        ReorderDataInLogFiles sol = new ReorderDataInLogFiles();
        String[] logs, expected, actual;


//        Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//        Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//        Explanation:
//        The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
//                The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
        logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        expected = new String[]{"let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        actual = sol.reorderLogFiles(logs);
        Assert.assertArrayEquals(expected, actual);


//        Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//        Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

        logs = new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        expected = new String[]{"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"};
        actual = sol.reorderLogFiles(logs);
        Assert.assertArrayEquals(expected, actual);



        logs = new String[]{"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"};
        expected = new String[]{"ubd cujg j d yf","u lrvmdt ykmox","4 nivgc qo z i","uhb rfrwt qzx r","ys0 splqqxoflgx","0 tllgmf qp znc","6p tzwmh ige mc","ns 566543603829","ha6 1 938 376 5","3yx 97 666 56 5","d 84 34353 2249","s 1088746413789","ah4 4209164350","rap 7729 8 125","apx 814023338 8"};
        actual = sol.reorderLogFiles(logs);
        System.out.println(String.join(", ", Arrays.asList(expected)));
        System.out.println(String.join(", ", Arrays.asList(actual)));
        Assert.assertArrayEquals(expected, actual);
    }
}