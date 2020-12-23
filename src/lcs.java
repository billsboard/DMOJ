import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lcs {
    static int[][] dp;
    static int[] A, B;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        M = Integer.parseInt(tk.nextToken()); N = Integer.parseInt(tk.nextToken());
        A = new int[M + 1]; B = new int[N + 1];
        dp = new int[M + 1][N + 1];

        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= M; i++) {
            A[i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            B[i] = Integer.parseInt(tk.nextToken());
        }

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        recurse(M, N);
        System.out.println(dp[M][N]);
    }

    static void recurse(int a, int b){
        if(a == 0 || b == 0){
            dp[a][b] = 0;
        }
        else if(a == 1 && b == 1 && A[a] == B[b]){
            dp[a][b] = 1;
        }
        else if(dp[a][b] == -1){
            if(A[a] == B[b]){
                recurse(a - 1, b - 1);
                dp[a][b] = dp[a - 1][b - 1] + 1;
            }
            else{
                recurse(a - 1, b);
                recurse(a, b - 1);
                dp[a][b] = Math.max(dp[a - 1][b], dp[a][b - 1]);
            }

        }
    }
}
