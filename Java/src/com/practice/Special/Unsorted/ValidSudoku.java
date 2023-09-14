package com.practice.Special.Unsorted;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with an integer N. The next N2 lines describe a completed Sudoku solution, with each line contains exactly N2 integers. All input integers are positive and less than 1000.
 *
 * Output
 * For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is "Yes" (quotes for clarity only) if it is a valid solution, or "No" (quotes for clarity only) if it is invalid. Note that the judge is case-sensitive, so answers of "yes" and "no" will not be accepted.
 */
public class ValidSudoku {

    public static void main(String[] args) throws FileNotFoundException {
        List<int[][]>allInputs = new ArrayList<>();
        ValidSudoku sol = new ValidSudoku();
        GetInputs(allInputs);
        for(int i=0; i<allInputs.size(); ++i){
            boolean res = sol.isValid(allInputs.get(i));
            System.out.println(String.format("Case #%d: %s", i + 1, res));
        }
        return;
    }

    private static void GetInputs(List<int[][]> allInputs) throws FileNotFoundException {
        //URL path = ValidSudoku.class.getResource("input.txt");
        //File f = new File(path.getFile());
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0; i<n; ++i)
            GetInputs_ScanOne(allInputs, scanner);
        scanner.close();
    }

    private static void GetInputs_ScanOne(List<int[][]>allInputs, Scanner scanner) throws FileNotFoundException {
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

    private Set<Integer> GetSet(int n){
        Set<Integer>set = new HashSet<>();
        for(int i=1; i<=n; ++i)
            set.add(i);
        return set;
    }

    public boolean isValid(int[][]sdk){
        int n = sdk.length;
        int m = (int)Math.sqrt(n);
        for(int r=0; r < n; ++r){
            Set<Integer>st = GetSet(n);
            for(int c=0; c < n; ++c){
                if(r % m == 0 && c %m == 0){
                    if(!isValid(sdk, r, c, m)){
                        return false;
                    }
                }
                int curr = sdk[r][c];
                st.remove(curr);
            }
            if(st.size() > 0)
                return false;
        }
        return true;
    }

    public boolean isValid(int[][]sdk, int rr, int cc, int len){
        int n = sdk.length;
        Set<Integer>st = GetSet(n);
        for(int r=rr; r < rr + len; ++r){
            for(int c=cc; c < cc + len; ++c){
                int curr = sdk[r][c];
                st.remove(curr);
            }
        }
        if(st.size() > 0)
            return false;
        return true;
    }
}
