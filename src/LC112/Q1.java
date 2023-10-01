package LC112;

//import java.util.*;

public class Q1 {

    public static void main(String args[]) {
        String s1 = "abcd";
        String s2 = "dacb";
        System.out.print((util1(s1, s2)));
    }

    public static boolean util1(String s1, String s2) {
        return helper(s1, s2, 0);
    }

    public static boolean helper(String s1, String s2, int index) {
        if (s1.equals(s2)) {
            return true;
        }
        if (index + 2 >= s1.length()) {
            return false;
        }
        String swaped = swap(s1, index, index + 2);
        boolean ans1 = helper(swaped, s2, index + 1);
        boolean ans2 = helper(s1, s2, index + 1);
        return ans1 || ans2;
    }

    public static String swap(String str, int i, int j) {
        char[] ch = str.toCharArray();

        // Swapping using XOR operation
        ch[i] = (char) (ch[i] ^ ch[j]);
        ch[j] = (char) (ch[i] ^ ch[j]);
        ch[i] = (char) (ch[i] ^ ch[j]);

        return String.valueOf(ch);
    }

}
