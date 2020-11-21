package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken());
        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(in.readLine(), " ", true);
            int X = Integer.parseInt(tk.nextToken(" "));
            StringBuilder s = new StringBuilder();
            while (tk.hasMoreTokens()){
                s.append(tk.nextToken(" "));
            }
            s = new StringBuilder(s.toString().trim());
            s.deleteCharAt(X - 1);
            System.out.println(i + " " + s.toString());
        }
    }
}
