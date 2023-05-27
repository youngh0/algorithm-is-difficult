

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static boolean[] visited;
    static int[] array;
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        array = IntStream.range(0, n + 1).toArray();

        tracking(1, m);
    }

    public static void tracking(int start, int maxSize) {
        if (nums.size() == maxSize) {
            for (Integer num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int i = start; i < array.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums.add(array[i]);
                tracking(i + 1, maxSize);
                nums.remove(nums.size() - 1);
                visited[i] = false;
            }
        }
    }
}
