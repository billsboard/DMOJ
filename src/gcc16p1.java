import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class gcc16p1 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        tk.nextToken();

        int A = Integer.parseInt(tk.nextToken()), C = Integer.parseInt(tk.nextToken());

        arr = new int[(A + C) * 2 + 1][2];

        for (int i = 0; i < A; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i * 2] = new int[]{Integer.parseInt(tk.nextToken()), 0};
            arr[i * 2 + 1] = new int[]{Integer.parseInt(tk.nextToken()) + 1, 1};
        }

        int S = A + C;
        for (int i = A; i < S; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i * 2] = new int[]{Integer.parseInt(tk.nextToken()), 2};
            arr[i * 2 + 1] = new int[]{Integer.parseInt(tk.nextToken()) + 1, 3};
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        int out = 0, can = 0, cant = 0;
        for (int i = 1; i < arr.length; i++) {
            if(can != 0 && cant == 0) out += arr[i][0] - arr[i-1][0];
            switch (arr[i][1]){
                case 0:
                    can++;
                    break;
                case 1:
                    can--;
                    break;
                case 2:
                    cant++;
                    break;
                case 3:
                    cant--;
                    break;
            }
        }

        System.out.println(out);
    }
}