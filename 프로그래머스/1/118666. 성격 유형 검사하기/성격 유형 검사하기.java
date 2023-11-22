import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        Map<Character, Integer> scoreMap = new HashMap<>();
        
        scoreMap.put('R', 0);
        scoreMap.put('T', 0);
        scoreMap.put('C', 0);
        scoreMap.put('F', 0);
        scoreMap.put('J', 0);
        scoreMap.put('M', 0);
        scoreMap.put('A', 0);
        scoreMap.put('N', 0);
        
        for(int i = 0;i < survey.length;i++){
            if(choices[i] == 4){
                continue;
            }
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            if(choices[i] < 4){
                scoreMap.put(first,scoreMap.get(first) + (4 - choices[i]));
            }else{
                scoreMap.put(second,scoreMap.get(second) + (choices[i] - 4));
            }
        }
        
        answer.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        answer.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        answer.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        answer.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');
        return answer.toString();
    }

}