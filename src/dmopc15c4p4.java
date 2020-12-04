import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc15c4p4 {

    static int N, K, Q;
    static long[] arr, psa;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); K = Integer.parseInt(tk.nextToken()); Q = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());

        arr = new long[N + 1];
        psa = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            psa[i] = psa[i - 1] + arr[i];
        }

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tk.nextToken()), b = Integer.parseInt(tk.nextToken()),
                    l = Integer.parseInt(tk.nextToken()), r = Integer.parseInt(tk.nextToken());

            if(psa[r] - psa[l - 1] > K && contains(l, r, a) && contains(l, r, b)) System.out.println("Yes");
            else System.out.println("No");
        }
    }


    static boolean contains(int l, int r, int v){
        for (int i = l; i <= r; i++) {
            if(arr[i] == v) return true;
        }
        return false;
    }
}
