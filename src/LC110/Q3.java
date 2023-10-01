package LC110;

import java.util.*;

public class Q3 {

    public static void main(String args[]) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 1, 3, 3, 2));
        System.out.print(util2(nums));

    }

    // since the array is circular, the very first gap will be circular
    public static int util2(List<Integer> ls) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < ls.size(); i++) {
            if (hm.containsKey(ls.get(i))) {
                List<Integer> toPutIn = hm.get(ls.get(i));
                toPutIn.add(i);
            } else {
                hm.put(ls.get(i), new ArrayList<>(Arrays.asList(i)));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> en : hm.entrySet()) {
            int candidate = getGap(en.getValue(), ls.size());
            ans = Math.min(ans, candidate);
        }
        return ans / 2;
    }

    public static int getGap(List<Integer> pos, int n) {
        int ans = Integer.MIN_VALUE;
        int prev = pos.get(pos.size() - 1) - n;
        for (int i : pos) {
            int currentGap = i - prev;
            ans = Math.max(ans, currentGap);
            prev = i;
        }
        return ans;
    }

    // failed
    public static int util1(List<Integer> nums) {
        // get the frequency of the elements
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        // while (hm.size() > 1) {
        // traverse(nums, hm);
        // ans++;
        // }
        traverse(nums, hm);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        return ans;
    }

    public static void traverse(List<Integer> nums, HashMap<Integer, Integer> hm) {
        int n = nums.size();
        for (int i = 0; i < nums.size(); i++) {
            int prevIndex = (i - 1 + n) % n;
            int nextIndex = (i + 1) % n;
            int prevFreq = hm.get(nums.get(prevIndex));
            int nextFreq = hm.get(nums.get(nextIndex));
            int currentFreq = hm.get(nums.get(i));
            if (currentFreq <= prevFreq || currentFreq <= nextFreq) {
                if (hm.get(nums.get(i)) == 1) {
                    hm.remove(nums.get(i));
                } else {
                    hm.put(nums.get(i), hm.get(nums.get(i)) - 1);
                }
                if (prevFreq >= nextFreq) {
                    nums.set(i, nums.get(prevIndex));
                    hm.put(nums.get(prevIndex), hm.get(nums.get(prevIndex)) + 1);
                } else {
                    nums.set(i, nums.get(nextIndex));
                    hm.put(nums.get(nextIndex), hm.get(nums.get(nextIndex)) + 1);
                }
            }
        }
    }

    // public static void main(String args[]) {

    // }

    // public static ListNode helper(ListNode head) {
    // dp = new HashMap<>();
    // return util1(head);
    // }

    // static HashMap<String, Integer> dp = new HashMap<>();

    // public static int find2(int max, int min) {
    // String key = max + "_" + min;
    // String key2 = min + "_" + max;
    // if (dp.containsKey(key)) {
    // return dp.get(key);
    // } else if (dp.containsKey(key2)) {
    // return dp.get(key2);
    // }
    // if (min == 0) {
    // return max;
    // }
    // int ans = find2(min, max % min);
    // dp.put(key2, ans);
    // dp.put(key, ans);
    // return ans;
    // }

    // public static ListNode util1(ListNode head) {
    // if (head == null) {
    // return head;
    // } else if (head.next == null) {
    // return head;
    // }

    // ListNode updated = util1(head.next);
    // int gcd;
    // if (head.val > head.next.val) {
    // gcd = find2(head.val, head.next.val);
    // } else {
    // gcd = find2(head.val, head.next.val);
    // }
    // ListNode newNode = new ListNode(gcd);
    // head.next = newNode;
    // newNode.next = updated;
    // return head;
    // }

}
