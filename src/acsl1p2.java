import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acsl1p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer line = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(line.nextToken());
        int v = Integer.parseInt(line.nextToken());
        int d = Integer.parseInt(line.nextToken());
        int t = Integer.parseInt(line.nextToken());

        int[] vel = new int[n];
        vel[0] = v;

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = -i * d;
        }


        if(n == 1){
            int x = 0;
            while (v > 0){
                x += v * 5;
                v -= 5;
            }
            System.out.println(x);
            return;
        }


        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                dist[j] += vel[j] * 5;
            }

            if(dist[0] - dist[1] <= 0) {
                System.out.println(-1);
                return;
            }
            else if(dist[0] - dist[1] <= 80){
                vel[0] += 5;
            }
            else if(dist[0] - dist[1] >= 100){
                vel[0] = Math.max(0, vel[0] - 5);
            }

            for (int j = 0; j < n - 1; j++) {

                int diff = dist[j] - dist[j + 1];

                if(diff <= 0){
                    System.out.println("-1");
                    return;
                }
                else if(diff <= 80){
                    vel[j + 1] =  Math.max(0, vel[j + 1] - 5);
                }
                else if(diff >= 100){
                    vel[j + 1] =  Math.max(0, vel[j + 1] + 5);
                }
            }
        }

        System.out.println(dist[0]);



    }
}
