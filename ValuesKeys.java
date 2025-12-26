   import java.util.*;

    public class ValuesKeys {
       public static void main(String[] args) {
           Scanner ob = new Scanner(System.in);
           String x = ob.nextLine();
           String y=ob.nextLine();

            if(x.length()!=y.length())
           System.out.println("-1");

            char xx[]=x.toCharArray();
            char yy[]=y.toCharArray();
            for(int i=0;i<xx.length;i++){
               if(xx[i]< yy[i]){
                            System.out.println("-1");
                              return;}
            }

   System.out.println(y);
        }

     }
     // like a=nzwzl
     //      c=niwel
     //  so isme n jo a ka hai n jo b ka jske equal hai similarly z in a is > than i in c yahi condition throughout foloow hona chiye ki charA[i]>=charB[i] if not then return -1;