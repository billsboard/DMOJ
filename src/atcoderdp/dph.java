package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dph {
    static int[][] map, dp;
    static int H, W;
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        H = Integer.parseInt(tk.nextToken()); W = Integer.parseInt(tk.nextToken());
        map = new int[H + 1][W + 1];
        dp = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            tk = new StringTokenizer(in.readLine(), ".#", true);
            for (int j = 1; j <= W; j++) {
                map[i][j] = tk.nextToken().equals(".") ? 0 : 1;
            }
        }


        dp[0][1] = 1;

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if(map[i][j] == 1) dp[i][j] = 0;
                else{
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        System.out.println(dp[H][W] % MOD);
    }
}