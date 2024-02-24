

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int answer = 0;

        Map<Integer, Integer> nums = new HashMap<>();
        while (right < n) {
            int val = nums.getOrDefault(arr[right], 0);
            if (val < k) {
                nums.put(arr[right], val + 1);
                right++;
                count++;
                answer = Math.max(count, answer);
            } else {
                while (true) {
                    nums.put(arr[left], nums.get(arr[left]) - 1);
                    if (arr[left] == arr[right]) {
                        count--;
                        left++;
                        break;
                    } else {
                        count--;
                        left++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
