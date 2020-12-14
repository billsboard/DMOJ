import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ecna05h {
    static int[] arr, dp[];
    static int N, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer tk;
        while (!(s = in.readLine()).equals("0")){
            cnt++;
            tk = new StringTokenizer(s);
            N = Integer.parseInt(tk.nextToken());
            arr = new int[N + 1];
            dp =  new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }

            for (int[] a : dp) {
                Arrays.fill(a, -1);
            }
            recurse(1, N, 1);
            System.out.printf("In game %d, the greedy strategy might lose by as many as %d points.\n", cnt, dp[1][N]);
        }
    }

    static void recurse(int l, int r, int p){
        if(l == r) dp[l][r] = p * arr[l];
        else if(l > r) dp[l][r] = 0;
        else if(dp[l][r] == -1){
            if(p == 1){
                recurse(l + 1, r, -1);
                recurse(l, r - 1, -1);
                dp[l][r] = Math.max(dp[l + 1][r] + arr[l], dp[l][r - 1] + arr[r]);
            }
            else {
                if(arr[l] >= arr[r]) {
                    recurse(l + 1, r, 1);
                    dp[l][r] = dp[l + 1][r] - arr[l];
                }
                else {
                    recurse(l, r - 1, 1);
                    dp[l][r] = dp[l][r - 1] - arr[r];
                }
            }
        }
    }
}
