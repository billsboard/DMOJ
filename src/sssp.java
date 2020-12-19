import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sssp {
    static ArrayList<Pair>[] adj;
    static int[] dist;
    static boolean[] visit;
    static int N, M, inf = 1 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); M = Integer.parseInt(tk.nextToken());

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken()),
                    d = Integer.parseInt(tk.nextToken());
            adj[x].add(new Pair(y, d));
            adj[y].add(new Pair(x, d));
        }
        bfs();
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i] == inf ? -1 : dist[i]);
        }
    }

    static void bfs(){
        Arrays.fill(dist, inf);
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getD));
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()){
            Pair v = pq.poll();
            if(visit[v.v]) continue;

            visit[v.v] = true;
            for (Pair p : adj[v.v]) {
                if(!visit[p.v] && dist[p.v] > dist[v.v] + p.d){
                    dist[p.v] = dist[v.v] + p.d;
                    pq.offer(new Pair(p.v, dist[v.v] + p.d));
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

        public int getD() {
            return d;
        }
    }
}
