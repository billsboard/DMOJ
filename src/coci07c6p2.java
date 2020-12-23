import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coci07c6p2 {
    static int[][] arr;
    static int N, L, t = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); L = Integer.parseInt(tk.nextToken());
        arr = new int[L + 1][2];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tk.nextToken());
            arr[x][0] = Integer.parseInt(tk.nextToken());
            arr[x][1] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 1; i <= L; i++) {
            t++;
            t += wTime(i);
        }
        System.out.println(t - 1 + 1);
    }

    static int wTime(int p){
        if(arr[p][0] == 0) return 0;

        int r = arr[p][0], g = arr[p][1];
        int rem = t % (r + g);
        if(rem < r){
            return r - rem;
        }
        return 0;
    }
}
