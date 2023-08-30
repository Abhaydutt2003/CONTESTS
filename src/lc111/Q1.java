package lc111;

import java.util.*;

public class Q1 {

    public static void main(String args[]) {

    }

    public static int util1(List<Integer> nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
