import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vmss7wc16c4p3 {

    static int[][] dp;
    static char[] a, b;

    static int D, I, R;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        D = Integer.parseInt(tk.nextToken()); I = Integer.parseInt(tk.nextToken()); R = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(in.readLine());
        String A = tk.nextToken(), B = tk.nextToken();
        a = A.toCharArray(); b = B.toCharArray();

        dp = new int[a.length + 1][b.length + 1];

        for (int i = 0; i <= b.length; i++) {
            dp[0][i] = i * I;
        }

        for (int i = 0; i <= a.length; i++) {
            dp[i][0] = i * D;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if(a[i - 1] == b[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else{
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + R,
                            Math.min(dp[i - 1][j] + D, dp[i][j - 1] + I)
                    );
                }
            }
        }

        System.out.println(dp[a.length][b.length]);

    }
}
