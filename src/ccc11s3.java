import java.util.Scanner;

public class ccc11s3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();


        for (int i = 0; i < T; i++) {
            int m = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();

            System.out.println(calculate(x, y, m) ? "crystal" : "empty");
        }

    }

    static boolean calculate(int x, int y, int m){
        if(m == 1){
            if(y == 0 && (x == 1 || x == 2 || x == 3)) return true;
            if(x == 2 && y == 1) return true;
            return false;
        }

        int fifth = (int) Math.pow(5, m) / 5;
        if(x < fifth || x > fifth * 4) return false;
        if(x < fifth * 2){
            if(y < fifth) return true;
            else if(y < 2*fifth) return calculate(x - fifth, y - fifth, m - 1);
            return false;
        }
        if(x > fifth * 3 && x <= fifth * 4){
            if(y < fifth) return true;
            else if(y < 2*fifth) return calculate(x - (3*fifth), y - fifth, m - 1);
            return false;
        }
        if(x > fifth * 2 && x < fifth * 3){
            if(y < 2*fifth) return true;
            else if(y < 3*fifth) return calculate(x - (2*fifth), y - (2*fifth), m - 1);
            return false;
        }

        return false;
    }
}
