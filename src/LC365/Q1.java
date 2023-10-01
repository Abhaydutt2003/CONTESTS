package LC365;

public class Q1 {

    public static void main(String[] args) {
        System.out.println(util1(new int[]{12,6,1,2,7}));
    }

    public static  long util1(int arr[]){
        long max = 0;
        for(int i = 0;i<arr.length-2;i++){
            for(int j = i+1;j<arr.length-1;j++){
                for(int k = j+1;k<arr.length;k++){
                    long current = ((long)(arr[i]-arr[j]))*((long)arr[k]);
                    max = Math.max(max,current);
                }
            }
        }
        return max;
    }     
}
