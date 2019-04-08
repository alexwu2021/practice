package Easy;

public class CanPlaceFlowers {

    /** this works and passed oj but it is too ugly!
     *  however, it does not alter the content of the parameter flowerbed
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers_mine(int[] flowerbed, int n) {
        if (n <= 0) return true;
        if(flowerbed == null || flowerbed.length <= 0)
            return false;

        int count = 0;
        int i = 0, j = 0, len = flowerbed.length;
        if(len == 1 && flowerbed[0] == 0 && n == 1) return true;

        while(i < len) {
            while(i < len && flowerbed[i] == 1) i++;
            i--; //let i be -1 or the index of the last 1s
            j = i + 1;
            while(j < len && flowerbed[j] == 0){
                if(i == -1 && (j + 1 < len && flowerbed[j + 1] != 1)){
                    i = 0;
                    count++;
                }
                else if((j - i) % 2 == 0 ){
                    if(j == len -1 || (j + 1 < len && flowerbed[j + 1] != 1))
                        count++;
                }
                j++;
            }
            i = j;
        }
        return count >= n;
    }
}
