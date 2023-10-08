package LC366;

public class Q1 {

    public static void main(String[] args) {
        
    }

    public static int util1(int n, int m){
        int sum1=0,sum2=0;
        for(int i = 1;i<=n;i++){
            if(i%m != 0){
                sum1+=i;
            }else{
                sum2+=i;
            }
        }
        return sum1-sum2;
    }



    
}
