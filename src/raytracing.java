import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class raytracing {

    static int[][] fen;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());


        arr = new int[N + 1];
        fen = new int[N + 1][8194];
        StringTokenizer tk = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken()) + 1;
            update(i, arr[i], 1);
        }



        int Q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(reader.readLine());
            switch (tk.nextToken()){
                case "1":
                    int qi = Integer.parseInt(tk.nextToken()) + 1;
                    int qj = Integer.parseInt(tk.nextToken()) + 1;
                    int a = Integer.parseInt(tk.nextToken());
                    int b = Integer.parseInt(tk.nextToken());
                    System.out.println(query(qi, qj, a+1, b+1));
                    break;
                case "2":
                    int x = Integer.parseInt(tk.nextToken()) + 1;
                    int y = Integer.parseInt(tk.nextToken());
                    update(x, arr[x], -1);
                    arr[x] = y + 1;
                    update(x, y + 1, 1);
                    break;
            }
        }

    }


    static void update(int x, int y, int val){
        for (int i = x; i < fen.length; i += (i & -i)) {
            for (int j = y; j < fen[i].length ; j += (j & -j)) {
                fen[i][j] += val;
            }
        }
    }

    
    static int query(int i, int j, int a, int b){
        int preSum = 0;
        for(int x = i - 1; x > 0; x -= (x & -x)){
            for (int k = b; k > 0; k -= (k & -k)) {
                preSum += fen[x][k];
            }
        }

        for(int x = j; x > 0; x -= (x & -x)){
            for (int k = a - 1; k > 0; k -= (k & -k)) {
                preSum += fen[x][k];
            }
        }

        for(int x = i - 1; x > 0; x -= (x & -x)){
            for (int k = a - 1; k > 0; k -= (k & -k)) {
                preSum -= fen[x][k];
            }
        }


        int sum = 0;
        for(int x = j; x > 0; x -= (x & -x)){
            for (int k = b; k > 0; k -= (k & -k)){
                sum += fen[x][k];
            }
        }

        return sum - preSum;
    }
}