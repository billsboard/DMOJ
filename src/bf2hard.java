import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bf2hard {
    static int N, K, H = 2;
    static String S;
    static long[] hash[], pow[], base = {271, 314}, prime = {1_000_000_007, 1_000_000_009};

    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        S = in.readLine(); K = Integer.parseInt(in.readLine());
        N = S.length();
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

        loop:
        for (int i = 1; i < N; i++) {
            if(i + K > N) break;
            for (int j = 0; j < H; j++) {
                if(!before(j, i))
                {
                    continue loop;
                }
            }
            idx = i;
        }

        System.out.println(S.substring(idx, idx + K));
    }

    static void hash(int i){
        hash[i][0] = S.charAt(0);
        for (int j = 1; j < N; j++) {
            hash[i][j] = (hash[i][j - 1] * base[i] + S.charAt(j)) % prime[i];
        }
    }

    static long ss(int i, int l, int r){
        if(l == 0) return hash[i][r];
        long tmp = (hash[i][r] - (hash[i][l - 1] * pow[i][r - l + 1])) % prime[i];
        return tmp < 0 ? tmp + prime[i] : tmp;
    }

    static boolean before(int i, int l){
        int ll = 0, lr = K;
        while (ll < lr){
            int mid = (ll + lr + 1) / 2;
            if(ss(i, l, l + mid - 1) == ss(i, idx, idx + mid - 1))
                ll = mid;
            else
                lr = mid - 1;
        }

        if(idx + ll + 1 >= N || l + ll + 1 >= N){
            return true;
        }
        else {
            return S.charAt(l + ll) < S.charAt(idx + ll);
        }

    }


}
