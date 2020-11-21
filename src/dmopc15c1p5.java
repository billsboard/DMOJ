import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dmopc15c1p5 {

    static int[][] arr, psa;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int W = Integer.parseInt(tk.nextToken()), H = Integer.parseInt(tk.nextToken()), N = Integer.parseInt(tk.nextToken());
        arr = new int[H + 1][W + 1];
        psa = new int[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            tk = new StringTokenizer(in.readLine());
            psa[i][0] = psa[i - 1][W];
            for (int j = 1; j <= W; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken());
                psa[i][j] = arr[i][j] + psa[i][j - 1];
            }
        }

        System.out.println(Arrays.deepToString(psa));

        for (int i = 1; i <= W; i++) {
            if(N % i != 0) continue;

            int j = N / i;
            for (int k = 1; k + j - 1 <= H; k++) {
                for (int l = 1; l + i - 1 <= W; l++) {
                    max = Math.max(query(k, l, k + j - 1, l + i - 1), max);
                }
            }
        }

        System.out.println(max);
    }

    static int query(int y1, int x1, int y2, int x2){
        return psa[y2][x2] - psa[y2][x1 - 1] - psa[y1 - 1][x2] + psa[y1 - 1][x1 - 1];
    }
}
