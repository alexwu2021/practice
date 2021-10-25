package Medium;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void exist() {

        WordSearch sol = new WordSearch();
        char[][] boards;
        String word;
        boolean actual, expected;

        boards = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "ABCCED";
        expected = true;
        actual = sol.exist(boards, word);
        Assert.assertEquals(expected, actual);


        boards = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "SEE";
        expected = true;
        actual = sol.exist(boards, word);
        Assert.assertEquals(expected, actual);



        boards = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "ABCB";
        expected = false;
        actual = sol.exist(boards, word);
        Assert.assertEquals(expected, actual);



        boards = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        word = "AAB";
        expected = true;
        actual = sol.exist(boards, word);
        Assert.assertEquals(expected, actual);

    }
}