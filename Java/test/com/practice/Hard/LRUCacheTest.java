package com.practice.Hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {
    private LRUCache lruCache;

    @Test
    public void get() {
        int actual, expected;
        lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        actual = lruCache.get(1);
        expected = 1;
        assert (actual == expected);

        lruCache.put(3, 3);

        actual = lruCache.get(2);
        expected = -1;
        assert (actual == expected);

        lruCache.put(4, 4);

        actual = lruCache.get(1);
        expected = -1;
        assert (actual == expected);

        actual = lruCache.get(3);
        expected = -1;
        assert (actual == expected);

        actual = lruCache.get(4);
        expected = -1;
        assert (actual == expected);

    }


}