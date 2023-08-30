package LC353;

public class NumberOfJumpsToReachLastIndex {

    public static void main(String args[]) {
        int arr[] = { 1, 3, 6, 4, 1, 2 };
        System.out.print(util1(arr, 3));
    }

    public static int util1(int arr[], int target) {
        int dp[] = new int[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int j = i + 1;
            int smallAns = -1;
            while (j < arr.length) {
                if (Math.abs(arr[i] - arr[j]) <= target && dp[j] != -1) {
                    smallAns = Math.max(smallAns, (dp[j] + 1));
                }
                j++;
            }
            dp[i] = smallAns;
        }
        return dp[0];
    }

}
