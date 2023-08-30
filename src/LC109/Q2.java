package LC109;

import java.util.*;

public class Q2 {

    public static void main(String args[]) {
        String str = "SDFgdfgbxcvbajkresdntfkljawenm";
        // util1(str);
        System.out.print(util2(str));
    }

    public static String util2(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] result = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels.add(s.charAt(i));
                result[i] = '#';
            }
        }
        Collections.sort(vowels);

        int vowelIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result[i] == '#') {
                result[i] = vowels.get(vowelIndex);
                vowelIndex++;
            }
        }

        return new String(result);
    }

    public static boolean isCon(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        } else if (a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {
            return true;
        } else {
            return false;
        }
    }
}
