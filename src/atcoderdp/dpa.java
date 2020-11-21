package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpa {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N + 1], dp = new int[N + 1];

        StringTokenizer tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp[1] = 0;
        dp[2] = Math.abs(arr[1] - arr[2]);
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.min(dp[i - 1] + Math.abs(arr[i - 1] - arr[i]), dp[i - 2] + Math.abs(arr[i - 2] - arr[i]));
        }

        System.out.println(dp[N]);
    }
}
