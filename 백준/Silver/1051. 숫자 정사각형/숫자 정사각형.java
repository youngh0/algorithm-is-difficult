

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] squareMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                squareMap[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int answer = 1;

        int maxStart = Integer.min(row, col);
        for (int length = maxStart; length > 1; length--) {
            for (int i = 0; i < row - length + 1; i++) {
                for (int j = 0; j < col - length + 1; j++) {
                    int target = squareMap[i][j];
                    if (target == squareMap[i + length - 1][j]
                            && target == squareMap[i + length - 1][j + length - 1]
                            && target == squareMap[i][j + length - 1]) {
                        System.out.println(length * length);
                        return;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
