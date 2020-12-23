import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class mnyc17p3 {
    static long[] aHsh[], bHsh[], base = {131, 137}, prime = {1_000_000_007, 1_000_000_023},
        pow[];
    static String A, B;
    static int N, M, H = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        A = tk.nextToken(); B = tk.nextToken();
        N = A.length(); M = B.length();

        pow = new long[H][Math.max(N, M)];
        aHsh = new long[H][N]; bHsh = new long[H][M];

        for (int i = 0; i < H; i++) {
            pow[i][0] = 1;
            for (int j = 1; j < pow[0].length; j++) {
                pow[i][j] = pow[i][j - 1] * base[i] % prime[i];
            }
        }

        for (int i = 0; i < H; i++) {
            aHsh[i][0] = A.charAt(0);
            for (int j = 1; j < N; j++) {
                aHsh[i][j] = (aHsh[i][j - 1] * base[i] + A.charAt(j)) % prime[i];
            }
        }
        for (int i = 0; i < H; i++) {
            bHsh[i][0] = B.charAt(0);
            for (int j = 1; j < M; j++) {
                bHsh[i][j] = (bHsh[i][j - 1] * base[i] + B.charAt(j)) % prime[i];
            }
        }

        int Ai = N - 1, Bi = 0, max = 0, len = 0;
        while (Ai >= 0 && Bi < M){
            len++;
            if(SSa(Ai, N - 1) == SSb(0, Bi)) {
                max = len;
            }
            Ai--;
            Bi++;
        }


        System.out.println(A.substring(0, N) + B.substring(max));
    }

    static long SSa(int l, int r){
        if(l == 0){
            return store(aHsh[0][r], aHsh[1][r]);
        }

        long a = (aHsh[0][r] - (aHsh[0][l - 1] * pow[0][r - l + 1])) % prime[0];
        long b = (aHsh[1][r] - (aHsh[1][l - 1] * pow[1][r - l + 1])) % prime[1];
        return store(a < 0 ? a + prime[0] : a, b < 0 ? b + prime[1] : b);
    }

    static long SSb(int l, int r){
        if(l == 0){
            return store(bHsh[0][r], bHsh[1][r]);
        }


        long a = (bHsh[0][r] - (bHsh[0][l - 1] * pow[0][r - l + 1])) % prime[0];
        long b = (bHsh[1][r] - (bHsh[1][l - 1] * pow[1][r - l + 1])) % prime[1];
        return store(a < 0 ? a + prime[0] : a, b < 0 ? b + prime[1] : b);
    }

    static long store(long a, long b){
        return (a << 32) | b;
    }
}
