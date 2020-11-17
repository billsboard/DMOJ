import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc00s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(in.readLine()), x = Integer.parseInt(in.readLine()),
                y = Integer.parseInt(in.readLine()), z = Integer.parseInt(in.readLine()), f = 0, p = 0;
        while (m != 0){
            m--;
            p++;
            if(f == 0){
                x++;
                if(x % 35 == 0) m += 30;
            }
            else if(f == 1){
                y++;
                if(y % 100 == 0) m += 60;
            }
            else{
                z++;
                if(z % 10 == 0) m += 9;
            }

            f = f + 1 > 2 ? 0 : f + 1;
        }
        System.out.println("Martha plays " + p + " times before going broke.");
    }
}
