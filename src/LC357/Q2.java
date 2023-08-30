package LC357;

import java.util.*;

public class Q2 {

    public static void main(String args[]) {
        List<Integer> l = new ArrayList<>(Arrays.asList(2, 1, 3));
        util1(l, 5);
    }

    public static boolean util1(List<Integer> nums, int m) {
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        hm = new HashMap<>();
        int max = helper(nums, 0, nums.size() - 1, m, totalSum);
        System.out.print(max);
        if (max >= nums.size()) {
            return true;
        }
        return false;
    }

    static int atleast;
    static HashMap<String, Integer> hm;

    public static int helper(List<Integer> nums, int start, int end, int m, int sum) {
        if (start == end) {
            return 1;
        }
        String key = start + "_" + end;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int currentSum = 0;
        int ans = 0;
        for (int k = start; k <= end; k++) {
            sum += nums.get(k);
            if ((currentSum == m || k - start == 0) && (end - k == 0 || sum - currentSum == m)) {
                int left = helper(nums, start, k, m, currentSum);
                int right = helper(nums, k + 1, end, m, sum - currentSum);
                int currentAns = left + right;
                ans = Math.max(ans, currentAns);
            }
        }
        hm.put(key, ans);
        return ans;
    }

}
