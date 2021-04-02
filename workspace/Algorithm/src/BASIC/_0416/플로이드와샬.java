package BASIC._0416;

import java.util.Arrays;

public class 플로이드와샬 {
   public static void main(String[] args) {
      final int M = Integer.MAX_VALUE;
      int[][] D = { { 0, M, 2, 3 }, { 4, 0, 1, 8 }, { 2, 5, 0, M }, { M, 9, 6, 0 } };

      for (int i = 0; i < D.length; i++) { // 경유 정점
         for (int j = 0; j < D.length; j++) { // 출발 정점
            if (i == j)
               continue;
            for (int j2 = 0; j2 < D.length; j2++) { // 도착 정점
               if (j == j2 || i == j2)
                  continue;
               if (D[j][i] != M && D[i][j2] != M && D[j][j2] > D[j][i] + D[i][j2])
                  D[j][j2] = D[j][i] + D[i][j2];
            }
         }
      }
      
      for (int i = 0; i < D.length; i++) {
            System.out.println(Arrays.toString(D[i]));
         }
      
   }
}