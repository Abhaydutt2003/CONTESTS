package LC365;

public class Q2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(util1(arr));
    }

    public static long util1(int arr[]) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        long ans = Integer.MIN_VALUE;
        // build the left array
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        // build the right array
        right[right.length - 1] = arr[arr.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        // now build the answer
        for (int i = 1; i < arr.length - 1; i++) {
            long current = ((long) left[i - 1] - (long) arr[i]) * (long) right[i + 1];
            ans = Math.max(ans, current);
        }
        return (ans < 0) ? 0 : ans;
    }

}