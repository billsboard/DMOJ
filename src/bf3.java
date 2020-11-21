import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class bf3 {

    static BigInteger TWO = new BigInteger("2");

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        if(N <= 2) {
            System.out.println(2);
            return;
        }

        if((N & 1) == 0) N++;

        BigInteger b = new BigInteger(String.valueOf(N));

        while (!b.isProbablePrime(1)){
            b = b.add(TWO);
        }
        System.out.println(b);

    }
}
