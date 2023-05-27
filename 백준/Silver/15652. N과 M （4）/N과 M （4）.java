

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static boolean[][] visited;
    static int[] array;
    static List<Integer> nums = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1][n + 1];
        array = IntStream.range(0, n + 1).toArray();

        tracking(1, 1, m);
        System.out.println(sb);
    }

    public static void tracking(int digit, int start, int maxSize) {
        if (nums.size() == maxSize) {
            for (Integer num : nums) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = start; i < array.length; i++) {
            if (!visited[digit][i]) {
                visited[digit][i] = true;
                nums.add(array[i]);
                tracking(digit + 1, i, maxSize);
                visited[digit][i] = false;
                nums.remove(nums.size() - 1);
            }
        }
    }
}
