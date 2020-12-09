import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class crci07p2 {
    static int[] dp[], arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        for (int[] a : dp) {
            Arrays.fill(a, 2_000_000_000);
        }
        recurse(2, 1);

        System.out.println(dp[2][1]);
    }

    static void recurse(int p, int len){
        if(dp[p][len] != 2_000_000_000) return;
        else if(p == N) dp[p][len] = arr[p];
        else {
            if(p + len + 1 <= N) {
                recurse(p + len + 1, len + 1);
                dp[p][len] = Math.min(dp[p][len], dp[p + len + 1][len + 1]);
            }
            if(p - len > 0){
                recurse(p - len, len);
                dp[p][len] = Math.min(dp[p][len], dp[p - len][len]);
            }

            dp[p][len] += arr[p];
        }
    }
}