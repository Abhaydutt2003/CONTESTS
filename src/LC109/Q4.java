package LC109;

public class Q4 {

    public static void main(String args[]) {

    }

    // tle
    public static int helper(int n, int x) {
        target = n;
        powNo = x;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return util1(0, 1);
    }

    static int dp[][];

    static int target;
    static int powNo;

    static int mod = 1000000007;

    public static int util1(long currentNumber, int index) {
        if (currentNumber == target) {
            return 1;
        }
        if (dp[(int) currentNumber][index] != -1) {
            return dp[(int) currentNumber][index];
        }
        int ans = 0;
        for (int i = index; i <= target; i++) {
            int a = (int) Math.pow(i, powNo);
            if (currentNumber + a <= target) {
                ans += util1(currentNumber + a, i + 1);
                ans %= mod;
            }
        }
        return dp[(int) currentNumber][index] = ans;
    }

    static int powerArray[];

    public static int util2(int n, int x) {
        powerArray  = new int[n+1];
        for (int i = 0; i < powerArray.length; i++) {
            int toPut = (int) Math.pow(i, x);
            if (toPut > n) {
                break;
            } else {
                powerArray[i] = toPut;
            }
        }
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper2(n, 0);
    }

    public static int helper2(int n, int index) {
        if (n == 0) {
            return 1;
        }
        if (index > n) {
            return 0;
        }
        if (dp[n][index] != -1) {
            return dp[n][index];
        }
        int pick = 0;
        if (powerArray[index] <= n) {
            pick = helper2(n - powerArray[index], index + 1) % mod;
        }
        int notPick = helper2(n, index + 1) % mod;
        int ans = (pick + notPick) % mod;
        return dp[n][index] = ans;
    }
}
