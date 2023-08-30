package LC109;

import java.util.*;

public class Q1 {

    public static void main(String args[]) {
        int arr[] = { 2, 1, 3 };
        System.out.print(util1(arr));
    }
    
    public static boolean util1(int arr[]) {
        if (arr.length < 2) {
            return false;
        }
        Arrays.sort(arr);
        int i = 1;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] != i) {
                return false;
            }
            if (i < arr.length - 1) {
                i++;
            }
        }
        return true;
    }
}
