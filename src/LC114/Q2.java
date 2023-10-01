package LC114;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        System.out.println(isValid(7));
    }

    public static int util1(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        int operations = 0;
        for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
            int value = en.getValue();
            if (value == 1) {
                return -1;
            } else {
                operations += isValid(value);
            }
        }
        return operations;
    }

    public static int isValid(int value) {
        if (value % 3 == 0) {
            return value / 3;
        } else if (value % 3 == 1) {
            int ans = ((value / 3) - 1) + 2;
            return ans;
        } else if ((value % 3) % 2 == 0) {
            int ans1 = value / 3;
            int ans2 = (value % 3) / 2;
            return ans1 + ans2;
        }
        return -1;
    }

}
