

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int category = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> foods = new HashMap<>();
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < k; i++) {
            foods.put(arr[i], foods.getOrDefault(arr[i], 0) + 1);
            unique.add(arr[i]);
        }
        int answer = 0;
        if (unique.contains(c)) {
            answer = Math.max(answer, unique.size());
        } else {
            answer = Math.max(answer, unique.size() + 1);
        }

        for (int i = 0; i < n; i++) {
            foods.put(arr[i], foods.get(arr[i]) - 1);
            if (foods.get(arr[i]) == 0) {
                unique.remove(arr[i]);
            }
            foods.put(arr[(i + k) % n], foods.getOrDefault(arr[(i + k) % n], 0) + 1);
            unique.add(arr[(i + k) % n]);
            if (unique.contains(c)) {
                answer = Math.max(answer, unique.size());
            } else {
                answer = Math.max(answer, unique.size() + 1);
            }
        }

        System.out.println(answer);
    }
}
