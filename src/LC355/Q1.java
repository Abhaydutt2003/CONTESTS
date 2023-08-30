package LC355;

import java.util.*;

public class Q1 {

    public static void main(String args[]) {

    }

    // public List<String> splitWordsBySeparator(List<String> words, char separator)
    // {
    // List<String> ans = new ArrayList<>();
    // for (String s : words) {
    // String str = new String(s);
    // for (int i = 0; i < str.length(); i++) {
    // if (str.charAt(i) == separator) {
    // String toAdd = str.substring(0, i);
    // if (toAdd.length() > 0) {
    // ans.add(toAdd);
    // }
    // str = str.substring(i + 1);
    // i = 0;
    // }
    // }
    // if (str.length() > 0 && str.charAt(0) != separator) {
    // ans.add(str);
    // }
    // }
    // return ans;
    // }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for (String s : words) {
            char arr[] = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == separator) {
                    continue;
                }
                int start = i;
                int end = i;
                while (i<arr.length && arr[i] != separator) {
                    end = i;
                    i++;
                }
                ans.add(s.substring(start, end + 1));
            }
        }
        return ans;
    }
}
