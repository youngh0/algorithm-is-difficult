

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) {
                    continue;
                }
                if (!visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture[i][j], picture, i, j, visited));
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int bfs(int number, int[][] picture, int startX, int startY, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int area = 0;
        while (!q.isEmpty()) {
            area++;
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) {
                    continue;
                }
                if (picture[nx][ny] != number) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return area;
    }
}
