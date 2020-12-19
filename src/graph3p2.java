import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class graph3p2 {
    static ArrayList<Pair>[] adj;
    static int dist[];
    static int N, M, inf = 1 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); M = Integer.parseInt(tk.nextToken());

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken()), w = Integer.parseInt(tk.nextToken());
            adj[x].add(new Pair(y, w));
        }
        bfs();
        System.out.println(dist[N]);
    }

    static void bfs(){
        Arrays.fill(dist, inf);
        dist[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (Pair p : adj[v]) {
                if(dist[v] + p.d < dist[p.v]){
                    dist[p.v] = dist[v] + p.d;
                    queue.offer(p.v);
                }
            }
        }
    }


    static class Pair{
        int v, d;
        Pair(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
}
