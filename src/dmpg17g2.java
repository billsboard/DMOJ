import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmpg17g2 {
    static int arr[];
    static Segment[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken()), Q = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1];
        seg = new Segment[N * 4 + 4];

        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        build(1, N, 1);

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "S":
                    int I = Integer.parseInt(tk.nextToken());
                    int v = Integer.parseInt(tk.nextToken());
                    update(I, v, 1, N, 1);
                    break;
                case "Q":
                    int ql = Integer.parseInt(tk.nextToken());
                    int qr = Integer.parseInt(tk.nextToken());
                    System.out.println(query(ql, qr, 1, N, 1).sub);
                    break;
            }
        }
    }

    static void build(int rl, int rr, int p){
        if(rl == rr){
            seg[p] = new Segment(arr[rl]);
        }
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = combine(seg[p * 2], seg[p * 2 + 1]);
        }

    }

    static void update(int i, int v, int rl, int rr, int p){
        if(rl == rr){
            seg[p] = new Segment(v);
        }
        else{
            int mid = (rl + rr) / 2;
            if(i <= mid){
                update(i, v, rl, mid, p * 2);
            }
            else{
                update(i, v, mid + 1, rr, p * 2 + 1);
            }

            seg[p] = combine(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static Segment query(int ql, int qr, int rl, int rr, int p){
        if(rr < ql || rl > qr) return null;
        else if(rl >= ql && rr <= qr){
            return seg[p];
        }
        else{
            int mid = (rl + rr) / 2;
            return combine(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }


    static Segment combine(Segment a, Segment b){
        if(a == null && b == null) return null;
        else if(a == null) return b;
        else if(b == null) return a;

        Segment c = new Segment();

        c.sum = a.sum + b.sum;
        c.pre = Math.max(a.pre, a.sum + b.pre);
        c.suf = Math.max(a.suf + b.sum, b.suf);
        c.sub = Math.max(
                Math.max(a.sub, b.sub),
                a.suf + b.pre
        );
        return c;
    }

    static class Segment{
        long sum, pre, suf, sub;

        Segment(){}

        Segment(long val){
            sum = val;
            pre = val;
            suf = val;
            sub = val;
        }
    }
}

