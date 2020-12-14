import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ccc03s4 {
    static int N, L, H = 2;
    static String S;
    static long[] hash[], pow[], base = {271, 314}, prime = {Integer.MAX_VALUE, (1 << 29) - 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        pow = new long[H][5001];
        for (int i = 0; i < H; i++) {
            pow[i][0] = 1;
            for (int j = 1; j < 5001; j++) {
                pow[i][j] = pow[i][j - 1] * base[i] % prime[i];
            }
        }
        for (int i = 0; i < N; i++) {
            S = in.readLine();
            L = S.length();
            hash = new long[H][L];
            for (int j = 0; j < H; j++) {
                generate(j);
            }

            int cnt = 0;
            for (int j = 1; j <= L; j++) {
                HashSet<Long> set = new HashSet<>();
                for (int k = 0; k <= L - j; k++) {
                    set.add(store(ss(0, k, k + j - 1), ss(1, k, k + j - 1)));
                }
                cnt += set.size();
            }
            System.out.println(cnt + 1);
        }
    }

    static void generate(int i){
        hash[i][0] = S.charAt(0);
        for (int j = 1; j < L; j++) {
            hash[i][j] = (hash[i][j - 1] * base[i] + S.charAt(j)) % prime[i];
        }
    }

    static long ss(int i, int l, int r){
        if(l == 0) return hash[i][r];
        long tmp = (hash[i][r] - (hash[i][l - 1] * pow[i][r - l + 1])) % prime[i];
        return tmp < 0 ? tmp + prime[i] : tmp;
    }

    static long store(long a, long b){
        long c = a << 32;
        c = c | b;
        return c;
    }
}