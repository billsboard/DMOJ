import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class segtree {
    static int[] arr, seg;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); Q = Integer.parseInt(tk.nextToken());

        arr = new int[N + 1]; seg = new int[N * 4 + 4];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        build(1, N, 1);

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "Q":{
                    System.out.println(query(Integer.parseInt(tk.nextToken()) + 1, Integer.parseInt(tk.nextToken()) + 1, 1, N, 1));
                    break;
                }
                default:{
                    update(Integer.parseInt(tk.nextToken()) + 1, Integer.parseInt(tk.nextToken()), 1, N, 1);
                    break;
                }
            }
        }
    }

    static void build(int rl, int rr, int p){
        if(rl == rr) seg[p] = arr[rl];
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr,p * 2 + 1);
            seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static void update(int i, int v, int rl, int rr, int p){
        if(rl == rr) seg[p] = v;
        else {
            int mid = (rl + rr) / 2;
            if(i <= mid) update(i, v, rl, mid, p * 2);
            else update(i, v, mid + 1, rr, p * 2 + 1);
            seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static int query(int ql, int qr, int rl, int rr, int p){
        if(rl > qr || rr < ql) return Integer.MAX_VALUE;
        else if(rl >= ql && rr <= qr) return seg[p];
        else{
            int mid = (rl + rr) / 2;
            return Math.min(
                query(ql, qr, rl, mid, p * 2),
                query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }
}
