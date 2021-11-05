package Easy;

import org.junit.Test;

import java.util.List;

public class FindCommonCharactersTest {

    @Test
    public void commonChars() {

        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] sa = new String[]{"bella","label","roller"};
        List<String> res = findCommonCharacters.commonChars(sa);
        assert(res.size() == 3);
    }


}