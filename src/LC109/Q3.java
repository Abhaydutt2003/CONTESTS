package LC109;

import java.util.*;

public class Q3 {

    public static void main(String args[]) {
        int arr[] = { 38, 92, 23, 30, 25, 96, 6, 71, 78, 77, 33, 23, 71, 48, 87, 77, 53, 28, 6, 20, 90, 83, 42, 21, 64,
                95, 84, 29, 22, 21, 33, 36, 53, 51, 85, 25, 80, 56, 71, 69, 5, 21, 4, 84, 28, 16, 65, 7 };
        int x = 52;
        System.out.print(util3(arr, x));
    }

    //got the feel of this

    public static long util3(int arr[], int x){
        long startWithOdd =0l;
        long startWithEven = 0l;
        if(arr[0]%2 == 0){
            startWithOdd = -x;
        }else{
            startWithEven = -x;
        }


        for(long i:arr){
            if(i%2 == 0){
                long max = Math.max(startWithEven+i,(startWithOdd-x+i));
                startWithEven = max;
            }else{
                long max = Math.max(startWithOdd+i,(startWithEven-x+i));
                startWithOdd = max;
            }
        }
        return Math.max(startWithEven,startWithOdd);
    }

    // firstly let use know how to calculate the parity of a number
    public static void printParity(int n) {
        boolean oddParirty = false;
        while (n != 0) {
            oddParirty = !oddParirty;
            n &= (n - 1);
        }
        if (oddParirty) {
            System.out.print("odd");
        } else {
            System.out.print("even");
        }
    }

    /*
     * if two numbers are present , either both should be even or both should be odd
     * else their parities is different
     */

    public static long util2(int arr[], int x) {
        long dp[][] = new long[arr.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return arr[0] + helper2(arr, x, 0, arr[0] % 2, dp);
    }

    public static long helper2(int arr[], int x, int index, int prev, long[][] dp) {
        if (index + 1 == arr.length) {
            return 0;
        }
        if (dp[index][prev] != -1) {
            return dp[index][prev];
        }
        long jump = 0;
        if (arr[index+1] % 2 == prev) {
            jump = helper2(arr, x, index + 1, prev, dp) + arr[index + 1];
        } else {
            jump = helper2(arr, x, index + 1, arr[index + 1] % 2, dp) + (arr[index + 1] - x);
        }
        long noJump = helper2(arr, x, index + 1, prev, dp);
        return dp[index][prev] = Math.max(jump, noJump);
    }

    // i tried but failed
    public static long util1(int arr[], int x) {
        long dp[] = new long[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, x, 0, dp);
    }

    public static long helper(int arr[], int x, int index, long dp[]) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        long ans = 0;
        for (int i = index + 1; i < arr.length; i++) {
            long smallAns = helper(arr, x, i, dp);
            if (diffP(arr[index], arr[i])) {
                smallAns -= x;
            }
            ans = Math.max(smallAns + arr[index], ans);
        }
        return dp[index] = (ans);
    }

    private static boolean diffP(int n, int m) {
        if (n % 2 == 0 && m % 2 != 0) {
            return true;
        } else if (n % 2 != 0 && m % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
