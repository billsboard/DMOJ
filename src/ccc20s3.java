import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ccc20s3 {
    static int U, V, H = 2;
    static long[] hsh[], pow[], base = {131, 137}, prime = {1_000_000_007, 1 << 31 - 1};
    static int[] freq = new int['z' + 1], key = new int['z' + 1];
    static String S, T;
    static HashSet<Long> dist = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = in.readLine(); V = T.length();
        S = in.readLine(); U = S.length();

        if(V > U){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < V; i++) {
            key[T.charAt(i)]++;
            freq[S.charAt(i)]++;
        }

        hsh = new long[H][U]; pow = new long[H][U];
        for (int i = 0; i < H; i++) {
            pow[i][0] = 1;
            for (int j = 1; j < U; j++) {
                pow[i][j] = pow[i][j - 1] * base[i] % prime[i];
            }
        }
        for (int i = 0; i < H; i++) {
            hash(i);
        }

        boolean ok = true;
        for (int i = 'a'; i <= 'z'; i++) {
            if(key[i] != freq[i]){
                ok = false;
                break;
            }
        }
        if(ok){
            dist.add(store(ss(0, 0, V - 1), ss(1, 0, V - 1)));
        }

        for (int i = 0; i < U; i++) {
            if(i + V >= U) break;
            freq[S.charAt(i)]--;
            freq[S.charAt(i + V)]++;
            ok = true;
            for (int j = 'a'; j <= 'z'; j++) {
                if(key[j] != freq[j]){
                    ok = false;
                    break;
                }
            }
            if(ok){
                dist.add(store(ss(0, i + 1, i + V), ss(1, i + 1, i + V)));
            }
        }
        System.out.println(dist.size());
    }

    static void hash(int i){
        hsh[i][0] = S.charAt(0);
        for (int j = 1; j < U; j++) {
            hsh[i][j] = (hsh[i][j - 1] * base[i] + S.charAt(j)) % prime[i];
        }
    }

    static long ss(int i, int l, int r){
        if(l == 0) return hsh[i][r];
        long tmp = (hsh[i][r] - (hsh[i][l - 1] * pow[i][r - l + 1])) % prime[i];
        return tmp < 0 ? tmp + prime[i] : tmp;
    }

    static long store(long a, long b){
        return (a << 32) | b;
    }
}