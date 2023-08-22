

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        List<Integer> student1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> student2 = new ArrayList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        List<Integer> student3 = new ArrayList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        List<List<Integer>> students = new ArrayList<>(List.of(student1, student2, student3));
        int maxAnswerCount = 0;
        List<Integer> answerCounts = new ArrayList<>();

        for (List<Integer> student : students) {
            int studentAnswerCount = check(answers, student);
            maxAnswerCount = Math.max(studentAnswerCount, maxAnswerCount);
            answerCounts.add(studentAnswerCount);
        }

        for (Integer answerCount : answerCounts) {
            System.out.println(answerCount);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (maxAnswerCount == answerCounts.get(i)) {
                tmp.add(i + 1);
            }
        }
        return tmp.stream()
                .mapToInt(i -> i)
                .toArray();
//        return tmp.toArray(new int[]);
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
