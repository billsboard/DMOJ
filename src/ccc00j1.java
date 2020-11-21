import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc00j1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        int D = Integer.parseInt(tk.nextToken()), N = Integer.parseInt(tk.nextToken());

        System.out.println("Sun Mon Tue Wed Thr Fri Sat");
        for (int i = 1; i < D; i++) {
            System.out.print("    ");
        }

        for (int i = 1 + D; i < N + D; i++) {
            String x = String.valueOf(i - D);
            while (x.length() < 3){
                x = " " + x;
            }

            if(i % 7 == 1) System.out.println(x);
            else{
                System.out.print(x + " ");
            }
        }
        String x = String.valueOf(N);
        while (x.length() < 3){
            x = " " + x;
        }
        System.out.println(x);
    }
}
