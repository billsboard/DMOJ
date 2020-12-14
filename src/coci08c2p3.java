import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coci08c2p3 {
    static int N, high, diff = 1 << 29;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][2];
        StringTokenizer tk;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(tk.nextToken());
            arr[i][1] = Integer.parseInt(tk.nextToken());
        }
        high = 1 << N;
        int msk = high - 1;
        recurse(msk, 1, 0);
        System.out.println(diff);
    }

    static void recurse(int msk, int s, int b){
        if(msk != high - 1)
            diff = Math.min(diff, Math.abs(s - b));
        for (int i = 0; i < N; i++) {
            int and = 1 << i;
            if((msk & and) != 0){
                recurse(msk ^ and, s * arr[i][0], b + arr[i][1]);
            }
        }

    }
}
