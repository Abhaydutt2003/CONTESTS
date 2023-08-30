package LC354;

import java.util.*;

public class ValidSplit {

    public static void main(String args[]) {

    }

    public static int util1(List<Integer> nums) {
        // populating the leftArr.
        HashMap<Integer, Integer> hm = new HashMap<>();
        int leftArr[] = new int[nums.size()];
        int k = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            int currentFreq = hm.getOrDefault(nums.get(i), 0);
            currentFreq++;
            if ((currentFreq * 2) > (i - 0 + 1)) {
                leftArr[k++] = nums.get(i);
            } else {
                if ((hm.getOrDefault(leftArr[k - 1], 0) * 2) > (i - 0 + 1)) {
                    leftArr[k] = leftArr[k - 1];
                } else {
                    leftArr[k] = -1;
                }
                k++;
            }
            hm.put(nums.get(i), currentFreq);
        }
        // populating the rightArr
        hm = new HashMap<>();
        int rightArr[] = new int[nums.size()];
        k = rightArr.length - 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            int currentFreq = hm.getOrDefault(nums.get(i), 0);
            currentFreq++;
            if ((currentFreq * 2) > (nums.size() - 1 - i + 1)) {
                rightArr[k--] = nums.get(i);
            } else {
                if ((hm.getOrDefault(rightArr[k + 1], 0) * 2) > (nums.size() - 1 - i + 1)) {
                    rightArr[k] = rightArr[k + 1];
                } else {
                    rightArr[k] = -1;
                }
                k--;
            }
            hm.put(nums.get(i), currentFreq);
        }
        for (int i = 0; i < leftArr.length - 1; i++) {
            if ((leftArr[i] != -1) && (leftArr[i] == rightArr[i + 1])) {
                return i;
            }
        }
        return -1;
    }

}
