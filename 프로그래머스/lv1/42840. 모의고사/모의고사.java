

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int student1Hit = 0;
        int student2Hit = 0;
        int student3Hit = 0;
        
        int maxAnswerCount = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                student1Hit++;
            }
            if (answers[i] == student2[i % student2.length]) {
                student2Hit++;
            }
            if (answers[i] == student3[i % student3.length]) {
                student3Hit++;
            }
        }

        maxAnswerCount = Math.max(student1Hit, student2Hit);
        maxAnswerCount = Math.max(maxAnswerCount, student3Hit);

        List<Integer> tmp = new ArrayList<>();
        if (student1Hit == maxAnswerCount) {
            tmp.add(1);
        }
        if (student2Hit == maxAnswerCount) {
            tmp.add(2);
        }
        if (student3Hit == maxAnswerCount) {
            tmp.add(3);
        }
        return tmp.stream()
                .mapToInt(i -> i)
                .toArray();

    }

    public int check(int[] answers, List<Integer> studentAnswers) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            int studentAnswerIndex = i % studentAnswers.size();
            if (answers[i] == studentAnswers.get(studentAnswerIndex)) {
                count++;
            }
        }
        return count;
    }
}
