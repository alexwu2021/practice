package Medium;

import Medium.NumberPicker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPickerTest {

    @Test
    public void findWinner() throws Exception {

        NumberPicker numberPicker = new NumberPicker();

        List<Integer> input = new ArrayList<>();
        NumberPicker.Result result;

//        // trivia case 1
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{3, 1}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Win));
//
//        // trivia case 2
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{1, 9, 5}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Lose));
//
//        // trivia case 3
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{5, 5}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Draw));
//
//
//        // medium case 1
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{6, 5, 5, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Draw));
//
//        // medium case 2
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{5, 5, 5, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Win));
//
//        // medium case 3
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{1, 3, 99, 2, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Lose));
//
//
//        // hard case 1
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{6, 6, 6, 6, 6, 6, 6, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Draw));
//
//        // hard case 2
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{2, 6, 5, 1, 4, 8, 11, 3, 5, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Win));
//
//        // hard case 3
//        input.clear();
//        input.addAll(Arrays.asList(new Integer[]{2, 100, 0, 115, 6}));
//        result = numberPicker.findWinner(input);
//        assert(result.equals(NumberPicker.Result.Lose));


        input.clear();
        input.addAll(Arrays.asList(new Integer[]{13,3,16,26}));
        result = numberPicker.findWinner(input);
        assert(result.equals(NumberPicker.Result.Win));


    }
}