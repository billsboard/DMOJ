package dmopc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc14c2p4 {

    static int[] psa, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        arr = new int[N];
        psa = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        build();

        int Q = Integer.parseInt(in.readLine());
        StringTokenizer tk;
        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            if(a == 0) System.out.println(psa[b]);
            else System.out.println(psa[b] - psa[a - 1]);
        }
    }


    static void build(){
        psa[0] = arr[0];
        for (int i = 1; i < psa.length; i++) {
            psa[i] = psa[i - 1] + arr[i];
        }
    }
}
