package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc12s5 {
    static int[][] arr, dp;
    static int R, C, K;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        R = Integer.parseInt(tk.nextToken()); C = Integer.parseInt(tk.nextToken());

        K = Integer.parseInt(in.readLine());

        arr = new int[R + 1][C + 1];
        dp = new int[R + 1][C + 1];

        for (int i = 0; i < K; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[Integer.parseInt(tk.nextToken())][Integer.parseInt(tk.nextToken())] = 1;
        }

        dp[0][1] = 1;

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(arr[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[R][C]);
    }
}
