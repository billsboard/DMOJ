import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _boolean {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        boolean x = true;
        while (tk.hasMoreTokens()){
            switch (tk.nextToken()){
                case "not": case "False":
                    x = !x;
            }
        }
        System.out.println(x ? "True" : "False");
    }
}
