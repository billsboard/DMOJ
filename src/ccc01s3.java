import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class ccc01s3 {
    static ArrayList<Integer>[] adj;
    static ArrayList<ArrayList<Pair>> paths = new ArrayList<>();
    static ArrayList<Pair> path = new ArrayList<>();
    static String[] roadStr = new String[2526];

    public static void main(String[] args) throws IOException {
        adj = new ArrayList[26];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        while (!(s = in.readLine()).equals("**")){
            char a = s.charAt(0), b = s.charAt(1);
            adj[a - 'A'].add(b - 'A');
            adj[b - 'A'].add(a - 'A');
            roadStr[(a - 'A') * 100 + (b - 'A')] = s;
            roadStr[(a - 'A') + (b - 'A') * 100] = s;
        }

        dfs(0);

        int cnt = 0;
        for (Pair p : paths.get(0)) {
            boolean ok = true;
            for (int i = 1; i < paths.size(); i++) {
                if(!paths.get(i).contains(p)) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                System.out.println(roadStr[p.a * 100 + p.b]);
                cnt++;
            }
        }
        System.out.printf("There are %d disconnecting roads.\n", cnt);
    }

    static void dfs(int loc){
        if(loc == 1){
            paths.add((ArrayList<Pair>) path.clone());
            return;
        }

        for (int i : adj[loc]) {
            Pair p = new Pair(loc, i);
            if(path.contains(p)) continue;
            path.add(p);
            dfs(i);
            path.remove(path.size() - 1);
        }
    }


    static class Pair{
        int a, b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            return p.a == a && p.b == b || p.a == b && p.b == a;
        }
    }
}