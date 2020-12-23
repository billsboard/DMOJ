import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coci06c5p3 {
    static String S, T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());
        S = tk.nextToken(); T = tk.nextToken();
        N = Integer.parseInt(in.readLine());

        loop:
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            int set = 0;
            int s1 = 0, s2 = 0;
            StringTokenizer sc;
            while (tk.hasMoreTokens()){
                set++;
                if(s1 == 2 || s2 == 2 || set > 3){
                    System.out.println("ne");
                    continue loop;
                }
                sc = new StringTokenizer(tk.nextToken(), ":", false);
                int p1 = Integer.parseInt(sc.nextToken()), p2 = Integer.parseInt(sc.nextToken());

                if(p1 >= 7 && p1 - p2 > 2){
                    System.out.println("ne");
                    continue loop;
                }
                else if(p2 >= 7 && p2 - p1 > 2){
                    System.out.println("ne");
                    continue loop;
                }
                else if(p1 > 6 && p2 > 6 && set < 3){
                    System.out.println("ne");
                    continue loop;
                }
                if(p1 >= 6 && p1 - p2 >= 2 && p1 > p2 && !T.equals("federer"))
                    s1++;
                else if(p1 == 7 && p2 == 6 && set < 3 && !T.equals("federer"))
                    s1++;
                else if(p2 >= 6 && p2 - p1 >= 2 && p2 > p1 && !S.equals("federer"))
                    s2++;
                else if(p2 == 7 && p1 == 6 && set < 3 && !S.equals("federer"))
                    s2++;
                else{
                    System.out.println("ne");
                    continue loop;
                }
            }

            if((s1 == 2 || s2 == 2))
                System.out.println("da");
            else
                System.out.println("ne");
        }

    }
}
