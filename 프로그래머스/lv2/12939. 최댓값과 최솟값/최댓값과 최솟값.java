

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String solution(String s) {
        String answer = "";

        List<Integer> numbers = new ArrayList<>();
        String[] splits = s.split(" ");

        for (String split : splits) {
            numbers.add(Integer.parseInt(split));
        }

        Collections.sort(numbers);
        answer += numbers.get(0);
        answer += " ";
        answer += numbers.get(numbers.size() - 1);

        return answer;
    }
}
