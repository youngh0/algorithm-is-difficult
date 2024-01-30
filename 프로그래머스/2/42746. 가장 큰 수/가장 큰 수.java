import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> numberList = new ArrayList<>();
        
        for(int number: numbers){
            numberList.add(String.valueOf(number));
        }
        
        Collections.sort(numberList, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        
        if(numberList.get(0).equals("0")){
            return "0";
        }
        
        for(String number: numberList){
            answer += number;
        }      
        return answer;
    }
}