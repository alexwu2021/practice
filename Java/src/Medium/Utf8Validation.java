package Medium;

/**
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1
 * bytes with most significant 2 bits being 10
 *
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to
 * store the data. This means each integer represents only 1 byte of data.
 */
public class Utf8Validation {

    private final int[] masks = {128, 64, 32, 16, 8}; // corresponding to valid types: 0, 1, 2, 3, 4

    /*
     * based on royalpen's solution
     * if it is type 2 or 3 or 4, check whether the following 1, 2, and 3 byte(s) are of type 1 or not
     * if not, return false;
     *
     */
    public boolean validUtf8(int[] data) {
        int len = data.length;
        for (int i = 0; i < len; ++i) {
            int type = getType(data[i]);
            if (type == 0) continue;
            if (type <= 1) return false;

            // boundary check
            if (i > len - type) return false;

            // for type 2, 3, or 4
            // check if the following bytes is of continuation type which is 1
            //TODO:  what bewilders me is that i can not substitute j for i in the following while loop. WHY???
            while (type > 1) {
                if (getType(data[++i]) != 1) return false;
                type--;
            }
        }
        return true;
    }

    int getType(int num) {
        for (int i = 0; i < masks.length; ++i) if ((masks[i] & num) == 0) return i;
        return -1;
    }
}
