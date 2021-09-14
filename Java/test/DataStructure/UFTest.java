package DataStructure;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.*;

public class UFTest {

    @Test
    public void find_and_union() throws FileNotFoundException {

        /**
         * Reads an integer {@code n} and a sequence of pairs of integers
         * (between {@code 0} and {@code n-1}) from standard input, where each integer
         * in the pair represents some element;
         * if the elements are in different sets, merge the two sets
         * and print the pair to standard output.
         *
         * @param args the command-line arguments
         */

        UF uf;
        int actual, expected;

        URL path = UF.class.getResource("tynyuf.txt");
        File f = new File(path.getFile());
        Scanner scanner = new Scanner(f);

        int n = scanner.nextInt();
        uf = new UF(n);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
        }
        scanner.close();

        expected = 2;
        actual = uf.count();
        Assert.assertEquals(expected,actual);
    }

}