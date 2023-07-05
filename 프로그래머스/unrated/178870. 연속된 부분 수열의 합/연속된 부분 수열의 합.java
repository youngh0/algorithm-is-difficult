

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (right < sequence.length) {
            if (sum < k) {
                right++;
                if (right == sequence.length) {
                    return answer;
                }
                sum += sequence[right];
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                if (answer.length == 0) {
                    answer = new int[]{left, right};
                } else {
                    if (answer[1] - answer[0] > right - left) {
                        answer = new int[]{left, right};
                    }
                }
                right++;
                if (right == sequence.length) {
                    return answer;
                }
                sum += sequence[right];
            }
        }
        return answer;
    }
}
