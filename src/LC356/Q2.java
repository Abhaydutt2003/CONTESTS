package LC356;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3,2,5,5,2,3));
        System.out.println(util1(arr));
    }

    // n^2
    public static long util1(List<Integer> maxHeights) {
        long ans = Integer.MIN_VALUE;
        for (int i = 0; i < maxHeights.size(); i++) {
            long smallAns = isValid(i, maxHeights.get(i), maxHeights);
            if (smallAns != -1) {
                ans = Math.max(ans, smallAns);
            }
        }
        return ans;
    }

    public static long isValid(int index, int max, List<Integer> heights) {
        int arr[] = new int[heights.size()];
        arr[index] = max;
        // left traversal
        int leftIndex = index - 1;
        while (leftIndex >= 0) {
            if (heights.get(leftIndex) < arr[leftIndex + 1]) {
                arr[leftIndex] = heights.get(leftIndex);
            } else {
                 arr[leftIndex] = arr[leftIndex + 1];
            }
            leftIndex--;
        }
        // right traversal
        int rightIndex = index + 1;
        while (rightIndex < arr.length) {
            if (heights.get(rightIndex) < arr[rightIndex - 1]) {
                arr[rightIndex] = heights.get(rightIndex);
            } else {
                arr[rightIndex] = arr[rightIndex - 1];
            }
            rightIndex++;
        }
        // valid
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

}
