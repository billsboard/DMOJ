import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpi {
    static double[] arr, dp[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        arr = new double[N + 1];
        dp = new double[N + 1][N + 1];

        StringTokenizer tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Double.parseDouble(tk.nextToken());
        }
        dp[1][1] = arr[1];
        dp[0][0] = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] * arr[i] + dp[i - 1][j] * (1 - arr[i]);
            }
        }

        double sum = 0;
        for (int i = N / 2 + 1; i <= N; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum);

    }
}
