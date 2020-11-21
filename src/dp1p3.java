import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp1p3 {

    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        arr = new int[N + 1]; dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans + 1);
    }
}
