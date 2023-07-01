

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<boolean[]> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trains.add(new boolean[20]);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int train = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                boolean[] findTrain = trains.get(train - 1);
                findTrain[x - 1] = true;
            }
            if (command == 2) {
                int train = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                boolean[] findTrain = trains.get(train - 1);
                findTrain[x - 1] = false;
            }
            if (command == 3) {
                int train = Integer.parseInt(st.nextToken());
                boolean[] findTrain = trains.get(train - 1);
                for (int seat = 18; seat > -1; seat--) {
                    findTrain[seat + 1] = findTrain[seat];
                }
                findTrain[0] = false;
            }
            if (command == 4) {
                int train = Integer.parseInt(st.nextToken());
                boolean[] findTrain = trains.get(train - 1);
                for (int seat = 0; seat < 19; seat++) {
                    findTrain[seat] = findTrain[seat + 1];
                }
                findTrain[19] = false;
            }
        }

        Set<List<Boolean>> answer = new HashSet<>();

        for (boolean[] train : trains) {
            List<Boolean> trainSeats = new ArrayList<>();
            for (boolean b : train) {
                trainSeats.add(b);
            }
            answer.add(trainSeats);
        }
        System.out.println(answer.size());
    }
}
