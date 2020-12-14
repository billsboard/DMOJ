import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* Same problem as dwite09c6p4 */
public class dwite08c3p4 {
    static int[] dp, arr;
    static int M, N, INF = 2_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 5; i++){
            M = Integer.parseInt(in.readLine()); N = Integer.parseInt(in.readLine());

            dp = new int[M + 1];
            arr = new int[N];
            Arrays.fill(dp, INF);
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(in.readLine());
                dp[arr[j]] = 1;
            }
            dp[0] = 0;
            recurse(M);
            System.out.println(dp[M] ==  INF ? 0 : dp[M]);
        }
    }

    static void recurse(int m){
        if(dp[m] == INF){
            for (int i = 0; i < N; i++) {
                if(m - arr[i] > 0){
                    recurse(m - arr[i]);
                    dp[m] = Math.min(dp[m - arr[i]] + 1, dp[m]);
                }
            }
        }
    }
}
