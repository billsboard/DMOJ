package ccc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ccc01s4 {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][2];
        StringTokenizer tk;
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(in.readLine());
            arr[i] = new int[]{Integer.parseInt(tk.nextToken()), Integer.parseInt(tk.nextToken())};
        }

        double max = Double.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    double a = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                    double b = Math.sqrt(Math.pow(arr[i][0] - arr[k][0], 2) + Math.pow(arr[i][1] - arr[k][1], 2));
                    double c = Math.sqrt(Math.pow(arr[k][0] - arr[j][0], 2) + Math.pow(arr[k][1] - arr[j][1], 2));

                    double s = (a + b + c) / 2;

                    double dist = (a*b*c)/(4.0 * Math.sqrt(s * (s - a) * (s - b) * (s - c))) * 2;
                    if(Double.isNaN(dist) || a * a > b * b + c * c || b * b > a * a + c * c || c * c > b * b + a * a){
                        dist = Math.max(a, Math.max(b, c));
                    }
                    max = Math.max(max, dist);

                }
            }
        }
        System.out.println(String.format("%.2f", max));
    }
}
