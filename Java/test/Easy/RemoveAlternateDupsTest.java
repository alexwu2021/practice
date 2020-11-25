package Easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAlternateDupsTest {

    @Test
    public void removeAlternateDuplicates() {
        String source = "you got beautiful eyes";
        String exected ="you gtbeaiful es";


        RemoveAlternateDups removeAlternateDups = new RemoveAlternateDups();
        char[] src = source.toCharArray();
        removeAlternateDups.removeAlternateDuplicates(src);
        String actual = (new String(src)).trim();
        Assert.assertEquals(exected, actual);
    }
}