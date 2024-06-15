

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static int answer = 0;

    static int n;
    static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        backTracking(0, 0, 0);
        System.out.println(answer);
    }

    public static void backTracking(int sum, int index, int used) {
        if (index == n) {
            if (sum == s && used != 0) {
                answer++;
            }
            return;
        }

        backTracking(sum + nums[index], index + 1, used + 1);
        backTracking(sum, index + 1, used);
    }
}
