package LC357;

public class Q1 {

    public static void main(String args[]) {

    }

    public static String util1(String str) {
        char arr[] = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'i') {
                reverse(arr, 0, i - 1);
                arr[i] = '#';
            }
        }
        String ans = "";
        for (char ch : arr) {
            if (ch != '#') {
                ans += ch;
            }
        }
        return ans;
    }

    public static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] == '#') {
                start++;
                continue;
            } else if (arr[end] == '#') {
                end--;
                continue;
            } else {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}
