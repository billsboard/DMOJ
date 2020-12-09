import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc20c2p2 {

    static int[] f = new int[1000001], l = new int[1000001];
    static int N, M, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); M = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            int c = Integer.parseInt(tk.nextToken());
            if(f[c] == 0) f[c] = i;
            l[c] = i;
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            if(f[x] == 0 || f[y] == 0) continue;
            max = Math.max(
                    l[y] - f[x] + 1,
                    max
            );
        }
        System.out.println(max);
    }
}
