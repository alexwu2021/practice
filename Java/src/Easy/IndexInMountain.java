package Easy;

public class IndexInMountain {


    public int peakIndexInMountainArray(int[] A) {
        int l = 0, r = A.length - 1, m;
        while (l < r) {
            m = l + ((r - l)>>1);
            if (A[m] < A[m + 1])
                l = m + 1;
            else
                r = m;
        }
        return l;
    }
    public int peakIndexInMountainArray_testfirst(int[] arr) {
        int n = arr.length;
        boolean isEsc = true;
        int j = 0;
        while(j<n-1 && arr[j] == arr[j+1])
            j++;
        if(arr[j] > arr[j+1]) isEsc = false;

        if(isEsc){
            int i = 0;
            while(i < n-1 && arr[i] < arr[i+1]){
                i++;
            }
            return i;
        }else{
            int i = n-1;
            while(i > 0 && arr[i] > arr[i-1]){
                i--;
            }
            return i;
        }
    }

    public int peakIndexInMountainArray_lee215(int[] A) {
        for (int i = 1; i + 1 < A.length; ++i) if (A[i] > A[i + 1]) return i;
        // for (int i = A.length - 1; i > 0; --i) if (A[i] > A[i - 1]) return i;
        return 0;
    }
}
