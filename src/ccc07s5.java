import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc07s5 {

    static int[][] dp;
    static int[] arr, psa;
    static int N, K, W;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringTokenizer tk;

        for (int i = 0; i < T; i++) {
            tk = new StringTokenizer(in.readLine());
            N = Integer.parseInt(tk.nextToken()); K = Integer.parseInt(tk.nextToken()); W = Integer.parseInt(tk.nextToken());
            arr = new int[N + 1];
            psa = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(in.readLine());
                psa[j] = psa[j - 1] + arr[j];
            }

            dp = new int[N + 1][K + 1];
            recurse(N, K);
            System.out.println(dp[N][K]);
        }
    }

    static void recurse(int n, int k){
        if(n <= 0 || k <= 0) return;
        if(dp[n][k] != 0) return;

        recurse(n - 1,  k);
        recurse(n - W, k - 1);

        dp[n][k] = Math.max(dp[n - 1][k], n - W >= 0 ? dp[n - W][k - 1] + (psa[n] - psa[n - W]) : 0);

    }
}
