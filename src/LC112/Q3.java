package LC112;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 4, 8, 4, 8, 10, 10));
        System.out.print(util1(nums, 3, 3));
    }

    public static long util1(List<Integer> nums, int m, int k) {
        if (nums.size() < k) {
            return 0;
        }
        // build the windahh
        int start = 0;
        int end = 0;
        long sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (end < k) {
            sum += nums.get(end);
            hm.put(nums.get(end), hm.getOrDefault(nums.get(end), 0) + 1);
            end++;
        }
        end--;
        long ans = 0;
        while (true) {
            if (hm.size() >= m) {
                ans = Math.max(ans, sum);
            }
            if (hm.get(nums.get(start)) == 1) {
                hm.remove(nums.get(start));
            } else {
                hm.put(nums.get(start), hm.get(nums.get(start)) - 1);
            }
            sum -= nums.get(start);
            start++;
            end++;
            if (end >= nums.size()) {
                break;
            }
            sum += nums.get(end);
            hm.put(nums.get(end), hm.getOrDefault(nums.get(end), 0) + 1);
        }
        return ans;
    }

}
