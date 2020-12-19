import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class set {
    static int N;
    static HashSet<Integer> dist = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            dist.add(Integer.parseInt(in.readLine()));
        }

        System.out.println(dist.size());
    }
}
