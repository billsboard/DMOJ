import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class dmopc20c2p1 {
    static char[][] arr = new char[2001][2001];
    static int N, X = 0, Y = 1000, yH = 1000, yL = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        for (char[] a : arr) {
            Arrays.fill(a, '.');
        }

        StringTokenizer tk = new StringTokenizer(in.readLine(), "^v>", true);
        for (int i = 0; i < N; i++) {
            char c = tk.nextToken().charAt(0);
            switch (c){
                case '^':
                    arr[X][Y] = '/';
                    Y++;
                    yH = Math.max(yH, Y);
                    break;
                case 'v':
                    Y--;
                    arr[X][Y] = '\\';
                    yL = Math.min(yL, Y);
                    break;
                default:
                    arr[X][Y] = '_';
            }
            X++;
        }

        for (int i = yH == yL ? yH : yH - 1; i >= yL; i--) {
            for (int j = 0; j < X; j++) {
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }

    }
}
