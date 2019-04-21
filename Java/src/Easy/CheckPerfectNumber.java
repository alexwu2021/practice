package Easy;

public class CheckPerfectNumber {
  
     public boolean checkPerfectNumber(int num) {
      if (num == 1) return false;
        
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) { //why compiler not complain at this line?
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;
         
         /* num = 28
            n = 6
            
            i = 2, sum = 2 + 14 = 16
            i = 3   
            i = 4  sum   = 16 + 4 + 7 = 27
            i = 5
            i = 6
            
            so we need a compensation for sum: sum += 1
         
         */
        
        return sum == num;
     }
}