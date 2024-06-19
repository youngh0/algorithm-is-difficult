import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static boolean[][] visited = new boolean[5][5];
    static char[][] maps = new char[5][5];
    static boolean[] selected = new boolean[25];

    static int ans = 0;
    static int total = 0;
    static int sCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            maps[i] = br.readLine().toCharArray();
        }

        makeCombination(0,0);
        System.out.println(ans);
    }

    static public void makeCombination(int depth, int start) {
        if (depth == 7) {
            // 7개의 조합이 인접한지 확인
            boolean res = checkAdjacency();
            if(res){
                checkMoreThanFourS(selected);
            }
        }

        for (int i = start; i < 25; i++) {
            if(!selected[i]){
                selected[i] = true;

                makeCombination(depth+1, i+1);

                selected[i] = false;
            }
        }
    }

    static boolean checkAdjacency() {
        int adjCount = 0;

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < 25; i++) {
            if (selected[i]){
                q.offer(i);
                visited[i/5][i%5] = true;

                break;
            }
        }
        visited = new boolean[5][5];

        while (!q.isEmpty()) {
            int idx = q.poll();
            int row = idx / 5;
            int col = idx % 5;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if(0 <= nx && nx < 5 && 0 <= ny && ny < 5){
                    if (!visited[nx][ny] && selected[(5*nx)+ny]){
                        visited[nx][ny] = true;
                        adjCount++;
                        q.offer((5*nx)+ny);
                    }
                }
            }
        }

        if (adjCount == 7) {
//            System.out.println(Arrays.toString(selected));
            return true;
        }
        return false;
    }

    static void checkMoreThanFourS(boolean[] selected) {
        int count = 0;
        for (int i = 0; i < 25; i++) {
            if(selected[i]){
                int row = i/5;
                int col = i % 5;

                if (maps[row][col] == 'S') {
                    count++;
                }
                if (count == 4) {
                    ans++;
                    return;
                }
            }

        }
    }
}