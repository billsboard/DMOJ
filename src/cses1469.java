import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cses1469 {

    static int[] arr, seg;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer init = new StringTokenizer(reader.readLine());


        int N = Integer.parseInt(init.nextToken());
        int M = Integer.parseInt(init.nextToken());

        arr = new int[N + 1];
        seg = new int[N * 4];

        StringTokenizer line = new StringTokenizer(reader.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(line.nextToken());
        }

        build(1, N, 1);

        for (int i = 0; i < M; i++) {
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            String query = tokens.nextToken();
            switch (query){
                case "1":
                    update(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), 1, N, 1);
                    break;
                case "2":
                    System.out.println(query(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()), 1, N, 1));
                    break;
            }
        }
    }




    static void build(int rl, int rr, int p){
        if(rl == rr){
            seg[p] = arr[rl];
        }
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static void update(int i, int v, int rl, int rr, int p){
        if(rl == rr){
            seg[p] = v;
        }
        else{
            int mid = (rl + rr) / 2;
            if(i <= mid){
                update(i, v, rl, mid, p * 2);
            }
            else{
                update(i, v, mid + 1, rr, p * 2 + 1);
            }

            seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static int query(int ql, int qr, int rl, int rr, int p){
        if(ql > rr || qr < rl) return Integer.MAX_VALUE;
        else if(rl >= ql && rr <= qr) return seg[p];
        else{
            int mid = (rr + rl) / 2;
            return Math.min(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }
}
