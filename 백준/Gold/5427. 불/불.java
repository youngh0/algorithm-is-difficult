import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] maps;

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static Queue<int[]> fireLocation;
    static Queue<Point> person;

    static int row;
    static int col;

    public static void main(String[] args) throws IOException {

        int testcases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcases; i++) {
//            System.out.println("-----------------");
            inputData();
        }
    }

    static void inputData() throws IOException {
        st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        maps = new char[row][col];


        fireLocation = new LinkedList<>();
        person = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            maps[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (maps[i][j] == '*') {

                    fireLocation.offer(new int[]{i,j});


                }
                if (maps[i][j] == '@') {
                    person.offer(new Point(i, j, 0));
                }
            }
        }


//        fireBfs();

        int res = sBfs();
        if(res > 0){
            System.out.println(res);
        }
        else{
            System.out.println("IMPOSSIBLE");
        }
    }

    static void fireBfs() {
        int fires = fireLocation.size();

        for (int j = 0; j < fires; j++) {
            int[] poll = fireLocation.poll();
            int x = poll[0];
            int y = poll[1];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                    if (maps[nx][ny] == '.' || maps[nx][ny] == '@') {
                        fireLocation.offer(new int[]{nx,ny});
                        maps[nx][ny] = '*';
                    }
                }
            }
        }
    }

    static int sBfs() {
        while (!person.isEmpty()) {
//            for (char[] map : maps) {
//                System.out.println(Arrays.toString(map));
//            }
//            System.out.println();
            fireBfs();

//            person.stream().forEach(x -> System.out.print(x.toString()));
            int pSize = person.size();
            for (int k = 0; k < pSize; k++) {
//                System.out.println("size: " + k + person.size());
                Point poll = person.poll();
                int x = poll.x;
                int y = poll.y;
//                System.out.println(x + " " + y);
                int dis = poll.dis;
                if (x == 0 || x == row - 1 || y == 0 || y == col - 1) {
                    return dis+1;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < row && 0 <= ny && ny < col) {
                        if (maps[nx][ny] == '.') {
//                            System.out.println("new: " + nx + " " + ny);
                            maps[nx][ny] = '@';
                            person.offer(new Point(nx,ny,dis+1));

                        }
                    }
                }
            }
        }
        return 0;

    }

    static class Point{
        int x;
        int y;
        int dis;

        public Point(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dis=" + dis +
                    '}';
        }
    }
}
