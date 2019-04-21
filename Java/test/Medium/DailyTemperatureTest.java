package Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperatureTest {

    @Test
    public void dailyTemperatures() {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int [] temperatures, res;
        int i;

        temperatures = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        res = dailyTemperature.dailyTemperatures(temperatures);
        assert (res != null);
        i = 0;
        assert (res[i++] == 1
                && res[i++] == 1
                && res[i++] == 4
                && res[i++] == 2
                && res[i++] == 1
                && res[i++] == 1
                && res[i++] == 0
                && res[i++] == 0) ;


        temperatures = new int[] {89,62,70,58,47,47,46,76,100,70};
        res = dailyTemperature.dailyTemperatures(temperatures);
        assert (res != null);
        i = 0;
        assert (res[i++] == 8
                && res[i++] == 1
                && res[i++] == 5
                && res[i++] == 4
                && res[i++] == 3
                && res[i++] == 2
                && res[i++] == 1
                && res[i++] == 1
                && res[i++] == 0
                && res[i++] == 0) ;



        temperatures = new int[] {34,80,80,80,34,80,80,80,34,34};
        res = dailyTemperature.dailyTemperatures(temperatures);
        assert (res != null);
        i = 0;
        assert (res[i++] == 1
                && res[i++] == 0
                && res[i++] == 0
                && res[i++] == 0
                && res[i++] == 1
                && res[i++] == 0
                && res[i++] == 0
                && res[i++] == 0
                && res[i++] == 0
                && res[i++] == 0) ;
    }
}