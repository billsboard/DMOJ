package uncategorized;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mnycp6 {

    static int[] fen = new int[100001];
    static int[] arr = new int[100001];
    static Set<String> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static int c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(in.readLine());
        for (int i = 0; i < Q; i++) {
            StringTokenizer tk = new StringTokenizer(in.readLine());
            switch (tk.nextToken()){
                case "A":{
                    String s = tk.nextToken();
                    if(map.containsKey(s)){
                        System.out.println("Can't add " + s);
                        break;
                    }
                    int v = calculateVal(s);
                    //System.out.println(v);
                    arr[c + 1] = v;
                    set.add(s);
                    map.put(s, c + 1);
                    update(c + 1, v);
                    c++;
                    break;
                }
                case "N":{
                    System.out.println(c);
                    break;
                }
                case "S":{
                    String x = tk.nextToken();
                    String y = tk.nextToken();
                    int xi = map.get(x), yi = map.get(y);
                    int xv = arr[xi], yv = arr[yi];

                    map.put(x, yi);
                    map.put(y, xi);

                    update(xi, yv - arr[xi]);
                    update(yi, xv - arr[yi]);
                    break;
                }
                case "M":{
                    String x = tk.nextToken();
                    String y = tk.nextToken();
                    int xi = map.get(x), yi = map.get(y);
                    System.out.println(query(Math.min(xi, yi), Math.max(xi, yi)));
                    break;
                }
                case "R":{
                    String x = tk.nextToken();
                    String y = tk.nextToken();
                    int nv = calculateVal(y);

                    map.put(y, map.get(x));
                    int xi = map.get(x);
                    update(xi, nv - arr[xi]);
                    arr[xi] = nv;
                     map.remove(x);
                    break;
                }
            }
        }
    }


    static int calculateVal(String s){
        char[] chars = s.toLowerCase().toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum += (int) c - 96;
        }
        return sum;
    }

    static void update(int x, int v){
        for (int i = x; i < fen.length; i += (i & -i)) {
            fen[i] += v;
        }
    }

    static int query(int ql, int qr){
        int pre = 0;
        for (int i = ql - 1; i > 0; i -= (i & -i)) {
            pre += fen[i];
        }
        int sum = 0;
        for (int i = qr; i > 0; i -= (i & -i)) {
            sum += fen[i];
        }

        return sum - pre;
    }

}
