package LC110;

import java.util.*;

public class Q4 {

    public static void main(String args[]) {

        System.out.print(7 % 5);
    }


    
    

    public static int util1(List<Integer> nums) {
        int candidate = 0, count = 0;
        int arr[] = new int[nums.size()];
        int k = 0;
        for (int i : nums) {
            candidate = (count == 0) ? i : candidate;
            count += (i == candidate) ? 1 : -1;
            arr[k++] = i;
        }
        return getTime(arr, candidate);
    }

    public static int getTime(int arr[], int n) {
        boolean swapHappened = false;
        ;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                continue;
            } else if (arr[i] < n) {
                arr[i] = Math.min(arr[i], Math.min(arr[(i - 1 + arr.length) % arr.length], (arr[i + 1] % arr.length)));
                swapHappened = true;
            } else {
                arr[i] = Math.max(arr[i], Math.max(arr[(i - 1 + arr.length) % arr.length], (arr[i + 1] % arr.length)));
                swapHappened = true;
            }
        }
        if (!swapHappened) {
            return 0;
        }
        return getTime(arr, n) + 1;
    }

}
