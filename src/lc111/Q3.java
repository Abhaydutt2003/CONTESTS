package lc111;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {

    }

    // super clever dp solution
    // keep track fo three threads
    public static int util2(List<Integer> arr) {
        int dp[][] = new int[arr.size()][3];
        // now tracking all threads
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = (arr.get(i) == 1) ? 0 : 1;
            dp[i][1] = (arr.get(i) == 2) ? 0 : 1;
            dp[i][2] = (arr.get(i) == 3) ? 0 : 1;
            // consider the best now for each thread
            if (i > 0) {
                dp[i][0] += dp[i - 1][0];
                dp[i][1] += Math.min(dp[i - 1][1], dp[i - 1][0]);
                dp[i][2] += Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1]));
            }
        }
        // consider the best thread as the answer
        return Math.min(dp[arr.size() - 1][0], Math.min(dp[arr.size() - 1][1], dp[arr.size() - 1][2]));
    }

    public static int util1(List<Integer> arr) {
        // find lis
        int dp[] = new int[arr.size()];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) <= arr.get(i)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return arr.size() - ans;
    }

}
