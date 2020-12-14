import java.io.*;
import java.util.StringTokenizer;

/*
 * The input on this problem is really annoying. It is all in one big line, meaning that reading it in with
 * BufferedReader's readLine() and then using StringTokenizer will MLE. We get around this by using a custom
 * input method that uses BufferedReader. Objects are too slow to pass the time limit, so we return min and max
 * in one call of the recursive SegTree by using some bit shift techniques (we return a long that has 2 ints).
 *
 * This code still barely passes, with 0.05 - 0.1 seconds to spare, usually.
 * */

public class btoi07p3 {
    static int[] segMin, segMax, arr = new int[1000001];
    final static int inf = 2_000_000_000;
    static int N, M, C;
    static long id = ((long) inf << 32) | (-inf & 0xffffffffL);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken()); M = Integer.parseInt(tk.nextToken()); C = Integer.parseInt(tk.nextToken());
        for (int i = 1; i <= N; i++) {
            int x = 0;
            int c;
            while ((c = in.read()) != ' ' && c != '\n'){
                x *= 10;
                x += c - '0';
            }
            arr[i] = x;
        }
        segMin = new int[2097152];
        segMax = new int[2097152];
        build(1, N, 1);

        boolean ok = false;
        for (int i = 1; i <= N; i++) {
            if(i + M - 1 > N) break;
            //ql = i;
            //qr = i + M - 1;
            long l = query(i, i + M - 1,1, N, 1);
            if(((int) l) - (l >> 32) <= C) {
                System.out.println(i);
                ok = true;
            }
        }
        if(!ok) System.out.println("NONE");
    }

    static void build(int rl, int rr, int p){
        if(rl == rr) {
            segMin[p] = arr[rl];
            segMax[p] = arr[rl];
        }
        else{
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            segMin[p] = Math.min(segMin[p * 2], segMin[p * 2 + 1]);
            segMax[p] = Math.max(segMax[p * 2], segMax[p * 2 + 1]);
        }
    }

    static long query(int ql, int qr, int rl, int rr, int p){
        if(rl > qr || rr < ql) return id;
        else if(ql <= rl && rr <= qr) return ((long) segMin[p] << 32) | (segMax[p] & 0xffffffffL);
        else{
            int mid = (rl + rr) / 2;
            long a = query(ql, qr,rl, mid, p * 2);
            long b = query(ql, qr,mid + 1, rr, p * 2 + 1);

            long max = Math.max((int) a, (int) b);
            long min = Math.min(a >> 32, b >> 32);
            return (min << 32) | (max & 0xffffffffL);
        }
    }
}