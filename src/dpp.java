import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class dpp {

    static int N, mod = 1_000_000_007;
    static ArrayList<Integer>[] adj;
    static long[] dpw, dpb;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adj = new ArrayList[N + 1];
        dpw = new long[N + 1]; dpb = new long[N + 1];
        StringTokenizer tk;

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            adj[x].add(y); adj[y].add(x);
        }

        recurse(1, 0);
        System.out.println((dpw[1] + dpb[1]) % mod);
    }

    static void recurse(int p, int prev){
        dpw[p] = 1; dpb[p] = 1;
        for (int x : adj[p]) {
            if(x != prev) {
                recurse(x, p);
                dpw[p] = (dpw[p] * (dpw[x] + dpb[x]) % mod) % mod;
                dpb[p] = (dpb[p] * (dpw[x] % mod)) % mod;
            }
        }
    }
}
