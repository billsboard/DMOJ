import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class odd {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int x = 0;
        for (int i = 0; i < N; i++) {
            x = x ^ Integer.parseInt(in.readLine());
        }

        System.out.println(x);
    }
}
