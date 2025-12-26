import java.util.*;

public class sale {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int n = ob.nextInt();
        int m = ob.nextInt();

        int arr[]=new int[n];
       
        int sum=0;
        int cnt=0;
        for(int i=0;i<n;i++){
            arr[i]=ob.nextInt();
        }

       Arrays.sort(arr);
       for(int i=0;i<n;i++){
        if(cnt==m) break;

           if(arr[i]<0){
            sum+=arr[i];
            cnt++;
           }
            
        }



System.out.println(Math.abs(sum));

    }
}