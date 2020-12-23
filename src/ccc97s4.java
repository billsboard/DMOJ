import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ccc97s4 {
    static HashMap<String, Integer> dict = new HashMap<>();
    static int N, idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            dict = new HashMap<>();
            idx = 1;
            StringTokenizer tk;
            String line;
            while (!(line = in.readLine()).isEmpty()){
                sb = new StringBuilder();
                tk = new StringTokenizer(line);
                while (tk.hasMoreTokens()){
                    String s = tk.nextToken();
                    if(dict.containsKey(s)){
                        sb.append(dict.get(s)).append(" ");
                    }
                    else {
                        dict.put(s, idx++);
                        sb.append(s).append(" ");
                    }
                }
                System.out.println(sb.toString().trim());
            }
            System.out.println();
        }
    }
}
