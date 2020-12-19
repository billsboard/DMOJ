import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* Not pretty, but it gets the job done */
public class ccc19s3 {
    static int[][] sq = new int[3][3];
    static int blank = 1 << 30;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        for (int i = 0; i < 3; i++) {
            tk = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                String s = tk.nextToken();
                if(s.equals("X")) sq[i][j] = blank;
                else {
                    sq[i][j] = Integer.parseInt(s);
                }
            }
        }

        if(countSet() == 0){
            System.out.println("1 1 1\n" +
                    "1 1 1\n" +
                    "1 1 1");
            return;
        }

        loop:
        while (!isComplete()){
            boolean act = false;
            // Row
            for (int i = 0; i < 3; i++) {
                if(sq[i][0] != blank && sq[i][2] != blank && sq[i][1] == blank){
                    act = true;
                    sq[i][1] = sq[i][0] + ((sq[i][2] - sq[i][0]) / 2);
                }
                else if(sq[i][0] == blank && sq[i][1] != blank && sq[i][2] != blank){
                    act = true;
                    sq[i][0] = sq[i][1] - (sq[i][2] - sq[i][1]);
                }
                else if(sq[i][0] != blank && sq[i][1] != blank && sq[i][2] == blank){
                    act = true;
                    sq[i][2] = sq[i][1] + (sq[i][1] - sq[i][0]);
                }
            }

            // Col
            for (int i = 0; i < 3; i++) {
                if(sq[0][i] != blank && sq[2][i] != blank && sq[1][i] == blank){
                    act = true;
                    sq[1][i] = sq[0][i] + ((sq[2][i] - sq[0][i]) / 2);
                }
                else if(sq[0][i] == blank && sq[1][i] != blank && sq[2][i] != blank){
                    act = true;
                    sq[0][i] = sq[1][i] - (sq[2][i] - sq[1][i]);
                }
                else if(sq[0][i] != blank && sq[1][i] != blank && sq[2][i] == blank){
                    act = true;
                    sq[2][i] = sq[1][i] + (sq[1][i] - sq[0][i]);
                }
            }

            if(act) continue;

            // Filled 1 Row
            if(fillRow(0) && blankRow(1) && blankRow(2)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[0][j];
                    }
                }
                break;
            }
            if(fillRow(1) && blankRow(0) && blankRow(2)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[1][j];
                    }
                }
                break;
            }
            if(fillRow(2) && blankRow(1) && blankRow(0)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[2][j];
                    }
                }
                break;
            }

            // Filled 1 Col
            if(fillCol(0) && blankCol(1) && blankCol(2)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[i][0];
                    }
                }
                break;
            }
            if(fillCol(1) && blankCol(0) && blankCol(2)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[i][1];
                    }
                }
                break;
            }
            if(fillCol(2) && blankCol(1) && blankCol(0)){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        sq[i][j] = sq[i][2];
                    }
                }
                break;
            }

            // 1 Row, 1 Col
            if(fillRow(0) && fillCol(0)){
                int d = sq[0][1] - sq[0][0], e = sq[1][0] - sq[0][0];
                sq[1][1] = sq[0][0] + d + e;
                sq[1][2] = sq[0][0] + 2 * d + e;
                sq[2][1] = sq[0][0] + 2 * e + d;
                sq[2][2] = sq[0][0] + 2 * (e + d);
                break;
            }
            if(fillRow(1) && fillCol(0)){
                int d = sq[1][1] - sq[1][0], e = sq[1][0] - sq[0][0];
                sq[0][1] = sq[0][0] + d;
                sq[0][2] = sq[0][0] + 2 * d;
                sq[2][1] = sq[0][0] + 2 * e + d;
                sq[2][2] = sq[0][0] + 2 * (e + d);
                break;
            }
            if(fillRow(2) && fillCol(0)){
                int d = sq[2][1] - sq[2][0], e = sq[1][0] - sq[0][0];
                sq[1][1] = sq[0][0] + d + e;
                sq[1][2] = sq[0][0] + 2 * d + e;
                sq[0][1] = sq[0][0] + d;
                sq[0][2] = sq[0][0] + 2 * d;
                break;
            }

            if(fillRow(0) && fillCol(1)){
                int d = sq[0][1] - sq[0][0], e = sq[1][1] - sq[0][1];
                sq[1][0] = sq[0][0] + e;
                sq[1][2] = sq[0][0] + 2 * d + e;
                sq[2][0] = sq[0][0] + 2 * e;
                sq[2][2] = sq[0][0] + 2 * (e + d);
                break;
            }
            if(fillRow(1) && fillCol(1)){
                int d = sq[1][1] - sq[1][0], e = sq[1][1] - sq[0][1];
                sq[0][0] = sq[1][0] - e;
                sq[2][0] = sq[0][0] + 2 * e;
                sq[0][2] = sq[0][0] + 2 * d;
                sq[2][2] = sq[0][0] + 2 * (e + d);
                break;
            }
            if(fillRow(2) && fillCol(1)){
                int d = sq[2][1] - sq[2][0], e = sq[1][1] - sq[0][1];
                sq[0][0] = sq[2][0] - 2 * e;
                sq[1][0] = sq[0][0] + e;
                sq[1][2] = sq[0][0] + 2 * d + e;
                sq[0][2] = sq[0][0] + 2 * d;
                break;
            }

            if(fillRow(0) && fillCol(2)){
                int d = sq[0][1] - sq[0][0], e = sq[1][2] - sq[0][2];
                sq[1][1] = sq[0][0] + d + e;
                sq[1][0] = sq[0][0]  + e;
                sq[2][1] = sq[0][0] + 2 * e + d;
                sq[2][0] = sq[0][0] + 2 * e;
                break;
            }
            if(fillRow(1) && fillCol(2)){
                int d = sq[1][1] - sq[1][0], e = sq[1][2] - sq[0][2];
                sq[0][0] = sq[1][0] - e;
                sq[0][1] = sq[0][0]  + d;
                sq[2][1] = sq[0][0] + 2 * e + d;
                sq[2][0] = sq[0][0] + 2 * e;
                break;
            }
            if(fillRow(2) && fillCol(2)){
                int d = sq[2][1] - sq[2][0], e = sq[1][2] - sq[0][2];
                sq[0][0] = sq[2][0] - 2 * e;
                sq[0][1] = sq[0][0] + d;
                sq[1][1] = sq[0][0] + d + e;
                sq[1][0] = sq[0][0] + e;
                break;
            }

            // Diags
            if(countSet() == 3) {
                if (sq[0][0] != blank && sq[1][1] != blank && sq[2][2] != blank) {
                    sq[0][1] = sq[1][1];
                    continue;
                } else if (sq[0][2] != blank && sq[1][1] != blank && sq[2][0] != blank) {
                    sq[0][1] = sq[1][1];
                    continue;
                }
            }

            // 2 corners
            if(sq[0][0] != blank && sq[2][2] != blank && blankRow(1) && blankCol(1)){
                sq[0][2] = sq[0][0];
                continue;
            }
            if(sq[0][2] != blank && sq[2][0] != blank && blankRow(1) && blankCol(1)){
                sq[0][0] = sq[0][2];
                continue;
            }

            // Single
            if(countSet() == 1){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(sq[i][j] != blank) {
                            fill(sq[i][j]);
                            break loop;
                        }
                    }
                }
            }

            // Other 2 number arrangement
            if(countSet() == 2){
                if(!blankRow(1)) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (sq[i][j] != blank) {
                                setRow(i, sq[i][j]);
                                continue loop;
                            }
                        }
                    }
                }
                else {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (sq[i][j] != blank) {
                                sq[1][1] = sq[i][j];
                                continue loop;
                            }
                        }
                    }
                }
            }

            // 3 number: Separated
            if(countSet() == 3){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (sq[i][j] != blank) {
                            sq[1][1] = sq[i][j];
                            continue loop;
                        }
                    }
                }
            }
        }


        for (int[] a : sq) {
            System.out.printf("%d %d %d\n", a[0], a[1], a[2]);
        }

    }

    static boolean fillRow(int i){
        return sq[i][0] != blank && sq[i][1] != blank && sq[i][2] != blank;
    }

    static boolean fillCol(int i){
        return sq[0][i] != blank && sq[1][i] != blank && sq[2][i] != blank;
    }

    static boolean blankRow(int i){
        return sq[i][0] == blank && sq[i][1] == blank && sq[i][2] == blank;
    }

    static boolean blankCol(int i){
        return sq[0][i] == blank && sq[1][i] == blank && sq[2][i] == blank;
    }

    static boolean isComplete(){
        for (int[] a : sq) {
            for (int i : a) {
                if(i == blank) return false;
            }
        }
        return true;
    }

    static int countSet(){
        int cnt = 0;
        for (int[] a : sq) {
            for (int i : a) {
                if(i != blank) cnt++;
            }
        }
        return cnt;
    }

    static void fill(int x){
        for (int[] a : sq) {
            Arrays.fill(a, x);
        }
    }

    static void setRow(int i, int x){
        Arrays.fill(sq[i], x);
    }

}