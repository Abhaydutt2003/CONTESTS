package LC110;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Q2 {

    public static void main(String args[]) {

    }

    public ListNode helper(ListNode head) {
        dp = new HashMap<>();
        return util1(head);
    }

    HashMap<String, Integer> dp = new HashMap<>();

    public int find2(int max, int min) {
        String key = max + "_" + min;
        String key2 = min + "_" + max;
        if (dp.containsKey(key)) {
            return dp.get(key);
        } else if (dp.containsKey(key2)) {
            return dp.get(key2);
        }
        if (min == 0) {
            return max;
        }
        int ans = find2(min, max % min);
        dp.put(key2, ans);
        dp.put(key, ans);
        return ans;
    }

    public ListNode util1(ListNode head) {
        if (head == null) {
            return head;
        } else if (head.next == null) {
            return head;
        }

        ListNode updated = util1(head.next);
        int gcd;
        if (head.val > head.next.val) {
            gcd = find2(head.val, head.next.val);
        } else {
            gcd = find2(head.val, head.next.val);
        }
        ListNode newNode = new ListNode(gcd);
        head.next = newNode;
        newNode.next = updated;
        return head;
    }

}
