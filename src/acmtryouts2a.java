import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acmtryouts2a {
    static int[] adj = new int[8 * 4 + 1];
    static int N;

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 32; i++) {
            adj[i - 1] = i;
        }
        adj[2] = 13;
        adj[14] = 29;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine(), "-", false);
            int cnt = 1, idx = (Integer.parseInt(tk.nextToken()) - 1) * 4 + Integer.parseInt(tk.nextToken());
            while (idx != 32){
                cnt++;
                idx = adj[idx];
            }
            System.out.println(cnt);
        }

    }
}
