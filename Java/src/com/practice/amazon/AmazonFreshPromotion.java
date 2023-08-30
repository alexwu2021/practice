package com.practice.amazon;

import java.util.List;

public class AmazonFreshPromotion {
    public int checkIfIsAWinner(List<List<String>>codeList, List<String>shoppingCart){
        StringBuilder regex = new StringBuilder(".*");
        for(List<String> cl : codeList){
            for(String str : cl)
                regex.append(str.equals("anything") ? ".+" : str);
            regex.append(".*");
        }
        StringBuilder cart = new StringBuilder();
        for(String str : shoppingCart)
            cart.append(str);
        return cart.toString().matches(regex.toString()) ? 1 : 0;
    }
}
