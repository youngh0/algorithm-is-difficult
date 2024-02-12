

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> numberMap = new HashMap<>();
        Map<Integer, Integer> orderMap = new HashMap<>();

        int order = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!orderMap.containsKey(num)) {
                orderMap.put(num, order++);
            }
            Integer value = numberMap.getOrDefault(num, 0);
            numberMap.put(num, value + 1);
        }

        List<Integer> keys = new ArrayList<>(numberMap.keySet());
        Collections.sort(keys, (o1, o2) -> {
            if (numberMap.get(o1) == numberMap.get(o2)) {
                return orderMap.get(o1) - orderMap.get(o2);
            }
            return numberMap.get(o2) - numberMap.get(o1);
        });

        for (Integer key : keys) {
            int freq = numberMap.get(key);
            for (int i = 0; i < freq; i++) {
                System.out.print(key + " ");
            }
        }
    }
}
