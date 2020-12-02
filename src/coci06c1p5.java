import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coci06c1p5 {

    static double dp[], arr[][];
    static boolean[] cache;
    static int N, high;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        high = 1 << N;

        dp = new double[high];
        arr = new double[N][N];
        cache = new boolean[high];

        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Double.parseDouble(tk.nextToken()) / 100.0;
            }
        }

        recurse(high - 1);
        System.out.printf("%.6f\n", dp[high - 1] * 100);
    }

    static void recurse(int mask){
        if(Integer.bitCount(mask) == 1){
            dp[mask] = arr[0][lowPos(mask)];
            cache[mask] = true;
        }
        else if(!cache[mask]){
            cache[mask] = true;
            for (int i = 1; i < high; i = i << 1) {
                if((mask & i) != 0){
                    recurse(mask ^ i);
                    dp[mask] = Math.max(dp[mask], dp[mask ^ i] * arr[Integer.bitCount(mask) - 1][lowPos(i)]);
                }
            }
        }
    }

    static int lowPos(int n){
        int idx = 0;
        while ((n & 1) == 0){
            n = n >> 1;
            idx++;
        }
        return idx;
    }
}
