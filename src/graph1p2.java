import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class graph1p2 {

    static ArrayList<Integer>[] adj;
    static int N, min = Integer.MAX_VALUE;
    static int[] dist;
    static Queue<Integer> queue = new LinkedList<>();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(tk.nextToken());
                if(v == 1){
                    adj[i].add(j);
                }
            }
        }

        queue.add(0);
        dist = new int[N];

        Arrays.fill(dist, 2_000_000_000);
        dist[0] = 0;

        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int i : adj[v]) {
                if(dist[v] + 1 < dist[i]){
                    dist[i] = dist[v] + 1;
                    queue.add(i);
                }
            }
        }

        System.out.println(dist[N - 1]);
    }
}
