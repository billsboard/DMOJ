import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boardgames {
    static int N, M, inf = 1 << 30;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); M = Integer.parseInt(tk.nextToken());
        dist = new int[10_000_000];

        bfs();
        System.out.println(dist[M]);
    }

    static void bfs(){
        Arrays.fill(dist, inf);
        dist[N] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        while (!queue.isEmpty()){
            int v = queue.poll();
            if(v == M) return;
            if(v * 3 <= 10_000_000 && dist[v * 3] > dist[v] + 1){
                dist[v * 3] = dist[v] + 1;
                queue.offer(v * 3);
            }
            if(v - 1 > 0 && dist[v - 1] > dist[v] + 1){
                dist[v - 1] = dist[v] + 1;
                queue.offer(v - 1);
            }
            if(v - 3 > 0 && dist[v - 3] > dist[v] + 1){
                dist[v - 3] = dist[v] + 1;
                queue.offer(v - 3);
            }
            if((v & 1) == 0 && dist[v >> 1] > dist[v] + 1){
                dist[v >> 1] = dist[v] + 1;
                queue.offer(v >> 1);
            }
        }
    }
}