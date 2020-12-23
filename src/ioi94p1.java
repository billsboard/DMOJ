import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ioi94p1 {
    static int[][] arr, dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1][N + 1]; dp = new int[N + 1][N + 1];

        StringTokenizer tk;
        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 1; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        recurse(1, 1);
        System.out.println(dp[1][1]);
    }

    static void recurse(int r, int c){
        if(r == N){
            dp[r][c] = arr[r][c];
        }
        else if(dp[r][c] == -1){
            recurse(r + 1, c);
            recurse(r + 1, c + 1);
            dp[r][c] = Math.max(dp[r + 1][c], dp[r + 1][c + 1]) + arr[r][c];
        }

    }
}
