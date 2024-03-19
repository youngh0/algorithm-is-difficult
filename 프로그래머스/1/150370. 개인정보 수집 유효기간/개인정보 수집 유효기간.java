import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        String[] days = today.split("[.]");
        
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);
        int total = (year * 12 * 28) + (month * 28) + day;
        
        Map<String, Integer> termMap = new HashMap<>();
        for(String term: terms){
            String[]termArr = term.split(" ");
            termMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }
        
        for(int i = 0;i < privacies.length;i++){
            
            String privacy = privacies[i];
            String[] priArr = privacy.split(" ");
            int term = termMap.get(priArr[1]);
            String[]priDays = priArr[0].split("[.]");
            int priYear = Integer.parseInt(priDays[0]);
            int priMonth = Integer.parseInt(priDays[1]);
            int priDay = Integer.parseInt(priDays[2]);
            
            int priTotal = (priYear * 12 * 28) + (priMonth * 28) + priDay;
            priTotal += term * 28;
            
            if(priTotal <= total){
                answer.add(i + 1);    
            }
            
        }
        
        int[] answerArr = new int[answer.size()];
        for(int i = 0;i < answer.size();i++){
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }
}