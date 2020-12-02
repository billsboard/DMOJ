import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dwite11c1p5 {

    static int dp[][], len;
    static String line;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            line = in.readLine();
            len = line.length();
            dp = new int[len][len];

            recurse(0, len - 1);
            System.out.println(dp[0][len - 1]);
        }
    }

    static void recurse(int l, int r){
        if(l > r) dp[l][r] = 0;
        else if(l == r) dp[l][r] = 1;
        else if(dp[l][r] == 0){
            if(line.charAt(l) == line.charAt(r)){
                recurse(l + 1, r - 1);
                dp[l][r] = 2 + dp[l + 1][r - 1];
            }
            else {
                recurse(l + 1, r);
                recurse(l, r - 1);
                dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
            }
        }
    }
}
