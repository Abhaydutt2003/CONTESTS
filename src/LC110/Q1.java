package LC110;

//import java.util.*;

public class Q1 {

    public static void main(String args[]) {
        //System.out.print();
    }

    public static int util1(int n) {
        int round = (n + 5) / 10 * 10;
        return 100 - round;
    }

    // public static int getAns(int n) {
    // // if (10 % n == 0 || n%10 == 0) {
    // // return n;
    // // }
    // int left = n - 1;
    // int right = n + 1;
    // while (left>=0) {
    // if(right %10 == 0 || 10 % right == 0){
    // return right;
    // }
    // else if(left%10 == 0 || 10 % left == 0){
    // return left;
    // }
    // left--;
    // right++;
    // }
    // return -1;
    // }

}
