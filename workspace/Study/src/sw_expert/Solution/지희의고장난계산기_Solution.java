package sw_expert.Solution;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class 지희의고장난계산기_Solution {
    private static boolean[] num;
    private static int min;
    private static int X;
    private static int size;
    private static int[] memo;
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            min = Integer.MAX_VALUE;            
            String  line = br.readLine();
            num = new boolean[10];
            for (int i = 0; i < 10; i++) {
                if(line.charAt(2*i)-'0' == 1)
                    num[i] = true;
            }
            X = Integer.parseInt(br.readLine());
            size = (int)Math.sqrt(X);
            memo = new int[size];
            find(X,0);
            min = min == Integer.MAX_VALUE? -1 : min;
            System.out.println("#"+testCase+" "+min);
        }// end of test case
    }// end of main
    private static int find(int x, int cnt) {
        if(x<size && memo[x] != 0 ) {
            return memo[x];
        }
        if(isMake(x+"")) {
            int count = len(x)+1;
            if(cnt ==0)
                min = count;
            if(x<size)
                memo[x] = count;
            return count;
        }
        int result = -1; 
        for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; i++) {
            if(x%i==0 && isMake(i+"")) {
                int len1 = len(i) +1;
                int len2 = find(x/i, cnt +1);
                if(len2> -1) {
                    result = len1 + len2;
                    if(result < min && x ==X)
                        min = result;
                }
            }
        }
        if(x<size){
        memo[x] = result;   
        }
        return result;
    }
    private static int len(int x2) {
        return (int)Math.log10(x2)+1;
    }
    private static boolean isMake(String x) {
        for(char c : x.toCharArray()) {
            if(!num[c-'0']) {
                return false;
            }
        }
        return true;
    }
}//end of class