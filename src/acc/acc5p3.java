package acc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acc5p3 {
    static int[] pri, dsc, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken()), C = Integer.parseInt(tk.nextToken());
        long sum = 0;
        pri = new int[N]; dsc = new int[N]; diff = new int[N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            pri[i] = Integer.parseInt(tk.nextToken());
            dsc[i] = Integer.parseInt(tk.nextToken());
            diff[i] = pri[i] - dsc[i];
            sum += pri[i];
        }


        Arrays.sort(diff);
        for (int i = diff.length - 1; i >= 0 && C > 0; i--, C--) {
            sum -= diff[i];
        }

        System.out.println(sum);

    }
}
