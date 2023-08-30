package LC353;

public class LongestNonDecreasingFromTwoArrays {

    public static void main(String args[]) {
        int arr1[] = { 1, 1 };
        int arr2[] = { 2, 2 };
        System.out.print(util1(arr1, arr2));
    }

    public static int util1(int[] arr1, int arr2[]) {
        int dp1[] = new int[arr1.length];
        int dp2[] = new int[arr2.length];
        dp1[0] = dp2[0] = 1;
        int max = 1;
        for (int i = 1; i < dp1.length; i++) {
            // calculating for the first array.
            int ans1 = 0, ans2 = 0;
            if (arr1[i] >= arr1[i - 1]) {
                ans1 = dp1[i - 1];
            }
            if (arr1[i] >= arr2[i - 1]) {
                ans2 = dp2[i - 1];
            }
            dp1[i] = Math.max(ans1, ans2) + 1;
            max = Math.max(max, dp1[i]);
            // now calculating for the second array.
            ans1 = ans2 = 0;
            if (arr2[i] >= arr1[i - 1]) {
                ans1 = dp1[i - 1];
            }
            if (arr2[i] >= arr2[i - 1]) {
                ans2 = dp2[i - 1];
            }
            dp2[i] = Math.max(ans1, ans2) + 1;
            max = Math.max(max, dp2[i]);
        }
        return max;
    }

}
