package LC355;

import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(util1(Arrays.asList(1, 2, 5)));
    }

    // stumped
    public static int util1(List<Integer> usageLimits) {
        Collections.sort(usageLimits, (a, b) -> b - a);
        int start = 1, end = usageLimits.size(), mid = 0, res = 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isValid(usageLimits, mid)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    // checking if valid number of groups or not
    public static boolean isValid(List<Integer> usageLimits, int size) {
        int leftSpaces = 0;
        for (int i : usageLimits) {
            if (i < size) {
                leftSpaces += (size - i);
            } else if (leftSpaces > 0) {
                leftSpaces -= (i - size);
            }
            size = Math.max(size - 1, 0);
        }
        return leftSpaces <= 0;
    }

}
