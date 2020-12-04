import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc02s3 {

    static int[][] map;
    static int R, C, M;

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[] mv;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(in.readLine()); C = Integer.parseInt(in.readLine());
        map = new int[R + 2][C + 2];
        StringTokenizer tk;

        for (int i = 1; i <= R; i++) {
            tk = new StringTokenizer(in.readLine(), ".X", true);
            for (int j = 1; j <= C; j++) {
                map[i][j] = tk.nextToken().equals("X") ? 0 : 1;
            }
        }

        M = Integer.parseInt(in.readLine());
        mv = new char[M];
        for (int i = 0; i < M; i++) {
            mv[i] = in.readLine().charAt(0);
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(map[i][j] != 0){
                    recurse(i, j, 0, 0);
                    recurse(i, j, 1, 0);
                    recurse(i, j, 2, 0);
                    recurse(i, j, 3, 0);
                }
            }
        }

        for (int i = 1; i <= R ; i++) {
            for (int j = 1; j <= C; j++) {
                switch (map[i][j]){
                    case 0:
                        System.out.print("X");
                        break;
                    case 1:
                        System.out.print(".");
                        break;
                    case 2:
                        System.out.print("*");
                        break;
                }
            }
            System.out.println();
        }

    }

    static void recurse(int x, int y, int dir, int m){
        if(m == M) map[x][y] = 2;
        else{
            if(mv[m] == 'F'){
                if(map[x + dirs[dir][0]][y + dirs[dir][1]] == 0) return;
                recurse(x + dirs[dir][0], y + dirs[dir][1], dir, m + 1);
            }
            else if(mv[m] == 'R'){
                recurse(x, y, dir + 1 > 3 ? 0 : dir + 1, m + 1);
            }
            else{
                recurse(x, y, dir - 1 < 0 ? 3 : dir - 1, m + 1);
            }
        }
    }
}
