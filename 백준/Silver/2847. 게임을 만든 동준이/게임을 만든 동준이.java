

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for (int i = n - 2; i > -1; i--) {
            if (score[i] >= score[i + 1]) {
                answer += score[i] - score[i + 1] + 1;
                score[i] = score[i + 1] - 1;
            }
        }
        System.out.println(answer);
    }
}
