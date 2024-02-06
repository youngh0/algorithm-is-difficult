

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        int[][] visited = new int[row][col];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    map[r][c] = 1;
                }
            }
        }

        int areaCount = 0;
        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 && map[i][j] == 0) {
                    areaList.add(bfs(map, visited, i, j));
                    areaCount++;
                }

            }
        }

        System.out.println(areaCount);
        Collections.sort(areaList);
        for (Integer integer : areaList) {
            System.out.print(integer + " ");
        }
    }

    static int bfs(int[][] map, int[][] visited, int startH, int startC) {
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{startH, startC});
        int area = 1;
        visited[startH][startC] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nH = poll[0] + dx[i];
                int nC = poll[1] + dy[i];

                if (nH < 0 || nH >= map.length || nC < 0 || nC >= map[0].length) {
                    continue;
                }

                if (visited[nH][nC] == 1) {
                    continue;
                }

                if (map[nH][nC] == 0) {
                    area++;
                    visited[nH][nC] = 1;
                    q.add(new int[]{nH, nC});
                }
            }
        }
        return area;
    }
}
