import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpb {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());


        int N = Integer.parseInt(tk.nextToken()), K = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N + 1], dp = new int[N + 1];

        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= K; j++) {
                if(i - j < 1) break;
                min = Math.min(min, Math.abs(arr[i] - arr[i - j]) + dp[i - j]);
            }

            dp[i] = min;
        }

        System.out.println(dp[N]);
    }
}
