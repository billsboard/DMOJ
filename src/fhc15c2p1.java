import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class fhc15c2p1 {
    static Deque<Integer> pile, deque;
    static int[] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        StringTokenizer tk;
        for (int i = 1; i <= N; i++) {
            M = Integer.parseInt(in.readLine());
            tk = new StringTokenizer(in.readLine());
            pile = new LinkedList<>(); deque = new LinkedList<>();
            arr = new int[M];
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(tk.nextToken());
                pile.addLast(arr[j]);
            }

            // Select first one:
            boolean ok = true;
            deque.addFirst(pile.pollFirst());
            while (!pile.isEmpty()){
                if(pile.peekFirst() == deque.peekFirst() - 1){
                    deque.addFirst(pile.pollFirst());
                }
                else if(pile.peekFirst() == deque.peekLast() + 1){
                    deque.addLast(pile.pollFirst());
                }
                else if(pile.peekLast() == deque.peekFirst() - 1){
                    deque.addFirst(pile.pollLast());
                }
                else if(pile.peekLast() == deque.peekLast() + 1){
                    deque.addLast(pile.pollLast());
                }
                else{
                    ok = false;
                    break;
                }
            }
            if(ok) {
                System.out.printf("Case #%d: yes\n", i);
                continue;
            }

            pile.clear(); deque.clear();
            ok = true;
            for (int j = 0; j < M; j++) {
                pile.addLast(arr[j]);
            }
            deque.addFirst(pile.pollLast());
            while (!pile.isEmpty()){
                if(pile.peekFirst() == deque.peekFirst() - 1){
                    deque.addFirst(pile.pollFirst());
                }
                else if(pile.peekFirst() == deque.peekLast() + 1){
                    deque.addLast(pile.pollFirst());
                }
                else if(pile.peekLast() == deque.peekFirst() - 1){
                    deque.addFirst(pile.pollLast());
                }
                else if(pile.peekLast() == deque.peekLast() + 1){
                    deque.addLast(pile.pollLast());
                }
                else{
                    ok = false;
                    break;
                }
            }
            System.out.printf("Case #%d: %s\n", i, ok ? "yes" : "no");
        }
    }
}
