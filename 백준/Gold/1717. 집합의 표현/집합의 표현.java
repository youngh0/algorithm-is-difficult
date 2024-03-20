

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aParent = find(arr, a);
            int bParent = find(arr, b);

            if (command == 0) {
                union(arr, aParent, bParent);

//                for (int j = 0; j < n + 1; j++) {
//                    int parent = find(arr, j);
//                    arr[j] = parent;
//                }
            } else {
                if (aParent == bParent) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int find(int[] arr, int target) {
        if (arr[target] == target) {
            return arr[target];
        }
        return arr[target] = find(arr, arr[target]);
    }

    public static void union(int[] arr, int a, int b) {
        if (a < b) {
            arr[b] = a;
            return;
        }
        arr[a] = b;
    }
}
