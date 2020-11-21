package dmopc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc20c1p3 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        arr = new int[N];

        int max = Integer.MIN_VALUE;
        int p = -1;

        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            if(arr[i] > max){
                max = arr[i];
                p = i;
            }
        }

        int pre = arr[0];
        long power = 0;
        for (int i = 1; i < p; i++) {
            power += pre > arr[i] ? pre - arr[i] : 0;
            pre = arr[i] > pre ? arr[i] : pre;
        }

        pre = arr[N - 1];
        for (int i = N - 2; i > p; i--) {
            power += pre > arr[i] ? pre - arr[i] : 0;
            pre = arr[i] > pre ? arr[i] : pre;
        }

        System.out.println(power);
    }
}
