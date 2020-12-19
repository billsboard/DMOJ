import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ccc13s3 {
    static boolean play[][] = new boolean[5][5];
    static int[] pts = new int[5];
    static int T, G, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine()); G = Integer.parseInt(in.readLine());

        StringTokenizer tk;
        for (int i = 0; i < G; i++) {
            tk = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tk.nextToken()), b = Integer.parseInt(tk.nextToken()),
                    x = Integer.parseInt(tk.nextToken()), y = Integer.parseInt(tk.nextToken());
            if(x == y){
                pts[a]++; pts[b]++;
            }
            else if(x > y){
                pts[a] += 3;
            }
            else
                pts[b] += 3;

            play[a][b] = true;
            play[b][a] = true;
        }

        recurse(play, pts, 6 - G);
        System.out.println(cnt);
    }

    static void recurse(boolean[][] p, int[] pts, int g){
        if(g == 0){
            boolean ok = true;
            for (int i = 1; i < 5; i++) {
                if(i != T && pts[T] <= pts[i]) ok = false;
            }
            if(ok) cnt++;
        }
        else {
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 5; j++) {
                    if(i == j) continue;
                    else if(p[i][j]) continue;

                    boolean[][] gms = copy(p);
                    int[] cln = pts.clone();
                    gms[i][j] = true;
                    gms[j][i] = true;
                    cln[i]++; cln[j]++;
                    recurse(gms, cln, g - 1);

                    gms = copy(p);
                    gms[i][j] = true;
                    gms[j][i] = true;
                    cln = pts.clone();
                    cln[i] += 3;
                    recurse(gms, cln,  g - 1);

                    gms = copy(p);
                    gms[i][j] = true;
                    gms[j][i] = true;
                    cln = pts.clone();
                    cln[j] += 3;
                    recurse(gms, cln, g - 1);
                    return;
                }
            }
        }
    }

    static boolean[][] copy(boolean[][] src){
        boolean[][] out = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            out[i] = src[i].clone();
        }
        return out;
    }
}
