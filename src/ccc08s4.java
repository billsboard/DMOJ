import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ccc08s4 {

    static int max, N;
    static int[] arr = new int[4];
    static boolean[] cache = new boolean[17];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(in.readLine());
            }
            Arrays.fill(cache, false);
            max = -2_000_000_000;
            recurse(arr);
            System.out.println(max);
        }
    }

    static void recurse(int... nums){
        if(nums.length == 1){
            if(nums[0] == 24) max = 24;
            else if(nums[0] < 24) max = Math.max(max, nums[0]);
        }
        else {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int[] nxt = new int[nums.length - 1];
                    int idx = 0;
                    for (int k = 0; k < nums.length; k++) {
                        if(k != i && k != j){
                            nxt[idx] = nums[k];
                            idx++;
                        }
                    }
                    nxt[idx] = nums[i] + nums[j];
                    recurse(nxt);
                    nxt[idx] = nums[i] - nums[j];
                    recurse(nxt);
                    nxt[idx] = nums[j] - nums[i];
                    recurse(nxt);
                    nxt[idx] = nums[i] * nums[j];
                    recurse(nxt);
                    if(nums[j] != 0 && nums[i] % nums[j] == 0) {
                        nxt[idx] = nums[i] / nums[j];
                        recurse(nxt);
                    }
                    if(nums[i] != 0 && nums[j] % nums[i] == 0) {
                        nxt[idx] = nums[j] / nums[i];
                        recurse(nxt);
                    }
                }
            }
        }
    }
}
