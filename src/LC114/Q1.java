package LC114;

import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 1, 5, 4, 2));
        System.out.println(util1(arr, 5));
    }

    public static int util1(List<Integer> arr, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= k; i++) {
            hs.add(i);
        }
        int operations = 0;
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (hs.size() == 0) {
                return operations;
            }
            operations++;
            int elemnet = arr.get(i);
            if (hs.contains(elemnet)) {
                hs.remove(elemnet);
            }
        }
        // just for the sake
        return operations;
    }

}
