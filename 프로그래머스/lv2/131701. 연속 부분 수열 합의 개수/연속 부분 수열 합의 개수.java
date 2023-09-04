import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int totalLength = elements.length;
        int answer = 0;
        Set<Integer> sumInts = new HashSet<>();
        for(int i = 1; i < elements.length + 1;i++){
            for(int start = 0; start < elements.length;start++){
                int tmp = 0;
                for(int cur = 0; cur < i; cur++){
                    int validIndex = (start + cur) % totalLength;
                    tmp += elements[validIndex];
                }
                sumInts.add(tmp);
            }
        }
        return sumInts.size();
    }
}