package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpd {

    static int[][] arr;
    static long[] dp;
    static int N, W;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        N = Integer.parseInt(tk.nextToken()); W = Integer.parseInt(tk.nextToken());
        arr = new int[N][2];
        dp = new long[W + 1];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = W; j > 0; j--) {
                if(arr[i][0] > j){}
                else {
                    dp[j] = Math.max(dp[j - arr[i][0]] + arr[i][1], dp[j]);
                }
            }
        }

        System.out.println(dp[W]);

    }
}
