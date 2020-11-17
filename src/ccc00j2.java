import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc00j2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine()), M = Integer.parseInt(in.readLine());

        int x = 0;
        for (int i = N; i <= M; i++) {
            String s = String.valueOf(i);
            int len = s.length();

            if((len & 1) == 1){
                if(!flippable(s.charAt(len / 2))) continue;
            }

            int mid = len / 2;
            boolean ok = true;
            for (int j = 0; j < mid; j++) {
                if(!((s.charAt(j) == s.charAt(len - 1 - j) && flippable(s.charAt(j))) || (s.charAt(j) == '6' && s.charAt(len - 1 - j) == '9') || (s.charAt(j) == '9' && s.charAt(len - 1 - j) == '6')))ok=false;
            }
            if(ok) x++;
        }

        System.out.println(x);
    }

    static boolean flippable(char c){
        return c == '8' || c == '0' || c == '1';
    }
}
