import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc15c1p6 {
    static long[] arr, seg, lazy;
    static int M, N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        M = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());
        Q = Integer.parseInt(tk.nextToken());

        arr = new long[N + 1];
        seg = new long[N * 4 + 4];
        lazy = new long[N * 4 + 4];

        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        build(1, N, 1);

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "1":
                    int ul = Integer.parseInt(tk.nextToken()), ur = Integer.parseInt(tk.nextToken()), v = Integer.parseInt(tk.nextToken());
                    update(ul, ur, v, 1, N, 1);
                    break;
                case "2":
                    int ql = Integer.parseInt(tk.nextToken()), qr = Integer.parseInt(tk.nextToken());
                    System.out.println(query(ql, qr, 1, N, 1) % M);
                    break;
            }
        }
    }

    static void build(int rl, int rr, int p){
        if(rl == rr) seg[p] = arr[rl];
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid,  p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = seg[p * 2] + seg[p * 2 + 1];
        }
    }

    static void update(int ul, int ur, long v, int rl, int rr, int p){
        if(lazy[p] != 0){
            seg[p] += lazy[p] * (rr - rl + 1);
            if(rl != rr){
                lazy[p * 2] += lazy[p];
                lazy[p * 2 + 1] += lazy[p];
            }
            lazy[p] = 0;
        }


        if(rr < ul || rl > ur) return;
        else if(ul <= rl && rr <= ur){
            seg[p] += v * (rr - rl + 1);
            if(rl != rr){
                lazy[p * 2] += v;
                lazy[p * 2 + 1] += v;
            }
        }
        else{
            int mid = (rl + rr) / 2;
            update(ul, ur, v, rl, mid, p * 2);
            update(ul, ur, v, mid + 1, rr, p * 2 + 1);
            seg[p] = seg[p * 2] + seg[p * 2 + 1];
        }
    }

    static long query(int ql, int qr, int rl, int rr, int p){
        if(lazy[p] != 0){
            seg[p] += lazy[p] * (rr - rl + 1);
            if(rl != rr){
                lazy[p * 2] += lazy[p];
                lazy[p * 2 + 1] += lazy[p];
            }
            lazy[p] = 0;
        }

        if(rr < ql || rl > qr) return 0;
        if(ql <= rl && rr <= qr) return seg[p];
        else {
            int mid = (rr + rl) / 2;
            return query(ql, qr, rl, mid, p * 2) + query(ql, qr, mid + 1, rr, p * 2 + 1);
        }
    }
}
