package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpj {
    static int[] arr;
    static double[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk = new StringTokenizer(in.readLine());

        arr = new int[N + 1];
        int a = 0, b = 0, c = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            switch (arr[i]){
                case 1:
                    a++;
                    break;
                case 2:
                    b++;
                    break;
                default:
                    c++;
                    break;
            }
        }

        dp = new double[N + 1][N + 1][N + 1];
        dp[0][0][0] = 0;
        recurse(a, b, c);
        System.out.println(dp[a][b][c]);
    }

    static void recurse(int a, int b, int c){
        if(a < 0 || b < 0 || c < 0) return;
        else if(a == 0 && b == 0 && c == 0) return;
        else if(dp[a][b][c] != 0) return;
        double sum = a + b + c;
        recurse(a - 1, b, c);
        recurse(a + 1, b - 1, c);
        recurse(a, b + 1, c - 1);
        dp[a][b][c] = (
                (a - 1 >= 0 ? (a / sum) * (dp[a - 1][b][c] + 1) : 0) +
                (b - 1 >= 0 ? (b / sum) * (dp[a + 1][b - 1][c] + 1) : 0) +
                (c - 1 >= 0 ? (c / sum) * (dp[a][b + 1][c - 1] + 1) : 0) +
                (N/sum - 1.0)
                );
    }
}
