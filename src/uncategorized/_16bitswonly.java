package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16bitswonly {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer tk;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            System.out.println(Integer.parseInt(tk.nextToken()) * Long.parseLong(tk.nextToken()) == Long.parseLong(tk.nextToken()) ?
                    "POSSIBLE DOUBLE SIGMA" : "16 BIT S/W ONLY");
        }
    }
}
