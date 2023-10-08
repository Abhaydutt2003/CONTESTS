package LC366;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Q2 {

    public static void main(String[] args) {
        
    }


    public static int util1(List<Integer> processorTime, List<Integer> tasks){
        Collections.sort(processorTime,(a,b)->b-a);
        Collections.sort(tasks,(a,b)->a-b);
        int i = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE; 
        for(i = 0;i<processorTime.size();i++){
            int task = Integer.MIN_VALUE;
            int k = 0;
            while(k<4){
                task = Math.max(processorTime.get(i)+tasks.get(j),task);
                k++;
                j++;
            }
            ans = Math.max(task,ans);
        }
        return ans;
    }
    
}
