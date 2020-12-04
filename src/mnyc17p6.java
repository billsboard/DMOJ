import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.HashMap;
import java.util.StringTokenizer;

public class mnyc17p6 {

    static Segment[] seg;
    static Segment e = new Segment();
    static int[] arr;
    static int N, Q, idx = 1;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); Q = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(in.readLine());

        arr = new int[N + 1];
        seg = new Segment[4 * N + 4];

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(tk.nextToken());
            if(!map.containsKey(x)){
                map.put(x, idx);
                idx++;
            }
            arr[i] = map.get(x);
        }
        build(1, N, 1);

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "1":{
                    int I = Integer.parseInt(tk.nextToken()), v = Integer.parseInt(tk.nextToken());
                    if(!map.containsKey(v)){
                        map.put(v, idx);
                        idx++;
                    }
                    update(I, map.get(v), 1, N, 1);
                    arr[I] = map.get(v);
                    break;
                }
                case "2":{
                    int l = Integer.parseInt(tk.nextToken()), r = Integer.parseInt(tk.nextToken());
                    System.out.println(query(l, r, 1, N, 1).bs.cardinality());
                    break;
                }
            }
        }
    }

    static void build(int rl, int rr, int p){
        if(rl == rr) seg[p] = new Segment(arr[rl]);
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = combine(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static void update(int i, int v, int rl, int rr, int p){
        if(rl == rr){
            seg[p].bs.clear(arr[i]);
            seg[p].bs.set(v);
        }
        else{
            int mid = (rl + rr) / 2;
            if(i <= mid){
                update(i, v, rl, mid, p * 2);
            }
            else {
                update(i, v, mid + 1, rr, p * 2 + 1);
            }
            seg[p] = combine(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static Segment query(int ql, int qr, int rl, int rr, int p){
        if(rl > qr || rr < ql) return e;
        else if(ql <= rl && rr <= qr) return seg[p];
        else{
            int mid = (rl + rr) / 2;
            return combine(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }



    static Segment combine(Segment a, Segment b){
        Segment c = new Segment();
        c.bs.or(a.bs);
        c.bs.or(b.bs);
        return c;
    }

    static class Segment{
        BitSet bs = new BitSet();

        public Segment(int freq){
            bs.set(freq);
        }

        Segment(){}
    }
}
