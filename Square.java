import java.util.*;

public class Square {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        while(t-->0){
            int a,b,c,d;
            a = ob.nextInt();
            b = ob.nextInt();
            c = ob.nextInt();
            d = ob.nextInt();
            if(a==b && b==c && c==d && d==a)
                System.out.println("YES");
            else
                 System.out.println("NO");
        }

    }

}