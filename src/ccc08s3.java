import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ccc08s3 {
    static char[][] map;
    static int[][] dist;
    static boolean[][] visit;
    static int T, R, C, inf = 1 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        for (int i = 0; i < T; i++) {
            R = Integer.parseInt(in.readLine());
            C = Integer.parseInt(in.readLine());
            map = new char[R][C];
            dist = new int[R][C];
            visit = new boolean[R][C];

            String s;
            for (int j = 0; j < R; j++) {
                s = in.readLine();
                for (int k = 0; k < C; k++) {
                    map[j][k] = s.charAt(k);
                }
            }
            if(map[R - 1][C - 1] == '*') {
                System.out.println(-1);
                continue;
            }

            bfs();
            System.out.println(dist[R - 1][C - 1] == inf ? -1 : dist[R - 1][C - 1] + 1);
        }
    }

    static void bfs(){
        Queue<Pair> queue = new ArrayDeque<>();
        for (int[] a : dist) {
            Arrays.fill(a, inf);
        }
        dist[0][0] = 0;
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            if(visit[p.r][p.c]) continue;
            else if(map[p.r][p.c] == '*') continue;
            if(p.r == R - 1 && p.c == C - 1) return;

            visit[p.r][p.c] = true;
            switch (map[p.r][p.c]){
                case '+':{
                    if(p.r + 1 < R && dist[p.r][p.c] + 1 < dist[p.r + 1][p.c]){
                        dist[p.r + 1][p.c] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r + 1, p.c));
                    }
                    if(p.r - 1 >= 0 && dist[p.r][p.c] + 1 < dist[p.r - 1][p.c]){
                        dist[p.r - 1][p.c] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r - 1, p.c));
                    }
                    if(p.c + 1 < C && dist[p.r][p.c] + 1 < dist[p.r][p.c + 1]){
                        dist[p.r][p.c + 1] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r, p.c + 1));
                    }
                    if(p.c - 1 >= 0 && dist[p.r][p.c] + 1 < dist[p.r][p.c - 1]){
                        dist[p.r][p.c - 1] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r, p.c - 1));
                    }
                    break;
                }
                case '-':{
                    if(p.c + 1 < C && dist[p.r][p.c] + 1 < dist[p.r][p.c + 1]){
                        dist[p.r][p.c + 1] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r, p.c + 1));
                    }
                    if(p.c - 1 >= 0 && dist[p.r][p.c] + 1 < dist[p.r][p.c - 1]){
                        dist[p.r][p.c - 1] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r, p.c - 1));
                    }
                    break;
                }
                case '|':{
                    if(p.r + 1 < R && dist[p.r][p.c] + 1 < dist[p.r + 1][p.c]){
                        dist[p.r + 1][p.c] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r + 1, p.c));
                    }
                    if(p.r - 1 >= 0 && dist[p.r][p.c] + 1 < dist[p.r - 1][p.c]){
                        dist[p.r - 1][p.c] = dist[p.r][p.c] + 1;
                        queue.offer(new Pair(p.r - 1, p.c));
                    }
                    break;
                }
            }
        }
    }

    static class Pair{
        int r, c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
