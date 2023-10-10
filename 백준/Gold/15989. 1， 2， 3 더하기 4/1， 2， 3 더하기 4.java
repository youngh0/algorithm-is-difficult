

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int[] dp = new int[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 7;

        while (testCases-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if (target <= 6) {
                System.out.println(dp[target]);
                continue;
            }
            for (int i = 7; i < target + 1; i++) {
                dp[i] = dp[i - 1] +
                        (dp[i - 2] - dp[i - 3]) +
                        (dp[i - 3] - dp[i - 4] - dp[i - 5] + dp[i - 6]);
            }
            System.out.println(dp[target]);
        }
    }
}
