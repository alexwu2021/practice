package Kickstart;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ValidSudokuTest {

    private void GetInputs(List<int[][]>allInputs) throws FileNotFoundException {
        URL path = ValidSudokuTest.class.getResource("input.txt");
        File f = new File(path.getFile());
        Scanner scanner = new Scanner(f);
        int n = scanner.nextInt();
        for(int i=0; i<n; ++i)
            GetInputs_ScanOne(allInputs, scanner);
        scanner.close();
    }

    private void GetInputs_ScanOne(List<int[][]>allInputs, Scanner scanner) throws FileNotFoundException {
        int m = scanner.nextInt();
        int n = m * m;
        int[][]sdk = new int[n][n];
        int i;
        for(i=0; i<n; ++i)
            sdk[i] = new int[n];
        for(int r=0; r<n; ++r) {
            for (int c = 0; c < n; ++c) {
                sdk[r][c] = scanner.nextInt();
            }
        }
        allInputs.add(sdk);
    }

    @Test
    public void main() throws FileNotFoundException {
        List<int[][]>allInputs = new ArrayList<>();
        ValidSudoku sol = new ValidSudoku();
        GetInputs(allInputs);
        for(int i=0; i<allInputs.size(); ++i){
            boolean res = sol.isValid(allInputs.get(i));
            System.out.println(String.format("Case #%d: %s", i + 1, res));
        }
        return;
    }
}