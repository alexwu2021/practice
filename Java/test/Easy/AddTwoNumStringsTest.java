package Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumStringsTest {

    @Test
    public void addStrings() {

        AddTwoNumStrings addTwoNumStrings = new AddTwoNumStrings();

        String res = addTwoNumStrings.addStrings("81239", "99855");

        assert (res.equals("181094"));
    }
}