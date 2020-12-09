import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ccc96s3 {
    static int N;
    static ArrayList<Integer> print;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            print = new ArrayList<>();
            System.out.println("The bit patterns are");
            tk = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tk.nextToken());
            recurse(0, n, Integer.parseInt(tk.nextToken()), 0);
            Collections.sort(print);
            for (int j = print.size() - 1; j >= 0; j--) {
                System.out.println(String.format("%" + n + "s",
                        Integer.toBinaryString(print.get(j))).replace(" ", "0"));
            }
            System.out.println();
        }


    }

    static void recurse(int num, int n, int k, int idx){
        if(Integer.bitCount(num) == k){
            print.add(num);
        }
        else if(Integer.bitCount(num) > k) return;
        else{
            for (int i = idx; i < n; i++) {
                int mask = num | (1 << i);
                recurse(mask, n, k, i + 1);
            }
        }
    }
}
