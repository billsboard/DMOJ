import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmpg17s2 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken()), Q = Integer.parseInt(tk.nextToken());

        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < Q; i++) {
            tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "A":
                    int x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
                    union(x, y);
                    break;
                case "Q":
                    int a = Integer.parseInt(tk.nextToken()), b = Integer.parseInt(tk.nextToken());
                    System.out.println(find(a, b) ? "Y" : "N");
                    break;
            }
        }

    }

    static int root(int i){
        if(arr[i] == i) return i;
        else{
            return arr[i] = root(arr[i]);
        }
    }
    static void union(int a, int b){
        int ar = root(a);
        int br = root(b);
        if(ar != br){
            arr[ar] = br;
        }
    }
    static boolean find(int a, int b){
        return root(a) == root(b);
    }

}
