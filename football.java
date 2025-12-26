import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner ob = new Scanner(System.in);
        String s=ob.nextLine();
        int zeroc=0;
        int onec=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
boolean flag=false;
char lastch=' ';
        for (char c : s.toCharArray()) {
            if(c==lastch)
    hm.put(c, hm.getOrDefault(c, 0) + 1);

else{
     hm.put(c, 1);
 lastch=c;
}
  if (entry.getValue() >= 7) {
        System.out.println("Yes");
        flag=true;
        break;
    }
}



if(flag==false)
    System.out.println("NO");



    }
}