import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class binary {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            String s = Integer.toBinaryString(Integer.parseInt(in.readLine()));
            int rem = s.length() % 4;
            for (int j = 0; j < ((4 - rem) & 3); j++) {
                s = "0" + s;
            }

            for (int j = 0; j < s.length(); j+=4) {
                System.out.print(s.substring(j, j + 4) + " ");
            }
            System.out.println();
        }

    }
}
