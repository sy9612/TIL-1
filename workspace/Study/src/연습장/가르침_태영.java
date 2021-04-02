package 연습장;
import java.util.ArrayList;
import java.util.Scanner;


public class 가르침_태영 {
   static boolean[] alpha = new boolean[26];
   static int k;
   static int n;
   static int max =0;
   static String[] arr;
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
       n  = scan.nextInt();
       k = scan.nextInt();
      arr =new String[n];
      int tmp = 0;
      for(int i =0; i<n; i++) {
         arr[i] = scan.next();
         arr[i] = arr[i].substring(4, arr[i].length()-4);
         if(arr[i].length()==0)tmp++;
      }
      // a = 97;
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(2);
      list.add(8);
      list.add(13);
      list.add(19);
      combi(5,0,list);
      
      System.out.println(max+tmp);
   }
   private static void combi(int idx, int start,ArrayList<Integer> list) {
      // TODO Auto-generated method stub
      if( list.size() == k) {
         int cnt=0;
         for(int i = 0 ; i<n; i++) {
            for(int j =0; j<arr[i].length(); j++) {
               if(!list.contains(arr[i].charAt(j)-97) ) {
                  break;
               }
               if(j== arr[i].length()-1) {
                  cnt++;
               }
            }
         }
         max= Math.max(cnt, max);
         return ;
      }
      
      
      for(int i = start; i<alpha.length; i++) {
         if(!list.contains(i)) {
            list.add(i);
            combi(idx+1,i+1,list);  
            list.remove(list.size()-1);
         }
      }
   }
}