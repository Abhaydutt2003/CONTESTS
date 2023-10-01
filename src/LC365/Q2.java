package LC365;

public class Q2 {

    public static void main(String[] args) {
        long arr[] = new long[]{6,11,12,12,7,9,2,11,12,4,19,14,16,8,16};
        int ar2[] = new int[]{6,11,12,12,7,9,2,11,12,4,19,14,16,8,16};
        System.out.println(util2(arr));
        //System.out.println(util4(ar2));
    }

    public static long util3(long arr[]){
        long left[] = new long[arr.length];
        long right[] = new long[arr.length];
        long right2[] = new long[arr.length];
        left[0] = arr[0];
        for(int i = 0;i<left.length;i++){
            left[i] = Math.max(arr[i],left[i-1]);
        }
        right[right.length-1] = arr[right.length-1];
        right2[right2.length-1] = arr[right2.length-1];
        for(int i = arr.length-2;i>=0;i--){
            right[i] = Math.min(arr[i],right[i+1]);
            right2[i] = Math.max(arr[i],right[i]);
        }
    }

    public static  long util4(int arr[]){
        long max = 0;
        for(int i = 0;i<arr.length-2;i++){
            for(int j = i+1;j<arr.length-1;j++){
                for(int k = j+1;k<arr.length;k++){
                    long current = ((long)(arr[i]-arr[j]))*((long)arr[k]);
                    if(current>max){
                        System.out.println(i+" "+j+" "+k);
                    }
                    max = Math.max(max,current);
                }
            }
        }
        return max;
    }   

    public static long util2(long[] arr){
        long left[] = new long[arr.length-2];
        long right[][] = new long[arr.length-1][2];
        left[0] = arr[0];
        for(int i = 1;i<left.length;i++){
            left[i] = Math.max(left[i-1],arr[i]);
        }
        right[right.length-1][0] = arr[arr.length-2];
        right[right.length-1][1] = arr.length-2;
        for(int i = arr.length-3;i>=0;i--){
            if(arr[i] < right[i+1][0]){
                right[i][0] = arr[i];
                right[i][1] = i;
            }else{
                right[i][0] = right[i+1][0];
                right[i][1] = right[i+1][1];
            }
        }
        long max = left[0]-right[1][0];
        int rightIndex = 1;
        for(int i = 1;i<left.length;i++){
            if(left[i]-right[i+1][0] > max){
                System.out.println(max+" "+(left[i]-right[i+1][0]));
                max = left[i]-right[i+1][0];
                rightIndex = (int)right[i+1][1];
            }
        }
        int k = rightIndex+1;
        long maxK = arr[k];
        for(int i = k;i<arr.length;i++){
            maxK = Math.max(maxK,arr[i]);
        }
        long ans = max*maxK;
        if(ans<0){
            return 0;
        }else{
            return ans;
        }
    }

    public static long util1(int[] arr) {
        long left[] = new long[arr.length - 2];
        long right[][] = new long[arr.length - 1][2];
        left[0] = (long) arr[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max((long) arr[i], left[i - 1]);
        }
        right[right.length - 1][0] = arr[arr.length - 2];
        right[right.length - 1][1] = arr.length - 2;
        for (int i = right.length - 2; i >= 0; i--) {
            if ((long) arr[i] <= right[i + 1][0]) {
                right[i][0] = arr[i];
                right[i][1] = i;
            } else {
                right[i][0] = right[i + 1][0];
                right[i][1] = right[i + 1][1];
            }
        }
        long max = left[0] - right[1][0];
        long rightIndex = right[1][1];
        for (int i = 1; i < left.length - 2; i++) {
            if (left[i] - right[i + 1][0] > max) {
                max = left[i] - right[i + 1][0];
                rightIndex = right[i + 1][1];
            }
        }
        long max2 = (long) arr[(int) rightIndex + 1];
        for (int i = (int) rightIndex; i < arr.length; i++) {
            max2 = Math.max(max2, (long) arr[i]);
        }
        long ans = max * max2;
        if (ans < 0) {
            return 0;
        } else {
            return ans;
        }
    }

}
