import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dpk {

    static int[] dp, arr;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        N = Integer.parseInt(tk.nextToken()); K = Integer.parseInt(tk.nextToken());
        arr = new int[N]; dp = new int[K + 1];

        tk = new StringTokenizer(in.readLine());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            min = Math.min(min, arr[i]);
        }



        dp[0] = -1;
        for (int i = 1; i < min; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= K; i++) {
            int val = dp[i];
            for (int j = 0; j < N; j++) {
                if(i - arr[j] >= 0){
                    if(dp[i - arr[j]] == -1) val = 1;
                    else if(dp[i - arr[j]] == 1 && val != 1) val = -1;

                    dp[i] = val;
                }
            }
        }

        System.out.println(dp[K] == 1 ? "First" : "Second");
    }
}
