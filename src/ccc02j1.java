import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ccc02j1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        switch (in.readLine()){
            case "1":
                System.out.println("\n      *\n      *\n      *\n\n      *\n      *\n      *\n");
                break;
            case "2":
                System.out.println(" * * *\n      *\n      *\n      *\n * * *\n*\n*\n*\n * * *");
                break;
            case "3":
                System.out.println(" * * *\n      *\n      *\n      *\n * * *\n      *\n      *\n      *\n * * *");
                break;
            case "4":
                System.out.println("\n*     *\n*     *\n*     *\n * * *\n      *\n      *\n      *\n");
                break;
            case "5":
                System.out.println(" * * *\n*\n*\n*\n * * *\n      *\n      *\n      *\n * * *");
                break;
            case "6":
                System.out.println(" * * *\n*\n*\n*\n * * *\n*     *\n*     *\n*     *\n * * *");
                break;
            case "7":
                System.out.println(" * * *\n      *\n      *\n      *\n\n      *\n      *\n      *\n");
                break;
            case "8":
                System.out.println(" * * *\n*     *\n*     *\n*     *\n * * *\n*     *\n*     *\n*     *\n * * *");
                break;
            case "9":
                System.out.println(" * * *\n*     *\n*     *\n*     *\n * * *\n      *\n      *\n      *\n * * *");
                break;
            case "0":{
                System.out.println(" * * *\n*     *\n*     *\n*     *\n\n*     *\n*     *\n*     *\n * * *");
            }
        }
    }
}
