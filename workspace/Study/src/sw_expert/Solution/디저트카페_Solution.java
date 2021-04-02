package sw_expert.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class 디저트카페_Solution {
     
    static int N;
    static int max;
    static int sr;
    static int sc;
    static int[][] map;
    static boolean[] visited;
    static int[][] dir4 = {{1,1},{1,-1},{-1,-1},{-1,1}};
     
    public static void main(String[] args) {
        Scanner sq = new Scanner(System.in);
    	int T = sq.nextInt();
        for (int tc = 1; tc <= T; tc++) {
        	System.out.print("#" + tc + " ");
        	//      max를 0으로 초기화
            max = -1;
            //      크기 N을 입력받아 N*N 배열생성
            N = sq.nextInt();
            map = new int[N][N];
            //      N*N boolean 타입의 배열을 생성
            visited = new boolean[101];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = sq.nextInt();
                }               
            }
            // 탐색 (dfs)
            //      N*N을 돌면서 i,j 카페부터 투어
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    //      시작 좌표를 i,j로 설정
                    sr = i;
                    sc = j;
                    //      visited 배열을 초기화
                    Arrays.fill(visited, false);
                    //      dfs 탐색(i, j, dir)
                    dfs(i,j,0, 1);                  
                }
            }
            // 출력 max==0?-1:max
            System.out.println(max);
        }
    }
     
    private static void dfs(int r, int c, int dir, int cnt) {
        //          현재 노드에 대한 방문 처리
        visited[map[r][c]] = true;
        //          현재 방향에서부터 반복 하면서
        for (int d = dir; d < dir4.length; d++) {
            int nr = r+dir4[d][0];
            int nc = c+dir4[d][1];
            //          다음 좌표가 시작좌표인지 확인
            if(nr==sr && nc==sc && cnt>=4) {
                //          cnt를 max값과 비교해서 갱신
                if(cnt > max) {
                    max = cnt;
                    return;
                }
            }
            //          다음 좌표 경계검사, 방문검사, 값 검사
            if(isIn(nr,nc) && !visited[map[nr][nc]]) {
                //          다음 노드로 이동 => 재귀 호출
                dfs(nr, nc, d,cnt+1);
            }
        }
        //          visited 해제
        visited[map[r][c]] = false; 
    }
     
    static boolean isIn(int x, int y) {
        return x>=0 && y>=0 && x<map.length && y<map[0].length;
    }
}