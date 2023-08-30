package LC355;

import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

public class Q2 {

    public static void main(String args[]) {
        int arr[] = { 5, 3, 3 };
        System.out.println(util(arr));
    }

    // using recursion

    public static long recUtil(int[] arr) {
        return helper2(arr, 0);
    }

    public static long helper2(int arr[], int index) {
        if (index == arr.length - 1) {
            return (long) arr[index];
        }
        long smallAns = helper2(arr, index + 1);
        long current = (long) arr[index];
        if (current <= smallAns) {
            return current + smallAns;
        }
        return current;
    }

    // correct answer
    public static long util(int[] arr) {
        Stack<Long> s = new Stack<>();
        s.push((long) arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            long current = arr[i];
            while (s.isEmpty() == false && s.peek() >= current) {
                current += s.pop();
            }
            s.push(current);
        }
        long ans = 0;
        while (s.isEmpty() == false) {
            ans = Math.max(ans, s.pop());
        }
        return ans;
    }

    // public static int util4(int arr[]) {
    // Stack<Integer> s = new Stack<>();
    // s.add(arr[0]);
    // for (int i = 1; i < arr.length; i++) {
    // // if (s.peek() <= arr[i]) {
    // // int temp = s.pop();
    // // temp += arr[i];
    // // s.push(temp);
    // // }
    // // int temp = s.pop();
    // // while (s.isEmpty() == false && s.peek() <= temp) {
    // // temp += s.pop();
    // // }
    // // s.push(temp);
    // int temp = arr[i];
    // while (s.isEmpty() == false && s.peek() <= temp) {

    // }
    // }
    // int ans = 0;
    // while (s.isEmpty() == false) {
    // ans = Math.max(ans, s.pop());
    // }
    // return ans;
    // }

    // public static int util3(int arr[]) {
    // List<Integer> toSend = new ArrayList<>();
    // for (int i : arr) {
    // toSend.add(i);
    // }
    // List<Integer> al = helper(toSend);
    // int ans = Integer.MIN_VALUE;
    // for (int i : al) {
    // ans = Math.max(ans, i);
    // }
    // return ans;
    // }

    // public static List<Integer> helper(List<Integer> a) {
    // if (a.size() == 1) {
    // return a;
    // }
    // List<Integer> toSend = new ArrayList<>();
    // for (int i = 0; i < a.size(); i++) {
    // int current = 0;
    // while (i + 1 < a.size() && a.get(i) <= a.get(i + 1)) {
    // current += a.get(i);
    // i++;
    // }
    // current += a.get(i);
    // toSend.add(current);
    // current = 0;
    // }
    // if (toSend.size() == a.size()) {
    // return a;
    // } else {
    // return helper(toSend);
    // }
    // }

    // public static int util2(int arr[]){
    // ListNode head = null;
    // ListNode tail = null;
    // for(int i = 0;i<arr.length;i++){
    // if(head == null){
    // head = new ListNode(arr[i],null);
    // tail = head;
    // }else{
    // tail.next = new ListNode(arr[i],null);
    // tail = tail.next;
    // }
    // }
    // ListNode h = helper(head);
    // }

    // public static ListNode helper(ListNode head){
    // if(head.next == null){
    // return head;
    // }
    // boolean t = false;
    // ListNode temp = head;
    // while(temp != null){
    // if(temp)
    // }
    // }

    public static int util1(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        int current = 0;
        for (int i = 0; i < arr.length;) {
            while (i + 1 < arr.length && arr[i] <= arr[i + 1]) {
                current += arr[i];
                i++;
            }
            current += arr[i++];
            s.push(current);
            current = 0;
        }

        if (s.size() == 1) {
            return s.pop();
        }
        int ans = Integer.MIN_VALUE;
        int prev = s.pop();
        while (s.isEmpty() == false) {
            if (s.peek() >= prev) {
                ans = Math.max(prev, ans);
                prev = s.pop();
            } else {
                prev += s.pop();
            }
        }
        ans = Math.max(prev, ans);
        return ans;
    }

}
