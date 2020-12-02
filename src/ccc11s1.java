import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc11s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String line;

        int s = 0, t = 0;

        for (int i = 0; i < N; i++) {
            line = in.readLine().toLowerCase();
            for (int j = 0; j < line.length(); j++) {
                if(line.charAt(j) == 's') s++;
                else if(line.charAt(j) == 't') t++;
            }
        }

        System.out.println(s >= t ? "French" : "English");
    }
}
