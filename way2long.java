import java.util.*;
import java.io.*;

public class Main {
    public static void main(String ar[]) {
        Scanner ob = new Scanner(System.in);

        int n = ob.nextInt();
        ob.nextLine(); // clear leftover newline

        while (n-- > 0) {
            String wo = ob.nextLine();
            int p = wo.length();
            char a = wo.charAt(0);
            char b = wo.charAt(p - 1);
            System.out.println(a + "" + (p - 2) + b);
        }
    }
}
