import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dpl {

    static long[] dp[], arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk = new StringTokenizer(in.readLine());

        arr = new long[N];
        dp = new long[N][N];
        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        recurse(0, N - 1, true);
        System.out.println(dp[0][N - 1]);

    }

    static void recurse(int l, int r, boolean turn){
        if(l == r) dp[l][r] = turn ? arr[r] : -arr[r];
        else if(l > r) dp[l][r] = 0;
        else if(dp[l][r] == -1){
            recurse(l + 1, r, !turn);
            recurse(l, r - 1, !turn);
            if(turn) {
                dp[l][r] = Math.max(dp[l + 1][r] + arr[l], dp[l][r - 1] + arr[r]);
            }
            else if(!turn){
                dp[l][r] = Math.min(dp[l + 1][r] - arr[l], dp[l][r - 1] - arr[r]);
            }
        }
    }
}
