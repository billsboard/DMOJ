import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p109ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String out = N + " cents requires";

        int q = 0, d = 0, n = 0 ,p = 0;
        while (N >= 25){
            q++;
            N -= 25;
        }
        while (N >= 10){
            d++;
            N -= 10;
        }
        while (N >= 5){
            n++;
            N -= 5;
        }
        while (N > 0){
            p++;
            N--;
        }

        out += q > 0 ? q == 1 ? " 1 quarter," : " " + q + " quarters," : "";
        out += d > 0 ? d == 1 ? " 1 dime," : " " + d + " dimes," : "";
        out += n > 0 ? n == 1 ? " 1 nickel," : " " + n + " nickels," : "";
        out += p > 0 ? p == 1 ? " 1 cent," : " " + p + " cents," : "";
        System.out.println(out.substring(0, out.length() - 1) + ".");
    }
}