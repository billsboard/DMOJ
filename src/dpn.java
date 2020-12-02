import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dpn {

    static long[][] dp;
    static long[] psa;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk = new StringTokenizer(in.readLine());

        psa = new long[N + 1];
        dp = new long[N + 1][N + 1];

        for (long[] a : dp) {
            Arrays.fill(a, Long.MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            psa[i] = psa[i - 1] + Integer.parseInt(tk.nextToken());
        }

        recurse(1, N);
        System.out.println(dp[1][N]);
    }

    static void recurse(int l, int r){
        if(dp[l][r] != Long.MAX_VALUE) return;
        if(l >= r) dp[l][r] = 0;
        else {
            for (int i = l; i < r; i++) {
                recurse(l, i);
                recurse(i + 1, r);
                dp[l][r] = Math.min(
                        dp[l][r], dp[l][i] + dp[i + 1][r] + (psa[r] - psa[l - 1])
                );
            }
        }
    }
}
