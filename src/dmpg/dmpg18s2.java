package dmpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmpg18s2 {
    static long[] arr, psa;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        arr = new long[N + 1]; psa = new long[N + 1];
        StringTokenizer tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            psa[i] = arr[i] + psa[i - 1];
        }

        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = 1; j + i <= N; j++) {
                sum += query(j, j + i);
            }
            System.out.println(sum);
        }


    }

    static long query(int l, int r){
        return psa[r] - psa[l - 1];
    }
}
