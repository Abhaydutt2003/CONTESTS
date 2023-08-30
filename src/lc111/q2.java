package lc111;

public class q2 {

    public static void main(String args[]) {
        String str1 = "ab";
        String str2 = "d";
        System.out.print(util2(str1, str2));
    }

    public static boolean util2(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (isValid(str1.charAt(i), str2.charAt(j))) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }

    public static boolean util1(String text1, String text2) {
        // int lcs = tabulation(str1, str2);
        // if (lcs == str2.length()) {
        // return true;
        // } else {
        // return false;
        // }
        int memo[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        int lcs = helperMemo(text1, text2, text1.length(), text2.length(), memo);
        if (lcs == text2.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static int helperMemo(String s1, String s2, int N, int M, int[][] memo) {
        if (N == 0 || M == 0) {
            return 0;
        }
        if (memo[N][M] != -1) {
            return memo[N][M];
        }
        if (isValid(s1.charAt(N - 1), s2.charAt(M - 1))) {
            int ans = helperMemo(s1, s2, N - 1, M - 1, memo) + 1;
            return memo[N][M] = ans;
        } else {
            int ans1 = helperMemo(s1, s2, N - 1, M, memo);
            int ans2 = helperMemo(s1, s2, N, M - 1, memo);
            return memo[N][M] = Math.max(ans1, ans2);
        }
    }

    public static int tabulation(String text1, String text2) {
        int t[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (isValid(text1.charAt(i - 1), text2.charAt(j - 1))) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else {
                    int ans2 = t[i - 1][j];
                    int ans1 = t[i][j - 1];
                    t[i][j] = Math.max(ans2, ans1);
                }
            }
        }
        return t[text1.length()][text2.length()];
    }

    public static boolean isValid(char ch1, char ch2) {
        if (ch1 == ch2) {
            return true;
        } else {
            if (ch1 == 'z') {
                ch1 = 'a';
            } else {
                ch1 += 1;
            }
            if (ch1 == ch2) {
                return true;
            }
        }
        return false;
    }

    // public static boolean util1(String str1, String str2){
    // if(str1.length()<str2.length()){
    // return false;
    // }
    // int freq[] = new int[26];
    // for(int i = 0;i<str1.length();i++){
    // int index = 'a'-str1.charAt(i);
    // freq[index]++;
    // }
    // for(int i = 0;i<str2.length();i++){
    // int index = 'a'-str1.charAt(i);
    // if(freq[index] == 0){

    // }else{
    // //valid
    // continue;
    // }
    // }
    // }

    // // public static boolean helper(String str1, String str2,int i,int j) {
    // // // int operations = 0;
    // // // while (i < str1.length() && j < str2.length()) {
    // // // if (str1.charAt(i) == str2.charAt(j)) {
    // // // i++;
    // // // j++;
    // // // continue;
    // // // } else if (operations < 1) {
    // // // if (str1.charAt(j) == 'z') {
    // // // if (str2.charAt(j) == 'a') {
    // // // i++;
    // // // j++;
    // // // operations++;
    // // // continue;
    // // // } else {
    // // // System.out.print("Alo2");
    // // // return false;
    // // // }
    // // // } else {
    // // // char ch = str1.charAt(i);
    // // // if (str2.charAt(j) == ++ch) {
    // // // i++;
    // // // j++;
    // // // operations++;
    // // // continue;
    // // // } else {
    // // // System.out.println(str1.charAt(i)+" "+ch);
    // // // System.out.print("Aloo1");
    // // // return false;
    // // // }
    // // // }
    // // // } else {
    // // // System.out.print("Aloo3");
    // // // return false;
    // // // }
    // // // }
    // // // return true;

    // // }

}
