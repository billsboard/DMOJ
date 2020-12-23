import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ctuopen2017a {
    static int[] arr;
    static int N, d, len;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringTokenizer tk;
        while ((s = in.readLine()) != null && !s.isEmpty()){
            N = Integer.parseInt(s);
            tk = new StringTokenizer(in.readLine());
            len = 2;

            if(N == 1){
                System.out.println(1);
                continue;
            }

            arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }
            d = arr[N] - arr[N - 1];

            for (int i = N - 2; i > 0; i--) {
                if(arr[i + 1] - arr[i] != d) break;
                len++;
            }

            System.out.println(N - len + 1);
        }
    }
}
