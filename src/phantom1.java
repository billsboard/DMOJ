import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class phantom1 {
    static int[] primes = new int[501];
    static int idx = 1, N;

    public static void main(String[] args) throws IOException {
        primes[0] = 2;
        outer:
        for (int i = 3; i < 500; i += 2) {
            for (int j = 0; j < idx; j++) {
                if(i % primes[j] == 0) continue outer;
            }
            primes[idx] = i;
            idx++;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            int cnt = 0, loc = 0, l = Integer.parseInt(tk.nextToken()), r = Integer.parseInt(tk.nextToken());
            while (primes[loc] < l && loc < idx) {
                loc++;
            }
            while (primes[loc] < r && loc < idx){
                cnt++;
                loc++;
            }
            System.out.println(cnt);
        }


    }
}
