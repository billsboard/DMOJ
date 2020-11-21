package acmtryouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class acmtryouts1a {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        loop:
        for (int i = 0; i < N; i++) {
            switch (in.readLine()){
                case "Scissors":
                    System.out.println("Rock");
                    break;
                case "Rock":
                    System.out.println("Paper");
                    break;
                case "Paper":
                    System.out.println("Scissors");
                    break;
                case "Fox":
                    System.out.println("Foxen");
                    break;
                case "Foxen":
                    break loop;
            }
        }
    }
}
