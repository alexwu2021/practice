package com.practice.Medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SearchSuggestionsSystemTest {

    @Test
    public void suggestedProducts() {
        SearchSuggestionsSystem sol = new SearchSuggestionsSystem();
        String[] products;
        String searchWord;
        List<List<String>>actual, expected;

//        Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
//        Output: [
//["mobile","moneypot","monitor"],
//["mobile","moneypot","monitor"],
//["mouse","mousepad"],
//["mouse","mousepad"],
//["mouse","mousepad"]
//]
        products = new String[]{"mobile","mouse","moneypot","monitor","mousepad"};
        searchWord = "mouse";

        expected= new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"mobile","moneypot","monitor"}));
        expected.add(Arrays.asList(new String[]{"mobile","moneypot","monitor"}));

        expected.add(Arrays.asList(new String[]{"mouse","mousepad"}));
        expected.add(Arrays.asList(new String[]{"mouse","mousepad"}));
        expected.add(Arrays.asList(new String[]{"mouse","mousepad"}));


        actual = sol.suggestedProducts(products, searchWord);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
}