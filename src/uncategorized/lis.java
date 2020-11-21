package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lis {
    static int[] seg, arr, coord, sort;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N + 1]; coord = new int[N + 1];
        seg = new int[4 * N + 4];

        StringTokenizer tk = new StringTokenizer(in.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        sort = arr.clone();
        Arrays.sort(sort);

        for (int i = 1; i <= N; i++) {
            coord[i] = Arrays.binarySearch(sort, arr[i]);
        }
        for (int i = 1; i <= N; i++) {
            update(coord[i], 1,1, N, 1);
        }

        for (int i = 1; i <= N; i++) {
            update(coord[i], query(1, coord[i], 1, N, 1) + 1, 1, N, 1);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, query(coord[i], coord[i], 1, N, 1));
        }
        System.out.println(max);
    }


    static void build(int rl, int rr, int p){
        if(rl == rr){
            seg[p] = coord[rl];
        }
        else {
            int mid = (rl + rr) / 2;
            build(rl, mid, p * 2);
            build(mid + 1, rr, p * 2 + 1);
            seg[p] = Math.max(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static void update(int i, int v, int rl, int rr, int p){
        if(i < 0) return;
        if(rl == rr){
            seg[p] = v;
        }
        else{
            int mid = (rl + rr) / 2;
            if(i <= mid){
                update(i, v, rl, mid, p * 2);
            }
            else {
                update(i, v, mid + 1, rr, p * 2 + 1);
            }
        }
    }

    static int query(int ql, int qr, int rl, int rr, int p){
        if(qr < ql) return 0;
        else if(rl >= ql && rr <= qr) return seg[p];
        else if(ql > rr || qr < rl) return 0;
        else{
            int mid = (rl + rr) / 2;
            return Math.max(
                    query(ql, qr, rl, mid, p * 2),
                    query(ql, qr, mid + 1, rr, p * 2 + 1)
            );
        }
    }
}
