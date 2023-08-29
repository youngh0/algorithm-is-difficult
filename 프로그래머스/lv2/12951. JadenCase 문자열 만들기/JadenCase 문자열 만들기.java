

public class Solution {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        if (Character.isAlphabetic(s.charAt(0))) {
            answer.append(Character.toUpperCase(s.charAt(0)));
        } else {
            answer.append(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ') {
                if (Character.isAlphabetic(s.charAt(i))) {
                    answer.append(Character.toUpperCase(s.charAt(i)));
                    continue;
                }
                answer.append(s.charAt(i));
                continue;
            } else {
                if (Character.isAlphabetic(s.charAt(i))) {
                    answer.append(Character.toLowerCase(s.charAt(i)));
                    continue;
                }
                answer.append(s.charAt(i));
                continue;
            }
        }

        return answer.toString();
    }
}
