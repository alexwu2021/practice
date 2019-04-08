package Unclassified;

import org.junit.Test;

public class GoatLatinTest {

    @Test
    public void toGoatLatin() {

        String S = "I speak Goat Latin";
        GoatLatin goatLatin = new GoatLatin();
        String ret = goatLatin.toGoatLatin(S);
        assert(ret.equals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa"));
    }
}