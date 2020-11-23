package amazon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionLogsTest {

    @Test
    public void findUserIdsWithAtLeastNumberOfTransactions() {
        TransactionLogs transactionLogs = new TransactionLogs();
        String[] src = new String[]{
                "345366 89921 45",
                "029323 38239 23",
                "38239 345366 15",
                "029323 38239 77",
                "345366 38239 23",
                "029323 345366 13",
                "38239 38239 23"
        };
        List<String> actual =transactionLogs.findUserIdsWithAtLeastNumberOfTransactions(src, 3);
        List<String> expected = new ArrayList<>();

        expected.add("345366");
        expected.add("38239");
        expected.add("029323");

        Assert.assertEquals(expected.size(), actual.size());
        for(String exp: expected){
            Assert.assertTrue(actual.contains(exp));
        }


        for(String act: actual){
            Assert.assertTrue(expected.contains(act));
        }

    }
}