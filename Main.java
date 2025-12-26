//Pehle grid ko read karna hai.
//Grid mein ‘C’ cable ko represent karta hai, ‘R’ rod ko, aur ‘.’ khaali jagah ko.
//Cable hamesha grid ke edge se start hoti hai aur kisi aur edge pe end hoti hai.
//Matlab starting point aur ending point dono border pe honge.
//Ab hume cable ka pura path find karna hai.
//Kisi bhi edge wale ‘C’ se start karke cable ko follow karte hue chalte jaana hai.
//Move sirf upar, neeche, left ya right direction mein hi kar sakte ho — diagonal move allowed nahi hai.
//Ye sab karne ke liye BFS ya DFS jaisa traversal use karna hoga.

import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][] went;
    static int[] xasisinD = {-1, 1, 0, 0};
    static int[] yasisinD = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();      sc.nextLine();
       board = new char[N][M];
     went = new boolean[N][M];

        for (int i = 0; i < N; i++) {
          String[] row = sc.nextLine().split(" ");
          for (int j = 0; j < M; j++) {              board[i][j] = row[j].charAt(0);
            }
        }
        System.out.println(calTransiti());
    }
    static int calTransiti() {
       int transitions = 0;
        Queue<int[]> queue = new LinkedList<>();
     for (int i = 0; i < N; i++) {
          if (board[i][0] == 'C') queue.add(new int[]{i, 0})       if (board[i][M - 1] == 'C') queue.add(new int[]{i, M - 1});
        }
        for (int j = 0; j < M; j++) {
            if (board[0][j] == 'C') queue.add(new int[]{0, j});
            if (board[N - 1][j] == 'C') queue.add(new int[]{N - 1, j});
        }
        while (!queue.isEmpty()) {
         int[] curr = queue.poll();
        int x = curr[0], y = curr[1]           if (went[x][y]) continue;
            went[x][y] = true;

            if (board[x][y] == 'R') transitions++;

            for (int d = 0; d < 4; d++) {
                int ninX = x + xasisinD[d], ny = y + yasisinD[d];
                if (ninX >= 0 && ny >= 0 && ninX < N && ny < M &&
             !went[ninX][ny] && (board[ninX][ny] == 'C' || board[ninX][ny] == 'R')) {
             queue.add(new int[]{ninX, ny});
      }
    }
    }

        return transitions;
  }
}