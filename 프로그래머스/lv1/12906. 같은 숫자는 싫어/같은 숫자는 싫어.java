

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] arr) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (numbers.get(numbers.size() - 1) == arr[i]) {
                continue;
            }
            numbers.add(arr[i]);
        }

        return numbers.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
