import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc11s4 {

    static int arr[][];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        arr = new int[2][8];

        for (int i = 0; i < 8; i++) {
            arr[1][i] = Integer.parseInt(tk.nextToken());
        }
        tk = new StringTokenizer(in.readLine());
        for (int i = 0; i < 8; i++) {
            arr[0][i] = Integer.parseInt(tk.nextToken());
        }

        cnt += Math.min(arr[0][0], arr[1][0]);
        int x = arr[0][0];
        arr[0][0] = Math.max(0, arr[0][0] - arr[1][0]);
        arr[1][0] = x - arr[0][0];

        System.out.println(arr[1][0] + " " + cnt + " " + arr[0][0]);
    }
}
