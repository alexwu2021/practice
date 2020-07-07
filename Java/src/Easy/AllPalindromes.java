import java.util.ArrayList;

public class AllPalindromes {
    //Goal: find all the palindromes in a string
    String rawStr;
    int strLen; //string length
    int arrLen; //final array length
    char[] arr; //array of spaced characters
    boolean hasMiddle; //true if odd length string
    ArrayList<String> palindromeList = new ArrayList<String>();

    private void printArr(){
        for(int i = 0; i < arrLen; i++){
            if(arr[i] == 0){ //default empty ASCII value
                System.out.print(" * ");
            }
            else{
                System.out.print(arr[i]);
            }
        }
    }

    public void displayPalindromes(){
        for(String s:palindromeList){
            System.out.println(s);
        }
    }

    public AllPalindromes(String s){ //change void to [] later
        //copy values
        this.rawStr = s;
        this.strLen = s.length();
        this.hasMiddle = (s.length() % 2 == 1);
        this.arrLen = 2*strLen + 1; //"aba" turns into "*a*b*a*"

        //collect characters into a spaced array
        arr = new char[arrLen];
        for(int i = 0; i < strLen ; i++){
            arr[2*i + 1] = rawStr.charAt(i);
        }

        //check
        printArr();

        //traversal
        for(int i = 1; i < arrLen-1; i+= 1){
            //traverse arr starting from the first char, and ending 1 before the end (last char)
            int center = i; //center of traversal
            int left = center - 1;
            int right = center + 1;
            String temp = String.valueOf(arr[i]);
            System.out.println("starting a new temp: " + temp);
            while((arr[left] == arr[right]) && (left > 0 && right < arrLen-1)){
                if(arr[left] != 0){
                    temp = arr[left] + temp + arr[right];
                    System.out.println("adding " + temp);
                    palindromeList.add(temp);
                }
                left --;
                right ++;
            }
            System.out.println("no more palindromes here");
        }

        //now display
        displayPalindromes();

    }

    public static void main(String[] args){

        AllPalindromes ap = new AllPalindromes("abbcbbacdeefeeddeefeedcabbcbbaqqqqq");

    }
}
