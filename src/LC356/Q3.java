// package LC356;

// import java.util.*;

// public class Q3 {

//     public static void main(String[] args) {
//         List<Integer> arr = new ArrayList<>(Arrays.asList(5,3,4,1,1));
//         System.out.println(util2(arr));
//     }

//     public static long util3(List<Integer> maxHeights){
//         int left[] = new int[maxHeights.size()];
//         left[]
//     }

//     public static long util2(List<Integer> maxHeights){
//         int ma = Integer.MIN_VALUE;
//         int numMax =0;
//         for(int i:maxHeights){
//             if(i>ma){
//                 ma = i;
//                 numMax =1;
//             }else if(i == ma){
//                 numMax++;
//             }
//         }
//         int maxes[][] = new int[numMax][2];
//         int k =0;
//         for(int i=0;i<maxHeights.size();i++){
//             if(maxHeights.get(i) == ma){
//                 maxes[k][0] = maxHeights.get(i);
//                 maxes[k++][1] = i;
//             }
//         }
//         Arrays.sort(maxes,(a,b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
//         long ans = Integer.MIN_VALUE;
//         for(int i =0;i<maxes.length;i++){
//             long smallAns = isValid(maxes[i][1],maxes[i][0],maxHeights);
//             ans = Math.max(ans, smallAns);
//         }
//         return ans;
//     }

//     public static long isValid(int index, int max, List<Integer> heights) {
//         int arr[] = new int[heights.size()];
//         arr[index] = max;
//         // left traversal
//         int leftIndex = index - 1;
//         while (leftIndex >= 0) {
//             if (heights.get(leftIndex) < arr[leftIndex + 1]) {
//                 arr[leftIndex] = heights.get(leftIndex);
//             } else {
//                  arr[leftIndex] = arr[leftIndex + 1];
//             }
//             leftIndex--;
//         }
//         // right traversal
//         int rightIndex = index + 1;
//         while (rightIndex < arr.length) {
//             if (heights.get(rightIndex) < arr[rightIndex - 1]) {
//                 arr[rightIndex] = heights.get(rightIndex);
//             } else {
//                 arr[rightIndex] = arr[rightIndex - 1];
//             }
//             rightIndex++;
//         }
//         // valid
//         long sum = 0;
//         for (int i : arr) {
//             sum += i;
//         }
//         return sum;
//     }


//     // public static long util1(List<Integer> maxHeights){
//     //     int arr[][] = new int[maxHeights.size()][2];
//     //     for(int i = 0;i<maxHeights.size();i++){
//     //         arr[i][0] = maxHeights.get(i);
//     //         arr[i][1] = i;
//     //     }
//     //     Arrays.sort(arr,(a,b)->(a[0] == b[0])?a[1]-b[1]:a[0]-b[0]);
//     //     int start = 0,end = maxHeights.size()-1,mid = 0,ans = Integer.MIN_VALUE;
//     //     while(start<=end){
//     //         mid = start+(end-start)/2;
//     //         int smallAns = 
//     //         if(isValid()){
//     //             start = mid+1;
//     //             ans = Math.max(mid, ans);
//     //         }else{

//     //         }
//     //     }
//     // }
    
// }
