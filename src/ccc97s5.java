import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc97s5 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {

            int quo = 0;

            String a = in.readLine(), b = in.readLine();
            int sh = a.length() - b.length();
            int rem = Integer.parseInt(a), y = Integer.parseInt(b);
            if(sh > 0) y *= (int) Math.pow(10, sh);
            while (y >= Integer.parseInt(b) && rem >= quo){
                if(rem - y >= 0){
                    quo += Math.pow(10, sh);
                    rem -= y;
                }
                else {
                    sh -= 1;
                    y /= 10;
                }
            }

            System.out.println(quo);
            System.out.println(rem);
            System.out.println();
        }

    }
}
