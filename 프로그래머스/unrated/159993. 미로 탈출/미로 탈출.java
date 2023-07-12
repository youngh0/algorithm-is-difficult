

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
    }

    static boolean[][] visited;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] miro;

    public static int solution(String[] maps) {
        int answer = 0;
        miro = new char[maps.length][maps[0].length()];
        int[] startLoc = new int[2];
        int[] leverLoc = new int[2];

        for (int i = 0; i < maps.length; i++) {
            String row = maps[i];
            for (int j = 0; j < maps[i].length(); j++) {
                if (row.charAt(j) == 'S') {
                    startLoc[0] = i;
                    startLoc[1] = j;
                }
                if (row.charAt(j) == 'L') {
                    leverLoc[0] = i;
                    leverLoc[1] = j;
                }
                miro[i][j] = row.charAt(j);
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        int[] leverRes = leverBfs(new int[]{startLoc[0], startLoc[1], 0}, visited);
        if (leverRes[2] == 0) {
            return -1;
        }
        visited = new boolean[maps.length][maps[0].length()];
        int[] exitRes = exitBfs(leverRes, visited);

        if (exitRes[2] == leverRes[2]) {
            return -1;
        }
        return exitRes[2];
    }

    public static int[] leverBfs(int[] start, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int x = loc[0];
            int y = loc[1];
            int weight = loc[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited[0].length) {
                    continue;
                }
                if (visited[nx][ny] || miro[nx][ny] == 'X') {
                    continue;
                }

                if (miro[nx][ny] == 'L') {
                    return new int[]{nx, ny, weight + 1};
                }
                q.add(new int[]{nx, ny, weight + 1});
                visited[nx][ny] = true;

            }
        }
        return start;
    }

    public static int[] exitBfs(int[] start, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int x = loc[0];
            int y = loc[1];
            int weight = loc[2];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= visited.length || ny < 0 || ny >= visited[0].length) {
                    continue;
                }
                if (visited[nx][ny] || miro[nx][ny] == 'X') {
                    continue;
                }

                if (miro[nx][ny] == 'E') {
                    return new int[]{nx, ny, weight + 1};
                }
                q.add(new int[]{nx, ny, weight + 1});
                visited[nx][ny] = true;

            }
        }
        return start;
    }
}
