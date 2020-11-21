package vm7wc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class vmss7wc16c3p2 {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken()), M = Integer.parseInt(tk.nextToken()), A = Integer.parseInt(tk.nextToken()), B = Integer.parseInt(tk.nextToken());

        if(A == B) System.out.println("GO SHAHIR!");
        else{
            arr = new int[N + 1];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = i;
            }

            for (int i = 0; i < M; i++) {
                tk = new StringTokenizer(in.readLine());
                union(Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken()));
            }

            System.out.println(find(A, B) ? "GO SHAHIR!" : "NO SHAHIR!");
        }
    }

    static int root(int i){
        if(arr[i] == i) return i;
        return arr[i] = root(arr[i]);
    }

    static void union(int a, int b){
        int ar = root(a), br = root(b);
        if(ar != br){
            arr[ar] = br;
        }
    }

    static boolean find(int a, int b){
        return root(a) == root(b);
    }
}
