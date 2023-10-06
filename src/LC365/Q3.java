package LC365;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(util1(new int[] { 5, 7, 2, 6, 4, 1, 6, 7, 1, 4, 7, 6, 7, 7, 6, 6, 4, 6, 8 }, 90));
    }

    // purely math based and sliding window
    public static int util1(int[] arr, int target) {
        int arrSum = 0;
        for (int i : arr) {
            arrSum += i;
        }
        long lengthReq = (long) (target / arrSum) * arr.length;
        target = target - (arrSum * (target / arrSum));
        int arr2[] = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr2[i + arr.length] = arr[i];
        }
        int start = 0, end = 0, windowSum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < arr2.length) {
            windowSum += arr2[end];
            while (windowSum > target && start <= end) {
                windowSum -= arr2[start++];
            }
            while (windowSum == target && start <= end) {
                ans = Math.min(ans, end - start + 1);
                windowSum -= arr2[start++];
            }
            end++;
        }
        return (ans == Integer.MAX_VALUE) ? -1 : (ans + (int) lengthReq);
    }

}
