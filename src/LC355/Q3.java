package LC355;


import java.util.*;

public class Q3 {


    public static void main(String[] args) {
        
    }

    public static int util1(List<Integer> usage){
        int arr[][] = new int[usage.size()][2];
        for(int i = 0;i<usage.size();i++){
            arr[i][0] = usage.get(i);
            arr[i][1] = i;
        }
        //sort acc to no of elements
        Arrays.sort(arr,(a,b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
        int start = 1,end = usage.size(),res = -1,mid = 0;
        for(;(start<=end);){
            mid = start+(end-start)/2;
            if(isValid()){
                res = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return res;
    }

    //rec function to check if valid or not
    public static boolean isValid(int arr[], int mid){
        
    }
    

}
