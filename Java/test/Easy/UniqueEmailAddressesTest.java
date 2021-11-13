package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueEmailAddressesTest {

    @Test
    public void numUniqueEmails() {
        UniqueEmailAddresses sol = new UniqueEmailAddresses();
        String[] emails;
        int expected, actual;

        emails = new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        expected = 2;
        actual = sol.numUniqueEmails(emails);
        Assert.assertEquals(expected, actual);
    }
}