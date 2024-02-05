

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> buildings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(br.readLine());
            buildings.add(h);
        }

        List<Integer> stack = new ArrayList<>();

        long answer = 0;
        for (int i = 0; i < buildings.size(); i++) {
            while (!stack.isEmpty() && stack.get(stack.size() - 1) <= buildings.get(i)) {
                stack.remove(stack.size() - 1);
            }

            answer += stack.size();
            stack.add(buildings.get(i));
        }
        System.out.println(answer);
    }
}
