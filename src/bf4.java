import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf4 {
    static int N, M, H = 3;
    static long[] hash[], pow[], prime = {1_000_000_007, 1_000_000_009, 1_000_000_027}, base = {217, 314, 1024};
    static long[] key = new long[H];
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        S = in.readLine(); T = in.readLine();
        N = S.length(); M = T.length();

        hash = new long[H][N]; pow = new long[H][N];
        for (int i = 0; i < H; i++) {
            pow[i][0] = 1;
            for (int j = 1; j < N; j++) {
                pow[i][j] = (pow[i][j - 1] * base[i]) % prime[i];
            }
        }

        for (int i = 0; i < H; i++) {
            hash(i);
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                key[i] = (key[i] * base[i] + T.charAt(j)) % prime[i];
            }
        }

        int idx = -1;
        loop:
        for (int i = 0; i < N; i++) {
            if(i + M > N) break;
            else{
                for (int j = 0; j < H; j++) {
                    if(ss(j, i, i + M - 1) != key[j]) continue loop;
                }
                idx = i;
                break;
            }
        }
        System.out.println(idx);
    }

    static long ss(int i, int l, int r){
        if(l == 0) return hash[i][r];
        long tmp = (hash[i][r] - (hash[i][l - 1] * pow[i][r - l + 1])) % prime[i];
        return tmp < 0 ? tmp + prime[i] : tmp;
    }

    static void hash(int i){
        hash[i][0] = S.charAt(0);
        for (int j = 1; j < N; j++) {
            hash[i][j] = (hash[i][j - 1] * base[i] + S.charAt(j)) % prime[i];
        }
    }
}
