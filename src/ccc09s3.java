import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("unchecked")
public class ccc09s3 {
    static ArrayList<Integer>[] adj = new ArrayList[50];
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 50; i++) {
            adj[i] = new ArrayList<>();
        }
        init();

        String s;
        while (!(s = in.readLine()).equals("q")){
            switch (s){
                case "i": {
                    int x = Integer.parseInt(in.readLine()), y = Integer.parseInt(in.readLine());
                    friend(x, y);
                    break;
                }
                case "d": {
                    int x = Integer.parseInt(in.readLine()), y = Integer.parseInt(in.readLine());
                    adj[x].remove(Integer.valueOf(y));
                    adj[y].remove(Integer.valueOf(x));
                    break;
                }
                case "n": {
                    int x = Integer.parseInt(in.readLine());
                    System.out.println(adj[x].size());
                    break;
                }
                case "f":{
                    HashSet<Integer> fri = new HashSet<>();
                    int x = Integer.parseInt(in.readLine());
                    for (int y : adj[x]) {
                        fri.addAll(adj[y]);
                    }
                    fri.removeAll(adj[x]);
                    fri.remove(x);
                    System.out.println(fri.size());
                    break;
                }
                case "s":{
                    dist = new int[50];
                    int x = Integer.parseInt(in.readLine()), y = Integer.parseInt(in.readLine());
                    int dist = bfs(x, y);
                    System.out.println(dist == (1 << 30) ? "Not connected" : dist);

                }
            }
        }
    }

    static int bfs(int x, int y){
        Arrays.fill(dist, 1 << 30);
        dist[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while (!queue.isEmpty()){
            int v = queue.poll();
            for (int i : adj[v]) {
                if(dist[v] + 1 < dist[i]) {
                    queue.offer(i);
                    dist[i] = dist[v] + 1;
                }
            }
        }

        return dist[y];
    }

    static void init(){
        friend(2, 6);
        friend(1, 6);
        friend(3, 6);
        friend(3, 4);
        friend(3, 5);
        friend(4, 5);
        friend(4, 6);
        friend(5, 6);
        friend(6, 7);
        friend(7, 8);
        friend(8, 9);
        friend(9, 10);
        friend(9, 12);
        friend(11, 12);
        friend(10, 11);
        friend(3, 15);
        friend(12, 13);
        friend(13, 15);
        friend(13, 14);
        friend(16, 18);
        friend(17, 18);
        friend(17, 16);
    }

    static void friend(int x, int y){
        if (!adj[x].contains(y)) {
            adj[x].add(y);
            adj[y].add(x);
        }
    }
}
