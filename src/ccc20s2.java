import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc20s2 {
    static int[][] map;
    static boolean[][] visit;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(in.readLine()); N = Integer.parseInt(in.readLine());
        map = new int[M + 1][N + 1]; visit = new boolean[M + 1][N + 1];
        StringTokenizer tk;
        for (int i = 1; i <= M; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        recurse(1, 1);
        System.out.println("no");
    }

    static void recurse(int x, int y){
        visit[x][y] = true;

        if(x == M && y == N){
            System.out.println("yes");
            System.exit(0);
        }
        else if(map[x][y] == 0) return;

        int sqrt = (int) Math.sqrt(map[x][y]) + 1;
        for (int i = 1; i <= sqrt; i++) {
            int rem = map[x][y] % i, quo = map[x][y] / i;
            if(rem == 0){
                if(i <= M && quo <= N && !visit[i][quo])
                    recurse(i, quo);
                if(quo <= M && i <= N && !visit[quo][i])
                    recurse(quo, i);
            }
        }
    }
}
