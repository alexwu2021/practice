package Medium;


public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {
        if (X >= Y) return X - Y;
        return (Y & 1) == 0 ? 1 + brokenCalc(X, Y/2) : 1 + brokenCalc(X, Y + 1);
    }


    /** This is borrowed from awice.
     *  very clever algo
     *  pass on line judge
     *
     * @param X
     * @param Y
     * @return
     */
    public int brokenCalc2(int X, int Y) {
        int ans = 0;

        // prepare Y s.t. Y is smaller than X
        while(Y > X){
            if(Y % 2 == 0){
                Y = Y / 2;
            } else {
                Y += 1;
            }
            ans += 1;
        }

        // then this is trivia since all we need to do
        // is subtract 1 from X till they are equal
        return ans + X - Y ;
    }

}