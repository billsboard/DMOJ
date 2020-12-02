import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ready");
        String s;
        while (!(s = in.readLine()).equals("  ")){
            if((s.charAt(0) == 'p' && s.charAt(1) == 'q') ||
                    (s.charAt(0) == 'q' && s.charAt(1) == 'p') ||
                    (s.charAt(0) == 'b' && s.charAt(1) == 'd') ||
                    (s.charAt(0) == 'd' && s.charAt(1) == 'b')) System.out.println("Mirrored pair");
            else
                System.out.println("Ordinary pair");
        }
    }
}
