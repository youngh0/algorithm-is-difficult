

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean[] visited = new boolean[9];
    public Set<Integer> nums = new HashSet<>();
    public int maxLength;
    public int answer = 0;

    public int solution(String numbers) {
        maxLength = numbers.length();

//        for (int i = 1; i < maxLength + 1; i++) {
//            backTracking(0, new StringBuilder(), i, numbers);
//        }
        
        recursive("", numbers);

        for (Integer num : nums) {
            if (isPrime(num)) {
                answer += 1;
            }
        }
        return answer;
    }

    public void recursive(String cur, String numsCandidate) {
        if (!cur.equals("")) {
            nums.add(Integer.parseInt(cur));
        }

        for (int i = 0; i < numsCandidate.length(); i++) {
            recursive(cur + numsCandidate.charAt(i), numsCandidate.substring(0, i) + numsCandidate.substring(i + 1));
        }
    }

    public void backTracking(int index, StringBuilder cur, int maxIndex, String totalNumbers) {
        if (cur.length() == maxIndex) {
            nums.add(Integer.parseInt(String.valueOf(cur)));
            return;
        }

        for (int i = 0; i < maxLength; i++) {
            if (!visited[i]) {
                cur.append(totalNumbers.charAt(i));
                visited[i] = true;
                backTracking(index, cur, maxIndex, totalNumbers);
                visited[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public boolean isPrime(Integer num) {
        System.out.println(num);
        if (num == 0 || num == 1) {
            return false;
        }

        int limit = (int) Math.sqrt(num);

        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
