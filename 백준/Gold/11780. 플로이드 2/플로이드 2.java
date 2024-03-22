

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

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] floyd = new int[n + 1][n + 1];
        int[][] pre = new int[n + 1][n + 1];
        for (int[] ints : floyd) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (floyd[start][end] > cost) {
                floyd[start][end] = cost;
                pre[start][end] = end;
            }

        }
        for (int i = 1; i < n + 1; i++) {
            floyd[i][i] = 0;
        }
//        for (int[] ints : floyd) {
//            for (int anInt : ints) {
//                System.out.print(anInt + " ");
//            }
//            System.out.println();
//        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (floyd[i][k] == Integer.MAX_VALUE || floyd[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        pre[i][j] = pre[i][k];
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (floyd[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(floyd[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (floyd[i][j] == Integer.MAX_VALUE || i == j) {
                    System.out.println(0);
                } else {
                    List<Integer> path = new ArrayList<>();

                    path.add(i);
                    int middle = pre[i][j];
                    while (middle != j) {
                        path.add(middle);
                        middle = pre[middle][j];
                    }
                    path.add(j);
                    System.out.print(path.size() + " ");
                    for (Integer integer : path) {
                        System.out.print(integer + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
