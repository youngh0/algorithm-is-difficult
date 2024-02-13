

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int maxAnswer = Integer.MIN_VALUE;
    static int minAnswer = Integer.MAX_VALUE;
    static int[] operands = new int[4];
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(1, nums[0]);
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }

    public static void backTracking(int numIdx, int total) {
        if (numIdx == n) {
            maxAnswer = Math.max(maxAnswer, total);
            minAnswer = Math.min(minAnswer, total);
        }

        for (int i = 0; i < 4; i++) {
            if (operands[i] == 0) {
                continue;
            }
            if (i == 0) {
                operands[i] -= 1;
                backTracking(numIdx + 1, total + nums[numIdx]);
                operands[i] += 1;
            } else if (i == 1) {
                operands[i] -= 1;
                backTracking(numIdx + 1, total - nums[numIdx]);
                operands[i] += 1;
            } else if (i == 2) {
                operands[i] -= 1;
                backTracking(numIdx + 1, total * nums[numIdx]);
                operands[i] += 1;
            } else {
                operands[i] -= 1;
                backTracking(numIdx + 1, total / nums[numIdx]);
                operands[i] += 1;
            }

        }
    }
}
