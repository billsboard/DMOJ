package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpc {
    static int[] A, B, C, arr[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        N = Integer.parseInt(tk.nextToken());
        A = new int[N + 1]; B = new int[N + 1]; C = new int[N + 1]; arr = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
            arr[i][2] = Integer.parseInt(tk.nextToken());
        }


        A[0] = arr[0][0];
        B[0] = arr[0][1];
        C[0] = arr[0][2];

        for (int i = 1; i < N; i++) {
            A[i] = Math.max(B[i - 1], C[i - 1]) + arr[i][0];
            B[i] = Math.max(A[i - 1], C[i - 1]) + arr[i][1];
            C[i] = Math.max(B[i - 1], A[i - 1]) + arr[i][2];
        }

        System.out.println(
                Math.max(Math.max(B[N - 1], A[N - 1]), C[N - 1])
        );

    }
}
