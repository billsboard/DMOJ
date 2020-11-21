import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p287ex4 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int x = in.readLine().indexOf(" ");
            System.out.println(x + 1);
        }
    }
}
