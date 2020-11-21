import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class acmtryouts0b {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(in.readLine());
            Stack<String> stack = new Stack<>();
            String s = in.readLine(), s1 = in.readLine();
            for (int j = 0; j < L; j++) {
                stack.push(String.valueOf(s.charAt(j)));
                stack.push(String.valueOf(s1.charAt(j)));
            }

            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }
}
