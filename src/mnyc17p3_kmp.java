import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mnyc17p3_kmp {
    static String A, B, S;
    static int N, M, L;
    static int[] kmp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        A = tk.nextToken(); B = tk.nextToken();
        N = A.length(); M = B.length();

        S = B + "#" + A;
        L = S.length();
        kmp = new int[L];

        for (int i = 1; i < L; i++) {
            int best = kmp[i - 1];
            while (best > 0 && S.charAt(i) != S.charAt(best)){
                best = kmp[best - 1];
            }
            if(S.charAt(best) == S.charAt(i))
                best++;

            kmp[i] = best;
        }

        System.out.println(A.substring(0, N - kmp[L - 1]) + B);
    }
}
