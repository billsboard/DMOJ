import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(in.readLine());
            for (long j = x / 2 * 2 + 2; j < 2097154; j += 2){
                if((j * j * j) % 1000 == 888){
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
