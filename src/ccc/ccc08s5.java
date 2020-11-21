package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc08s5 {

    static int[][][][] dp;
    static int[][] mv = {{2, 1, 0, 2}, {1, 1, 1, 1}, {0, 0, 2, 1}, {0, 3, 0, 0}, {1, 0, 0, 1}};
    static int[] arr = new int[4];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
            }

            dp = new int[arr[0] + 1][arr[1] + 1][arr[2] + 1][arr[3] + 1];
            recurse(arr[0], arr[1], arr[2], arr[3]);
            System.out.println(dp[arr[0]][arr[1]][arr[2]][arr[3]] == 1 ? "Patrick" : "Roland");
        }
    }

    static void recurse(int a, int b, int c, int d){
        if(a < 0 || b < 0 || c < 0 || d < 0) return;
        if(dp[a][b][c][d] != 0) return;

        for (int[] m : mv) {
            recurse(a - m[0], b - m[1], c - m[2], d - m[3]);
            if(a - m[0] >= 0 && b - m[1] >= 0 && c - m[2] >= 0 && d - m[3] >= 0 && dp[a - m[0]][b - m[1]][c - m[2]][d - m[3]] == 0) dp[a][b][c][d] = 1;
        }
    }
}
