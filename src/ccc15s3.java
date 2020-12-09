import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class ccc15s3 {

    static TreeSet<Integer> cache = new TreeSet<>();
    static int N, P, cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        for (int i = 1; i <= N; i++) {
            cache.add(i);
        }

        P = Integer.parseInt(in.readLine());

        for (int i = 0; i < P; i++) {
            int x = Integer.parseInt(in.readLine());
            Integer y;
            if((y = cache.floor(x)) == null) break;
            cache.remove(y);
            cnt++;
        }
        System.out.println(cnt);
    }
}
