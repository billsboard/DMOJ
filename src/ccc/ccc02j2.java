package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc02j2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = in.readLine()).equals("quit!")){
            if(s.length() > 4 && !(s.endsWith("yor") || s.endsWith("aor") || s.endsWith("eor") || s.endsWith("uor") || s.endsWith("ior") ||
                    s.endsWith("oor")) && s.endsWith("or")){
                System.out.println(s.replace("or", "our"));
            }
            else{
                System.out.println(s);
            }
        }
    }
}
