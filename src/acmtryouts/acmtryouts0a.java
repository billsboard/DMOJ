package acmtryouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmtryouts0a {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(in.readLine()), max = Integer.MIN_VALUE;
            for (int j = 0; j < M; j++) {
                max = Math.max(max, Integer.parseInt(in.readLine()));
            }

            System.out.println(max);
        }

    }
}
