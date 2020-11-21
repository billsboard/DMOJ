import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ccc01s1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = in.readLine().split("[CDSH]");
        int[] score = new int[5];

        if(arr.length < 5){
            String[] n = new String[5];
            Arrays.fill(n, "");
            for (int i = 0; i < arr.length; i++) {
                n[i] = arr[i];
            }
            arr = n;
        }


        for (int i = 1; i <= 4; i++) {
            int pts = 0;

            String s = arr[i];
            if(s.length() == 0){
                pts += 3;
            }
            else if(s.length() == 1){
                pts += 2;
            }
            else if(s.length() == 2){
                pts += 1;
            }

            for (char c : s.toCharArray()) {
                switch (c){
                    case 'A':
                        pts += 4;
                        break;
                    case 'K':
                        pts += 3;
                        break;
                    case 'Q':
                        pts += 2;
                        break;
                    case 'J':
                        pts += 1;
                        break;
                }
            }

            score[i] = pts;
        }

        System.out.println("Cards Dealt Points");
        System.out.print("Clubs ");
        for (char c : arr[1].toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println(score[1]);

        System.out.print("Diamonds ");
        for (char c : arr[2].toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println(score[2]);

        System.out.print("Hearts ");
        for (char c : arr[3].toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println(score[3]);

        System.out.print("Spades ");
        for (char c : arr[4].toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println(score[4]);
        System.out.println("Total " + (score[1] + score[2] + score[3] + score[4]));



    }
}
