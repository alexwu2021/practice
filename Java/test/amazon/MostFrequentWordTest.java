package amazon;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MostFrequentWordTest {

    @Test
    public void mostFrequentWord() throws Exception {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        String Output =  "ball";

        MostFrequentWord sol = new MostFrequentWord();
        String result = sol.mostFrequentWord(paragraph, banned);
        Assert.assertEquals(Output, result);
    }
}