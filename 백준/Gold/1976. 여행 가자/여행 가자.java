

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] arr = new int[n + 10];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int city = Integer.parseInt(st.nextToken());
                if (city == 0) {
                    continue;
                }
                union(arr, i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = find(arr, Integer.parseInt(st.nextToken()));
        while (st.hasMoreTokens()) {
            if (first != find(arr, Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int[] arr, int target) {
        if (arr[target] == target) {
            return arr[target];
        }

        return arr[target] = find(arr, arr[target]);
    }

    public static void union(int[] arr, int a, int b) {
        int x = find(arr, a);
        int y = find(arr, b);

        if (x < y) {
            arr[y] = x;
            return;
        }
        arr[x] = y;
    }
}
