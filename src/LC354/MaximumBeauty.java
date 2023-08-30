package LC354;

import java.util.*;

public class MaximumBeauty {
    
    public static void main(String args[]) {
        int arr[] = { 52, 34 };
        System.out.print(util1(arr, 21));
    }

    // just simple sorting and then window...

    public static int util1(int arr[], int k) {
        Arrays.sort(arr);
        int maxWindow = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            if (isValid(arr[start], arr[end], k)) {
                maxWindow = Math.max(maxWindow, (end - start + 1));
                end++;
            } else {
                start++;
            }
        }
        return maxWindow;
    }

    public static boolean isValid(int a, int b, int k) {
        if (a == b) {
            return true;
        } else if ((a + k) >= (b - k)) {
            return true;
        } else {
            return false;
        }
    }
}
