

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numArray = new int[n];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
            set.add(numArray[i]);
        }

        List<Integer> numList = new ArrayList<>(set);
        Collections.sort(numList);

//        System.out.println(numList.size());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int cur = numArray[i];
            int left = 0;
            int right = numList.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (numList.get(mid) < cur) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
//                System.out.println(cur + " " + left + " " + right);
            }
            sb.append(left).append(" ");
        }
        System.out.println(sb);
    }
}
