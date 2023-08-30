package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortFeatureByPopularityTest {

    @Test
    public void sortFeatures() {

        SortFeatureByPopularity sol = new SortFeatureByPopularity();
        String [] features, popularities;
        String [] actual, expected;

        features = new String[]{"gm","gueh","pagukeo","mjfmxkpt","nxehzmy","gupciaqa","szpke","m","fafxokiwj","vnolbwofn","rpsjw","vkaouipu","xcqshtxzn","rzsntyo","crcevj","oec","gflhav","uvgvrcaat"};
        popularities = new String[]{"gyr crcevj oec mjfmxkpt kkecx lzfkaylnlv m rurltdf bbxhe nxehzmy","wavzoewzs fcoxpmy vnolbwofn gm xcqshtxzn gm wvod szpke mjfmxkpt uvgvrcaat","uvgvrcaat uvgvrcaat sc xft vkaouipu rpsjw gyusm bbwuvi pagukeo cgxoylhuva","kv gzkd evlz uvgvrcaat oec mjfmxkpt bazhpl xcqshtxzn xz mjfmxkpt","szpke vkaouipu gupciaqa fjvct qykhiiwxhi fvkg aa oec nxehzmy uinreddwh","nxehzmy osu hnb urllg uvgvrcaat gm rpsjw muyza nxehzmy gvk","gupciaqa meix m mmfkox m tq gupciaqa hhoes pagukeo yoegfotbrs","xcqshtxzn sbzvqgxyd wgwyxkxl szpke pkdhgta laqpvfhoh crcevj jkdfwfvxa hrsqbjulr gm","sjoitocx szpke qstsf gflhav vnolbwofn qnjaklkw zgzhaseu fafxokiwj vp fafxokiwj"};
        actual = sol.sortFeatures(features, popularities);
        expected = new String[]{"szpke","uvgvrcaat","gm","mjfmxkpt","nxehzmy","xcqshtxzn","oec","pagukeo","gupciaqa","m","vnolbwofn","rpsjw","vkaouipu","crcevj","fafxokiwj","gflhav","gueh","rzsntyo"};

        //System.out.println("actual: " + String.join(Arrays.asList(actual), ","));
        Assert.assertArrayEquals(expected, actual);
    }
}