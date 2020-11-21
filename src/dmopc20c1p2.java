import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dmopc20c1p2 {

    static int[] arr, psa;
    static int l, r;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(tk.nextToken()), D = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1];
        psa = new int[N + 1];

        tk = new StringTokenizer(in.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        build();

        l = 1; r = N + 1;

        for (int i = 0; i < D; i++) {
            System.out.println(query(Integer.parseInt(in.readLine())));
        }


    }

    static void build(){
        psa[1] = arr[1];
        for (int i = 2; i < arr.length; i++) {
            psa[i] = psa[i - 1] + arr[i];
        }
    }

    static int query(int i){
        i += l - 1;

        int sl = psa[i] - psa[l - 1];
        int sr = psa[r - 1] - psa[i];

        if(sl >= sr){
            l = i + 1;
            return sl;
        }
        else{
            r = i + 1;
            return sr;
        }
    }
}
