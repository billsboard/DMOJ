package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pacnw16j {

    static long[] arr, seg;
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        N = Integer.parseInt(tk.nextToken());
        Q = Integer.parseInt(tk.nextToken());

        arr = new long[N + 1];
        seg = new long[4*N + 4];
        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(tk.nextToken());
        }

        build(1, N, 1);
        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());

            long m = Long.parseLong(tk.nextToken());
            int l = Integer.parseInt(tk.nextToken());
            int r = Integer.parseInt(tk.nextToken());

            int c = query(l, r, m, 1, N, 1);
            while (c != -1){
                m %= arr[c];
                c = query(c + 1, r, m, 1, N, 1);
            }
            System.out.println(m);
        }

    }

    static void build(int rl, int rr, int p){
        if(rl == rr) {
            seg[p] = arr[rl];
        }
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p*2+1);
            seg[p] = Math.min(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static int query(int ql, int qr, long x, int rl, int rr, int p){
        if(rl > qr || rr < ql) return -1;
        else if(ql <= rl && rr <= qr && x < seg[p]) return -1;
        else if(rl == rr) return arr[rl] <= x ? rl : -1;
        else{
            int mid = (rl + rr) / 2;
            int t;
            return (t = query(ql, qr, x, rl, mid, p * 2)) != -1 ? t : query(ql, qr, x,mid + 1, rr, p * 2 + 1);
        }
    }
}
