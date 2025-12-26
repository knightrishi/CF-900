// Yaha hum is problem ko graph problem ki tarah treat nahi kar rahe hain.
// Isko hum sequence alignment problem ke form mein solve kar rahe hain.
// Hume yeh find karna hai ki Shuffl recipe list ko original recipe list mein convert karne ke liye 
// minimum moves kitne lagenge — aur yeh hum LIS (Longest Increasing Subsequence) logic se nikal rahe hain.

import java.util.*;

public class Orderit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.nextLine(); 
        List<String> jumble = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jumble.add(sc.nextLine());
        }
        sc.nextLine(); 
        List<String> original = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            original.add(sc.nextLine());
        }
        System.out.println(minMoves(jumble, original));
    }
    static int minMoves(List<String> jumble, List<String> original) {
        Map<String, Integer> pos = new HashMap<>();
         Map<String, Integer> nex = new HashMap<>();
        for (int i = 0; i < original.size(); i++) {
            pos.put(original.get(i), i);
        }
        List<Integer> indices = new ArrayList<>();
        for (String s : jumble) {
            if (pos.containsKey(s)) {
                indices.add(pos.get(s));
            }
        }
        int lisLength = mainKaamKaLogic(indices);
        return jumble.size() - lisLength;
    }
    static int mainKaamKaLogic(List<Integer> arr) {
        List<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) lis.add(num);
            else lis.set(pos, num);
        }
        return lis.size();
    }
}

//TC-BigO(nlogn)
//Graph ke badle dp kar duys isko