import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] board = new int[row][col];
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int area = 0;
        int answer = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    answer += 1;
                    int a = bfs(board, visited, i, j);
                    area = Math.max(area, a);
                }

            }
        }

        System.out.println(answer);
        System.out.println(area);
    }

    public static int bfs(int[][] board, boolean[][] visited, int curX, int curY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        int tmp = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];

                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
                if(visited[nx][ny] || board[nx][ny] == 0) continue;

                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                tmp += 1;
            }
        }
        return tmp;
    }
}
