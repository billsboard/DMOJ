package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ds3 {

    static int[] arr;
    static Segment[] seg;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] init = reader.readLine().split(" ");
        arr = new int[Integer.parseInt(init[0]) + 1];
        seg = new Segment[arr.length * 4];

        String[] aVals = reader.readLine().split(" ");
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(aVals[i - 1]);
        }

        build(1, arr.length - 1, 1);

        int M = Integer.parseInt(init[1]);
        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");
            switch (line[0]){
                case "C":{
                    update(Integer.parseInt(line[1]), Integer.parseInt(line[2]), 1, arr.length - 1, 1);
                    break;
                }
                case "M":{
                    Segment s = query(Integer.parseInt(line[1]), Integer.parseInt(line[2]), 1, arr.length - 1, 1);
                    System.out.println(s.m);
                    break;
                }
                case "G":{
                    Segment s = query(Integer.parseInt(line[1]), Integer.parseInt(line[2]), 1, arr.length - 1, 1);
                    System.out.println(s.g);
                    break;
                }
                case "Q":{
                    Segment s = query(Integer.parseInt(line[1]), Integer.parseInt(line[2]), 1, arr.length - 1, 1);
                    System.out.println(s.q);
                    break;
                }
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
            seg[p] = Segment.combine(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static void update(int i, int v, int rl, int rr, int p){
        //System.out.println(i + " " + v + " " + rl + " " + rr + " " + p);
        if(rl == rr){
            seg[p] = new Segment(v);
            //System.out.println(seg[p].m);
        }
        else {
            int mid = (rl + rr) / 2;
            if(i <= mid){
                update(i, v, rl, mid, p * 2);
                seg[p] = Segment.combine(seg[p * 2], seg[p * 2 + 1]);
            }
            else {
                update(i, v, mid + 1, rr, p * 2 + 1);
                seg[p] = Segment.combine(seg[p * 2], seg[p * 2 + 1]);
            }
        }
    }

    static Segment query(int ql, int qr, int rl, int rr, int p){
        if(ql > rr || qr < rl) return null;
        else if (ql <= rl && qr >= rr) {
            return seg[p];
        }
        else{
            int mid = (rl + rr) / 2;
            return Segment.combine(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p*2 + 1)
            );
        }
    }

    static class Segment{
        int m, g, q;

        Segment(int val){
            m = val;
            g = val;
            q = 1;
        }

        Segment(){}

        int gcd(int a, int b){
            if(a == 0) return b;
            return gcd(b % a, a);
        }

        public static Segment combine(Segment a, Segment b){
            if(a == null && b == null) return null;
            else if(a == null) return b;
            else if(b == null) return a;

            Segment s = new Segment();
            s.m = Math.min(a.m, b.m);
            s.g = s.gcd(a.g, b.g);

            if(a.g == s.g) s.q += a.q;
            if(b.g == s.g) s.q += b.q;

            return s;
        }


    }
}
