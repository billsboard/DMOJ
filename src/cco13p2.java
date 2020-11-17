import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cco13p2 {
    static int[] arr, seg;
    static HashMap<Integer, Integer> tbl = new HashMap<>();

    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(in.readLine());
        N = Integer.parseInt(tk.nextToken());
        X = (int) Math.pow(2, N);
        int Q = Integer.parseInt(tk.nextToken());

        arr = new int[X + 1];
        seg = new int[arr.length * 4];

        for (int i = 1; i <= X; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            tbl.put(arr[i], i);
        }

        build(1, X, 1);

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "R":
                    int I = Integer.parseInt(tk.nextToken());
                    int v = Integer.parseInt(tk.nextToken());
                    update(I, v, 1, X, 1);
                    tbl.remove(arr[I]);
                    tbl.put(v, I);
                    arr[I] = v;
                    break;
                case "W":
                    System.out.println(tbl.get(seg[1]));
                    break;
                case "S":
                    int y = Integer.parseInt(tk.nextToken());
                    System.out.println(query(y, 1, X, 1) - 1);
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

            seg[p] = Math.max(seg[p * 2], seg[p * 2 + 1]);
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

            seg[p] = Math.max(seg[p * 2], seg[p * 2 + 1]);
        }
    }

    static int query(int i, int rl, int rr, int p){
        if(rl == rr) return 1;
        else{
            int x = 0;
            if(seg[p] == arr[i]) x = 1;

            int mid = (rl + rr) / 2;
            if(i <=  mid){
                return x + query(i, rl, mid, p * 2);
            }
            else{
                return x + query(i, mid + 1, rr,p * 2 + 1);
            }

        }
    }
}
