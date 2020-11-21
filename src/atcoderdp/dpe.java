package atcoderdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpe {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        arr = new int[Integer.parseInt(tk.nextToken()) + 1][2];
        int W = Integer.parseInt(tk.nextToken());

        for (int i = 1; i < arr.length; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i] = new int[]{Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken())};
        }

        System.out.println(recurse(arr.length - 1, W));
    }

    static int recurse(int p, int w){
        if(p == 0 || w <= 0) return 0;
        else if(w < arr[p][0]) return recurse(p - 1, w);
        else{
            return Math.max(
                    recurse(p - 1, w - arr[p][0]) + arr[p][1],
                    recurse(p - 1, w)
            );
        }
    }
}
