import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dmopc16c4p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(in.readLine());

            if(x == 1){
                System.out.println("T");
                continue;
            }

            while (x > 2){
                if(x % 2 != 0){
                    x = -1;
                    break;
                }
                x = x / 2;
            }

            if(x == 2) System.out.println("T");
            else System.out.println("F");
        }

    }
}
