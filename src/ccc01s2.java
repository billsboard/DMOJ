import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc01s2 {

    static int A, B, x = 4, y = 4, w = 0, cw = 0, cnt = 1;
    static int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int dir = 0;
    static int[][] map = new int[10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(in.readLine());
        B = Integer.parseInt(in.readLine());



        for (int i = A; i <= B; i++) {
            map[x][y] = i;
            cw++;
            if(cw >= w){
                dir = dir + 1 > 3 ? 0 : dir + 1;
                cw = 0;
                cnt++;
                if(cnt == 2){
                    cnt = 0;
                    //cw = 1;
                    w++;
                }
            }
            x += dirs[dir][0];
            y += dirs[dir][1];
        }

        StringBuilder sb = new StringBuilder();

        int pad = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int tmp = 0;
            boolean wrt = false;
            for (int j = 0; j < 10; j++) {
                if(map[i][j] == 0) {
                    if(!wrt)
                        tmp++;
                    sb.append("    ");
                }
                else {
                    sb.append(String.format("%3d ", map[i][j]));
                    wrt = true;
                }
            }
            pad = Math.min(pad, tmp);
            sb.append("\n");
        }


        String s = sb.toString();
        s = s.replaceAll("(?m)^ +\\n", "");
        String rgx = "(?m)^ {" + ((pad * 4) + (3 - String.valueOf(B).length())) + "}";
        s = s.replaceAll(rgx, "");
        s = s.replaceAll("(?m) +\\n", "\n");
        System.out.println(s);

    }
}
