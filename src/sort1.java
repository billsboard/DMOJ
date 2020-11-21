import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sort1 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        StringTokenizer tk = new StringTokenizer(in.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        for (int j = 0; j < N; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();


        boolean swap = true;
        for (int t = 0; t < N; t++) {
            if(!swap) break;
            swap = false;
            for (int i = 0; i < N - 1; i++) {
                if(arr[i] > arr[i + 1]){
                    arr[i + 1] += arr[i];
                    arr[i] = arr[i + 1] - arr[i];
                    arr[i + 1] = arr[i + 1] - arr[i];
                    swap = true;

                    for (int j = 0; j < N; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
