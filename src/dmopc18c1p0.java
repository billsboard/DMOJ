import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dmopc18c1p0 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int x;
        if(Integer.parseInt(in.readLine()) <= (x = Integer.parseInt(in.readLine())) &&
            x <= Integer.parseInt(in.readLine())) System.out.println("Good job!");
        else
            System.out.println("Try again!");
    }
}
