import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class vmss7wc16c5p3 {

    static int N;
    static ArrayList<Integer>[] adj;
    static long[] dp1, dp2;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        StringTokenizer tk;
        for (int i = 0; i < N - 1; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        dp1 = new long[N + 1]; dp2 = new long[N + 1];
        recurse(1, 0);
        System.out.println(dp1[1] + dp2[1]);
    }

    static void recurse(int p, int prev){
        for(int x : adj[p]){
            if(x != prev){
                recurse(x, p);
                if(dp1[x] + 1 > dp1[p]){
                    dp2[p] = dp1[p];
                    dp1[p] = dp1[x] + 1;
                }
                else if(dp1[x] + 1 > dp2[p]){
                    dp2[p] = dp1[x] + 1;
                }
            }
        }
    }
}
