

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr.get(i);
            for (int j = 0; j < i; j++) {
                if (arr.get(i) > arr.get(j)) {
                    dp[i] = Math.max(dp[j] + arr.get(i), dp[i]);
                }
            }
        }

        int answer = Arrays.stream(dp).max().getAsInt();
        System.out.println(answer);
    }
}
