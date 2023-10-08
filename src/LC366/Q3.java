package LC366;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        String s1 = "101101";
        String s2 = "000000";
        System.out.println(util3(s1, s2, 6));
    }

    // dp
    public static int util3(String s1, String s2, int x) {
        hm = new HashMap<>();
        return helper(s1.toCharArray(), s2, 0, 0, false, x);
    }

    static HashMap<String, Integer> hm;

    public static int helper(char arr[], String arr2, int index, int cost, boolean op1, int x) {
        if (index == arr.length) {
            if (op1 == false && arr.toString().equals(arr2)) {
                return cost;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        String key = arr.toString() + " " + op1;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int ans = Integer.MAX_VALUE;
        if (op1) {
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            int ans1 = helper(arr, arr2, index + 1, cost + x, false, x);
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            ans = ans1;
        } else {
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            int ans1 = helper(arr, arr2, index + 1, cost, true, x);
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            ans = ans1;
        }
        if (index < arr.length - 1) {
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            if (arr[index + 1] == '0') {
                arr[index + 1] = '1';
            } else {
                arr[index + 1] = '0';
            }
            int ans2 = helper(arr, arr2, index + 2, cost + 1, op1, x);
            if (arr[index] == '0') {
                arr[index] = '1';
            } else {
                arr[index] = '0';
            }
            if (arr[index + 1] == '0') {
                arr[index + 1] = '1';
            } else {
                arr[index + 1] = '0';
            }
            ans = Math.min(ans, ans2);
        }

        int ans3 = helper(arr, arr2, index + 1, cost, op1, x);
        ans = Math.min(ans, ans3);
        hm.put(key, ans);
        return ans;
    }

    public static int util2(String s1, String s2, int x) {
        char arr[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        boolean add = false;
        int prev = -1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                if (add) {
                    if (prev == i - 1) {
                        ans += 1;
                    } else {
                        ans += x;
                    }
                    add = false;
                } else {
                    add = true;
                    prev = i;
                }
            }
        }
        if (!add) {
            return ans;
        } else {
            return -1;
        }
    }

    public static int util1(String s1, String s2, int x) {
        char arr[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        boolean add = false;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr2[i]) {
                if (add) {
                    ans += x;
                    add = false;
                } else {
                    add = true;
                }
            }
        }
        if (!add) {
            return ans;
        } else {
            return -1;
        }
    }
}
