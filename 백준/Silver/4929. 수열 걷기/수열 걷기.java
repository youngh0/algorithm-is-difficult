

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }
            StringTokenizer first = new StringTokenizer(line);
            StringTokenizer second = new StringTokenizer(br.readLine());

            List<Integer> firstLine = new ArrayList<>();
            List<Integer> secondLine = new ArrayList<>();

            int firstCount = Integer.parseInt(first.nextToken());
            for (int i = 0; i < firstCount; i++) {
                firstLine.add(Integer.parseInt(first.nextToken()));
            }

            int secondCount = Integer.parseInt(second.nextToken());
            for (int i = 0; i < secondCount; i++) {
                secondLine.add(Integer.parseInt(second.nextToken()));
            }


            List<Integer> cross = new ArrayList<>();
            List<Integer> firstLineParts = new ArrayList<>();
            List<Integer> secondLineParts = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < firstLine.size(); i++) {
                if (secondLine.contains(firstLine.get(i))) {
                    firstLineParts.add(sum);
                    cross.add(firstLine.get(i));
                    sum = 0;
                } else {
                    sum += firstLine.get(i);
                }
            }
            firstLineParts.add(sum);

            sum = 0;
            for (int i = 0; i < secondLine.size(); i++) {
                if (firstLine.contains(secondLine.get(i))) {
                    secondLineParts.add(sum);
                    sum = 0;
                } else {
                    sum += secondLine.get(i);
                }
            }
            secondLineParts.add(sum);

            int crossSum = 0;
            for (Integer integer : cross) {
                crossSum += integer;
            }

            for (int i = 0; i < firstLineParts.size(); i++) {
                if (firstLineParts.get(i) > secondLineParts.get(i)) {
                    crossSum += firstLineParts.get(i);
                } else {
                    crossSum += secondLineParts.get(i);
                }
            }
            System.out.println(crossSum);
        }
    }
}
