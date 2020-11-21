package uncategorized;

import java.util.Scanner;

public class nccc7j5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counter = 0;

        int a = scan.nextInt(), b = scan.nextInt();
        int c = scan.nextInt(), d = scan.nextInt();

        for (int i = a; i <= b; i++) {
            for (int j = c; j <= d; j++) {

                boolean found  = true;
                for (int k = 2; k <= Math.sqrt(j); k++) {
                    if(i % k == 0 && j % k == 0) found = false;
                }

                if(found) counter++;

            }
        }
        System.out.println(counter);
    }
}
