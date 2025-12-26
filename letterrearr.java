import java.util.*;

 class Letter {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);
        int t = ob.nextInt();
        ob.nextLine();
        
        while (t-- > 0) {
            String s = ob.nextLine();
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String sorted = new String(a);
            
            // If all characters are same → impossible
            if (a[0] == a[a.length - 1]) {
                System.out.println("-1");
            } else {
                System.out.println(sorted);
            }
        }
    }
}
