package Easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AccountMergeTest {

    @Test
    public void accountsMerge() {
        AccountMerge accountMerge = new AccountMerge();
        List<List<String>> expected, actual, input;

        input = new ArrayList<>();
        input.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}));
        input.add(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));
        input.add(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}));
        input.add(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));
        expected = new ArrayList<>();
        expected.add(Arrays.asList(new String[]{"John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"}));
        expected.add(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));
        expected.add(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));

        actual = accountMerge.accountsMerge(input);


        for(List<String>act : actual){
            for(String a : act){
                boolean found = false;
                for(List<String>exp : expected){
                    if(exp.contains(a)){
                        found = true;
                    }
                }
                Assert.assertTrue(found);
            }
        }

        for(List<String>exp : expected){
            for(String e : exp){
                boolean found = false;
                for(List<String>act : actual){
                    if(act.contains(e)){
                        found = true;
                    }
                }
                Assert.assertTrue(found);
            }
        }
    }
}