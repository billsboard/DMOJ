import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc07s3 {
    static int[] adj = new int[10000];
    static boolean[] visited = new boolean[10000];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            adj[x] = y;
        }
        String s;
        while (!(s = in.readLine()).equals("0 0")){
            tk = new StringTokenizer(s);
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            Arrays.fill(visited, false);
            int dist = connect(x, y, 0);
            System.out.println(dist == -1 ? "No" : "Yes " + (dist - 1));
        }
    }

    static int connect(int x, int y, int len){
        if(x == y) return len;
        else if(visited[x]) return -1;
        else {
            visited[x] = true;
            return connect(adj[x], y, len + 1);
        }
    }

}
