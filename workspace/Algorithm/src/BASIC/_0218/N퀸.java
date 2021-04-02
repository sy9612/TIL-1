package BASIC._0218;
import java.util.Scanner;

public class N퀸 {
   static int[][] arr;
   static int N, cnt = 0;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      
      arr = new int[N][N];
      nqueen(0);
      System.out.println(cnt);
      
   }
   
   static void nqueen(int idx) {
      if (idx == arr.length) {
         cnt+=1;
         return;
      }
      for (int i = 0; i < arr.length; i++) {
         if (isPossible(idx, i)) {
            arr[idx][i] = 1;
            nqueen(idx+1);
            arr[idx][i] = 0; //원상복구
         }
      }
   }
   
   static boolean isPossible(int r, int c) {
      // 위
      for (int j = r; j >= 0; j--) {
         if (arr[j][c] == 1) {
            return false;
         }
      }
      
      // 왼쪽 위
      for (int i = r, j = c; i >=0 && j >=0 ; i--, j--) {
         if (arr[i][j] == 1) {
            return false;
         }
      }
      
      
      // 오른쪽 위
      for (int i = r, j = c; i >=0 && j < N; i--, j++) {
         if (arr[i][j] == 1) {
            return false;
         }
      }
      
      return true;
   }
}
