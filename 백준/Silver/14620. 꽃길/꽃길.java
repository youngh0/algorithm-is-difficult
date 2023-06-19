

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int answer = Integer.MAX_VALUE;
    static int n;
    static StringTokenizer st;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);
        System.out.println(answer);

    }

    public static void backTracking(int depth, int sum) {
        if (depth == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!visited[i][j] && isSafe(i,j)) {
                    visited[i][j] = true;
                    int areaCost = sumArea(i, j);
                    backTracking(depth+1, sum + areaCost);
                    visited[i][j] = false;
                    for (int q = 0; q < 4; q++) {
                        int nx = i + dx[q];
                        int ny = j + dy[q];
                        visited[nx][ny] = false;

                    }
                }
            }
        }

    }

    private static boolean isSafe(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private static int sumArea(int x, int y) {
        int areaCost = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            areaCost += map[nx][ny];
            visited[nx][ny] = true;
        }
        areaCost += map[x][y];
        return areaCost;
    }
}
