import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpo {

    static int[] dp;
    static boolean[] cache;
    static boolean[][] arr;
    static int N, high, mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new boolean[N][N];
        StringTokenizer tk;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken()) == 1;
            }
        }

        high = (int) Math.pow(2, N);
        dp = new int[high];
        cache = new boolean[high];
        recurse(high - 1);
        System.out.println(dp[high - 1] % mod);

    }

    static void recurse(int w){
        if(cache[w]) return;
        cache[w] = true;
        if((w & (-w)) == w && arr[countOn(w) - 1][getPos(w)]) {
            dp[w] += 1;
        }
        else if((w & (-w)) != w){
            for (int i = 0; i < N; i++) {
                int msk = 1 << i;
                if((w & msk) != 0 && arr[countOn(w) - 1][i]) {
                    recurse(w ^ msk);
                    dp[w] = (dp[w] % mod + dp[w ^ msk] % mod) % mod;
                }
            }
        }
    }

    static int getPos(int n){
        if(n == 0) return -1;
        int pos = 0;
        while ((n & 1) == 0){
            pos++;
            n = n >> 1;
        }
        return pos;
    }

    static int countOn(int i){
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >>> 24;
    }
}
