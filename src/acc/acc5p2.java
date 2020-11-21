package acc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acc5p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine().toUpperCase();
        if(s.contains("DMOJ")){
            System.out.println(0);
        }
        else if(s.contains("DMO") || s.contains("DOJ") || s.contains("MOJ") || s.contains("DMJ")){
            System.out.println(1);
        }
        else if(s.contains("DM") || s.contains("MO") || s.contains("OJ") || s.contains("DO") || s.contains("DJ") || s.contains("MJ")){
            System.out.println(2);
        }
        else{
            System.out.println(3);
        }
    }
}
