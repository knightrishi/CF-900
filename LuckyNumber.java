import java.util.*;

 public class LuckyNumber {
  public static int larDigits(int n)
{
    int largest = 0;
    int smallest = 9;

    while(n != 0) 
    {
        int r = n % 10;

        largest = Math.max(r, largest);

        n = n / 10;
    }

    return largest;
 }

public static int smallDigits(int n)
{
    int largest = 0;
    int smallest = 9;

    while(n != 0) 
    {
        int r = n % 10;

     smallest = Math.min(r, smallest);

        n = n / 10;
    }

    return smallest;
 }

    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
       int t=ob.nextInt();
       while(t-->0){
         int l,r;
         l=ob.nextInt();
         r=ob.nextInt();
         int diff=0;
         int lucky=0;
         int res=0;
        while(l<=r){
          diff=larDigits(l)-smallDigits(l);
          if(diff>=lucky){
            lucky=diff;
            res=l;
          }
           if (diff == 9) break;
          l++;
         }

         System.out.println(res);
       }



    }
 }