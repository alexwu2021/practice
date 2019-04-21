package Medium;

import Medium.NumberPicker;
import Medium.OptimalGameStrategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptimalGameStrategyTest {

    int getTotal(int [] arr){
        int ret = 0;
        for (int i =0; i<arr.length; ++i){
            ret += arr[i];
        }
        return ret;
    }


    @Test
    public void optimalStrategyOfGame() throws Exception {
        OptimalGameStrategy optimalGameStrategy = new OptimalGameStrategy();
        NumberPicker numberPicker = new NumberPicker();

        Random random =  new Random(System.currentTimeMillis());

        for(int k=0; k<100; ++k){
            List<Integer> list = new ArrayList<>();
            int size = 3 + random.nextInt(3);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(int i=0; i<size; ++i){
                int temp = 3 + random.nextInt(30);
                sb.append(temp);
                if(i <= size-2)
                    sb.append(",");
                list.add(temp);
            }
            sb.append("]");

            int [] nArray = new int[list.size()];
            for(int j=0; j<list.size(); ++j){
                nArray[j] = list.get(j);
            }

            int res = optimalGameStrategy.optimalStrategyOfGame(nArray, nArray.length);
            int total = getTotal(nArray);
            NumberPicker.Result OgsResult = NumberPicker.Result.Draw;
            if(2*res > total){
                OgsResult = NumberPicker.Result.Win;
            }else  if(2*res < total){
                OgsResult = NumberPicker.Result.Lose;
            }

            NumberPicker.Result myResult = numberPicker.findWinner(list);
            System.out.println("\nnums: " + sb.toString());
            System.out.println("round: " + k + ", OGS result: " + OgsResult + ", my result: " + myResult);
            assert(OgsResult.equals(myResult));

            list.clear();

        }

    }
}