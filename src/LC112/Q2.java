package LC112;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        String s1 = "abcdba";
        String s2 = "cabdab";
        System.out.print(util2(s1, s2));
    }

    public static boolean util2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        hm = new HashMap<>();
        return helper(s1, s2,0, 1);
    }

    public static boolean helper(String s1, String s2, int prev, int current) {
        if (s1.equals(s2) == true) {
            return true;
        }
        if (current >= s1.length()) {
            return false;
        }
        String key = s1 + "-" + current;
        if (hm.containsKey(key) == true) {
            return hm.get(key);
        }
        // to swap
        if ((current - prev) % 2 == 0) {
            String swapped = swap(s1, prev, current);
            boolean ans1 = helper(swapped, s2, current, current + 1);
            boolean ans2 = helper(swapped, s2, prev, current + 1);
            if (ans1 || ans2) {
                hm.put(key, true);
                return true;
            }
        }
        // not to swap
        boolean ans1 = helper(s1, s2, prev, current + 1);
        boolean ans2 = helper(s1, s2, current, current + 1);
        if (ans1 || ans2) {
            hm.put(key, true);
            return true;
        }
        return false;
    }

    static HashMap<String, Boolean> hm;

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();

        // Swapping using XOR operation
        ch[i] = (char) (ch[i] ^ ch[j]);
        ch[j] = (char) (ch[i] ^ ch[j]);
        ch[i] = (char) (ch[i] ^ ch[j]);

        return String.valueOf(ch);
    }

}
