package LC361;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        // String str = "12%12%45%";
        // String[] s = str.split("%");
        // S
        //System.out.print(util2("3678105825"));
        System.out.print(util2("444937979672347396583725074143"));
        //System.out.print(9%25);
    }

    //second approach
    public static int util2(String num){
        hm = new HashMap<>();
        return helper(num,0);
    }


    public static int helper(String num, int operations){
        if(num.length() == 1){
            if(num.charAt(0) =='0'){
                return operations;
            }
            return operations+1;
        }
        if(hm.containsKey(num)){
            return hm.get(num);
        }
        String lastTwo = num.substring(num.length()-2);
        if(Integer.parseInt(lastTwo) == 0 ||  Integer.parseInt(lastTwo)%25 == 0){
            return operations;
        }
        String first = num.substring(0,num.length()-1);
        int ans1 = helper(first,operations+1);
        String second = num.substring(0,num.length()-2)+num.charAt(num.length()-1);
        int ans2 = helper(second,operations+1);
        int ans = Math.min(ans1,ans2);
        hm.put(num,ans);
        return ans;
    }



    public static int util1(String num) {
        hm = new HashMap<>();
        int ans = helper(num, 0, 0);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }
    }

    static HashMap<String, Integer> hm;

    public static int helper(String str, int operations, int index) {
        if (index == str.length()) {
            if (isValid(str)) {
                return operations;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (isValid(str)) {
            return operations;
        }

        if (hm.containsKey(str)) {
            return hm.get(str);
        }
        // to replace
        String toSend = str.substring(0, index) + "|" + str.substring(index + 1);
        int ans1 = helper(toSend, operations + 1, index + 1);
        // not delete
        int ans2 = helper(str, operations, index + 1);
        int ans = Math.min(ans1, ans2);
        hm.put(str, ans);
        return ans;
    }

    public static boolean isValid(String str) {
        String ans = "";
        for (char ch : str.toCharArray()) {
            if (ch != '|') {
                ans += ch;
            }
        }
        if (ans == "") {
            ans = "0";
        }
        try {
            if (Long.parseLong(ans) % 25 == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
