import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class ccc02s4 {

    static String[] names;
    static int[] arr, dp, back, seg;
    static int N, M;
    static Stack<String> cache = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(in.readLine());
        N = Integer.parseInt(in.readLine());

        names = new String[N + 1];
        arr = new int[N + 1]; dp = new int[N + 1]; back = new int[N + 1];
        seg = new int[4 * N + 4];

        Arrays.fill(dp, 2_000_000_000);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            names[i] = in.readLine();
            arr[i] = Integer.parseInt(in.readLine());
        }
        build(1, N, 1);

        recurse(N);
        System.out.printf("Total Time: %d\n", dp[N]);
        int idx = N;
        StringBuilder sb;
        while (idx > 0){
            if(idx == 1){
                cache.push(names[1]);
                break;
            }
            int p = idx - back[idx];
            sb = new StringBuilder();
            for (int i = p + 1; i <= idx; i++) {
                sb.append(names[i]).append(" ");
            }
            cache.push(sb.toString().trim());
            idx = p;
        }

        while (!cache.isEmpty()){
            System.out.println(cache.pop());
        }
    }

    static void recurse(int p){
        if(p == 1) dp[p] = arr[p];
        else if(dp[p] == 2_000_000_000){
            int m = 0;
            for (int i = 1; i <= M; i++) {
                if(p - i < 0) break;
                recurse(p - i);
                int x = dp[p - i] + query(p - i + 1, p, 1, N, 1);
                if(x < dp[p]){
                    m = i;
                    dp[p] = x;
                }
            }
            back[p] = m;
        }
    }

    static void build(int rl, int rr, int p){
        if(rl == rr) seg[p] = arr[rl];
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = Math.max(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static int query(int ql, int qr, int rl, int rr, int p){
        if(rl > qr || rr < ql) return Integer.MIN_VALUE;
        else if(rl >= ql && rr <= qr) return seg[p];
        else{
            int mid = (rl + rr) / 2;
            return Math.max(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }
}
