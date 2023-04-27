import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        visited = new boolean[row][col];

        Queue<int[]> q = new LinkedList<>();
        int no = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                board[i][j] = tomato;
                if (tomato == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }else if(tomato == -1) {
                    no++;
                }
            }
        }

        int maxNum = 0;
        int sum = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            sum++;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                int distance = cur[2] + 1;

                if(nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if(visited[nx][ny] || board[nx][ny] != 0) continue;

                q.offer(new int[]{nx, ny, distance});
                maxNum = Math.max(maxNum, distance);
                visited[nx][ny] = true;
            }
        }
        if(row * col - no == sum)System.out.println(maxNum);
        else System.out.println(-1);

    }
}
