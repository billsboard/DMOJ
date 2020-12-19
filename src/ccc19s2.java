import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc19s2 {
    static boolean[] primes = new boolean[2000000];
    static int idx = 1, N, T;

    public static void main(String[] args) throws IOException {
        primes[2] = true;
        for (int i = 3; i < 2000000; i += 2) {
            primes[i] = isPrime(i);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(in.readLine()) * 2;
            for (int j = 3; j <= N / 2; j+=2) {
                if(primes[j] && primes[N - j]){
                    System.out.printf("%d %d\n", j, N - j);
                    break;
                }
            }
        }
    }

    static boolean isPrime(int N){
        int sqrt = (int) Math.sqrt(N);
        if((N & 1) == 0) return false;
        for (int i = 3; i <= sqrt; i += 2) {
            if(N % i == 0) return false;
        }
        return true;
    }
}
