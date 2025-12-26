import java.util.*;

public class YourName {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int q = ob.nextInt();
        while (q-- > 0) {
            int n = ob.nextInt();
        ob.nextLine(); 
        String names = ob.nextLine();
        String[] st = names.split(" ");
            char[] temps = st[0].toCharArray();
            char[] tempt = st[1].toCharArray();
            Arrays.sort(temps);
            Arrays.sort(tempt);

          boolean flag = Arrays.equals(temps, tempt);
           if(flag==true)
          System.out.println("YES");
          
          else
          System.out.println("NO");
        }
    }
}