import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coci06c5p5 {

    static int[] arr;
    static int[][] dp;
    static int N, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[2 * N + 2];
        dp = new int[2 * N + 2][2 * N + 2];

        StringTokenizer tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            arr[N + i] = arr[i];
        }

        for (int[] a : dp) {
            Arrays.fill(a, Integer.MIN_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            recurse(i + 1, i + N - 1, -1);
            if(dp[i + 1][i + N - 1] + (arr[i] & 1) > 0) cnt++;
        }
        System.out.println(cnt);
    }

    static void recurse(int l, int r, int p){
        if(l > r) return;
        else if(l == r) dp[l][r] = arr[l] & 1;
        else if(dp[l][r] == Integer.MIN_VALUE){
            recurse(l + 1, r, -p);
            recurse(l, r - 1, -p);
            if(p == 1){
                dp[l][r] = Math.max(dp[l + 1][r] + (arr[l] & 1), dp[l][r - 1] + (arr[r] & 1));
            }
            else{
                dp[l][r] = Math.min(dp[l + 1][r] - (arr[l] & 1), dp[l][r - 1] - (arr[r] & 1));
            }

        }
    }
}
