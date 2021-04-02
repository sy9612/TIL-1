package sw_expert.Solution;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
 
/*20200306 SW7396. 종구의 딸이름 짓기*/
 
public class 종구의딸이름짓기_Solution {
    static char[][] map;
    static boolean[][] visit;
    static int N,M;
    static int[] di = {0, 1};
    static int[] dj = {1, 0};
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
        int TC = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= TC; tc++) {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);
             
            map = new char[N][];
            visit = new boolean[N][M];
            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }
             
            bw.write("#" + tc + " ");
            PriorityQueue<Point>pq = new PriorityQueue<>();
            ArrayList<Point> list = new ArrayList<>();
            pq.add(new Point(0, 0, map[0][0])); // 출발점
            visit[0][0] = true;
             
            while(!pq.isEmpty()) {
                int size = pq.size();
                 
                Point first = pq.peek(); // 현재 큐에 있는 글자중에 알파벳순 제일 빠른게 뭔지 일단 확보.
                for(int s = 0; s < size; s++) { // 이름의 같은 위치에 올 가능성이 잇는 글자들 싹 빼기 (ex: 이름 3번째에 올 수 있는 글자들)
                    Point now = pq.poll(); // 큐에서 빼면서
                     
                    if(first.ch == now.ch) { // 내가 관심있는 알파벳 빠른 좌표들만 추려서
                        for(int d = 0; d < 2; d++) {
                            int ni = now.i + di[d];
                            int nj = now.j + dj[d];
                             
                            if(ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj]) {
                                list.add(new Point(ni, nj, map[ni][nj])); // 리스트에 옮겨담는 작업.
                                visit[ni][nj] = true;
                            }
                        }
                    }else {
                        break;
                    }
                } // 출발점에서 거리가 같은 좌표의 탐색이 끝난.
                pq.clear();
                pq.addAll(list); // 알파벳 빠른거 따로 추렸으니까 얘내만 스케줄에 넣어서 탐색하자
                list.clear();
                bw.write(first.ch);
            }
                bw.write("\n");
        }
        br.close();
//      bw.flush();
        bw.close();
    }// end main
     
    static class Point implements Comparable<Point>{
        int i, j;
        char ch;
        public Point(int i, int j, char ch) {
            this.i = i;
            this.j = j;
            this.ch = ch;
        }
        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            return this.ch - o.ch;
        }
         
         
    }
}
