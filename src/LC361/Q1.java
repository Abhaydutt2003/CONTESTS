package LC361;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        db = new HashMap<>();
        System.out.print(util1(1,100));
    }

    public static int util1(int low, int high) {
        if (low > high) {
            return 0;
        }
        if (isValid(low)) {
            return util1(low + 1, high)+1;
        } else {
            return util1(low + 1, high);
        }
    }

    static HashMap<String, Integer> db;

    public static boolean isValid(int low) {
        int size = ((int) Math.log10(low) + 1);
        if (size % 2 != 0) {
            return false;
        }
        int mid = (size / 2);
        String s = low + "";
        int sum1 = getSum(s.substring(0, mid));
        int sum2 = getSum(s.substring(mid));
        if (sum1 == sum2) {
            return true;
        } else {
            return false;
        }
    }

    public static int getSum(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (db.containsKey(str)) {
            return db.get(str);
        }
        int current = ((int) str.charAt(0)) - 48;
        int ans = current + getSum(str.substring(1));
        db.put(str, ans);
        return ans;
    }

}
