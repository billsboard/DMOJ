import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class thereturnofaplusb {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(in.readLine());
            System.out.println(convert(tk.nextToken()) + convert(tk.nextToken()));

        }
    }

    static int convert(String s){
        switch (s.toLowerCase()){
            case "1": case "one": case "一": case "un":
                return 1;
            case "2": case "two": case "二": case "deux":
                return 2;
            case "3": case "three": case "三": case "trois":
                return 3;
            case "4": case "four": case "四": case "quatre":
                return 4;
            case "5": case "five": case "五": case "cinq":
                return 5;
            case "6": case "six": case "六":
                return 6;
            case "7": case "seven": case "七": case "sept":
                return 7;
            case "8": case "eight": case "八": case "huit":
                return 8;
            case "9": case "nine": case "九": case "neuf":
                return 9;
        }
        return 10;
    }
}