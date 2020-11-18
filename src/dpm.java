import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpm {

    static int[][] dp, psa;
    static int[] arr;
    static int N, K, mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        N = Integer.parseInt(tk.nextToken()); K = Integer.parseInt(tk.nextToken());
        dp = new int[N + 1][K + 1];
        psa = new int[N + 1][K + 1];

        arr = new int[N + 1];
        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp[0][0] = 0;
        for (int i = 0; i <= Math.min(K, arr[1]); i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            psa[i - 1][0] = dp[i - 1][0] % mod;
            for (int j = 1; j <= K; j++) {
                psa[i - 1][j] = (psa[i - 1][j - 1] % mod + dp[i - 1][j] % mod) % mod;
            }

            for (int j = 0; j <= K; j++) {
                int give = j - arr[i];

                if(give <= 0) dp[i][j] = psa[i - 1][j];
                else dp[i][j] = ((psa[i - 1][j] - psa[i - 1][give - 1]) % mod + mod) % mod;
            }
        }


        System.out.println(dp[N][K] % mod);
    }
}
