package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc00s4 {

    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(in.readLine()), C = Integer.parseInt(in.readLine());
        arr = new int[C];
        dp = new int[D + 1];
        for (int i = 0; i < C; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            dp[arr[i]] = 1;
        }



        for (int i = 1; i <= D; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i - arr[j] >= 0){
                    if(dp[i] == 0) dp[i] = dp[i - arr[j]] == 0 ? 0 : 1 + dp[i - arr[j]];
                    dp[i] = Math.min(dp[i] == 0 ? Integer.MAX_VALUE : dp[i], dp[i - arr[j]] == 0 ? Integer.MAX_VALUE : 1 + dp[i - arr[j]]);
                    if(dp[i] == Integer.MAX_VALUE) dp[i] = 0;
                }
            }
        }

        System.out.println(dp[D] == 0 ? "Roberta acknowledges defeat." : "Roberta wins in " + dp[D] + " strokes.");
    }
}
