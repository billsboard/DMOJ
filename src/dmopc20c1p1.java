import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dmopc20c1p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            String line = in.readLine();
            if(line.contains("M") && line.contains("C")) System.out.println("NEGATIVE MARKS");
            else if(line.contains("M") || line.contains("C")) System.out.println("FAIL");
            else System.out.println("PASS");
        }
    }
}
