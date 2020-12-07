import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a20 {
    static int N, a20 = ~(1 << 20);

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(in.readLine(), 16);
            long adr = l & a20;
            if(l == adr) System.out.printf("%08X\n", l);
            else System.out.printf("%08X %08X\n", adr, l);
        }
    }
}
