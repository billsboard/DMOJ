import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bts17p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        StringBuilder sb = new StringBuilder();

        while (tk.hasMoreTokens()){
            String s = tk.nextToken();
            if(65 <= s.charAt(0) && 90 >= s.charAt(0))
                sb.append(".");
            sb.append(" ").append(s);
        }
        sb.append(".");

        if(sb.charAt(0) == '.') sb.deleteCharAt(0);

        System.out.println(sb.substring(1));
    }
}
