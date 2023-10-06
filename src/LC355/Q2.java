package LC355;

public class Q2 {

    public static void main(String[] args) {

    }

    public long recUtil(int[] arr) {
        return helper2(arr, 0);
    }

    public long helper2(int arr[], int index) {
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
}