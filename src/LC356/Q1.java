package LC356;

public class Q1 {

    public static void main(String[] args) {
        System.out.print(util1("0101"));
    }

    public static String util1(String str) {
        char[] arr = str.toCharArray();
        char ans[] = new char[arr.length];
        int num1 = 0;
        int k = 0;
        for (char ch : arr) {
            if (ch == '1') {
                num1++;
            }
            ans[k++] = '0';
        }
        ans[ans.length - 1] = '1';
        num1--;
        k = 0;
        while (num1 > 0) {
            ans[k++] = '1';
            num1--;
        }
        return String.valueOf(ans);
    }

}
