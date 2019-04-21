package Medium;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.List;

public class NumberPicker {

    static enum Result {
        Win, Lose, Draw
    }

    /** Summarizes a list into a single value, starting from start to end, inclusive
     *
     * @param input
     * @param start
     * @param end
     * @return
     */

    // @Memoized is commented off because I am using maven not groovy
    //  @Memoized

    int valueOfList(List<Integer> input, int start, int end) {
        if(input == null || input.isEmpty() || start < 0 || end > input.size() - 1  || start > end)
            return 0;

        int sum = 0;
        for(int i = start; i<= end; ++i){
            sum += input.get(i);
        }
        return sum;
    }

    /** The idea is to use top down dynamic programming to solve this problem.
     *  Bottom up Special.DP should run faster but harder to construct
     *
     *
     * Always assume I play first.
     *
     * Given a list of numbers, tells who can win the game.
     * @param input the list of numbers
     * @return The result of the game
     */
    public Result findWinner(List<Integer> input) throws Exception {
        if (input == null || input.isEmpty()){
            throw new InvalidArgumentException(new String[]{"Exception encountered " +
                    "in findWinner, parameter input is either null or empty"});
        }

        int len = input.size();
        int [][] myGains = new int[len][len];

        // the motivation to use a boolean grid is to make the program generic and agnostic of the value range
        // that is, we can accommodate negative inputs
        boolean [][] valid = new boolean[len][len];

        for(int i = 0; i < len; ++i){
            for(int j = 0; j < len; ++j){
                valid[i][j] = false;
                if(i == j){
                    myGains[i][j] = input.get(i); // trivia case
                    valid[i][j] = true;
                }
            }
        }

        int totalValue = valueOfList(input, 0, len-1);

        calculateMyGains(input, 0, len -1, myGains, valid);

        int result = 2 * myGains[0][len-1];
        if(result < totalValue)
            return Result.Lose;
        else if(result > totalValue){
            return Result.Win;
        } else{
            return Result.Draw;
        }
    }

    /** Recursively calculate the gains for the play who is going to make the choice for the next step
     *  Though the narrative is I, this function is good for me and my opponent.
     *  Who ever enters this function will pick first.
     *
     * @param input
     * @param start
     * @param end
     * @param myGains
     * @param valid
     * @return
     * @throws Exception
     */
    private int calculateMyGains(List<Integer> input, int start, int end, int [][] myGains, boolean[][] valid) throws Exception {
        if(start < 0 || end > input.size() - 1  || start > end) return 0;

        if(valid[start][end])
            return myGains[start][end];

        // below are three base cases for calculating gains function
        // including the earlier trivia case above
        // base case 1: the player is to pick the biggest of the two numbers
        if(end - start == 1){
            myGains[start][end] = Math.max(input.get(start), input.get(end));
            valid[start][end] = true;
            return myGains[start][end];
        }

        // base case 2: the player is to pick the two ends of the three number list
        if(end - start == 2){
            myGains[start][end] = input.get(start) + input.get(end);
            valid[start][end] = true;
            return myGains[start][end];
        }


        // problem reduction, or Special.DP transition function are explained in two cases
        //I have two choices: pick the head or the tail

        // case 1: I pick the head

        // I pick the first element, then my opponent will have two choices:
        // s/he will pick either the very second first , leaving me with facing 2, n-1,
        // or s/he will pick either the last, leaving me with facing 1, n-2
        int opponentsGainAfterIPickHead =  calculateMyGains(input, start+1, end, myGains, valid);
        int myGain_PickingHead = input.get(start) + valueOfList(input,start + 1, end ) - opponentsGainAfterIPickHead;


        // case 2: I pick the tail

        // I pick the last element, then my opponent will have two choices:
        // s/he will pick either the very first , leaving me with facing 1, n-2; or
        // s/he will pick either the second last, leaving me with facing 0, n-3
        int opponentsGainAfterIPickTail =  calculateMyGains(input, start, end - 1, myGains, valid);
        int myGains_PickingTail = input.get(end) +  valueOfList(input, start, end - 1) - opponentsGainAfterIPickTail;


        //I, the current player, has the freedom to choose which end to pick, so s/he will gain the max of the two cases
        myGains[start][end] = Math.max(myGain_PickingHead, myGains_PickingTail);
        valid[start][end] = true;

        return myGains[start][end];
    }
}

