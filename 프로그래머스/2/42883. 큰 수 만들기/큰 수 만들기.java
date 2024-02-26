import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int maxLength = number.length() - k;
        int start = 0;
        for(int i = 0; i < maxLength;i++){
            char cur = '0';
            int idx = 0;
            for(int j = start; j <= i + k;j++){
                if(number.charAt(j) > cur){
                    cur = number.charAt(j);
                    start = j + 1;
                }
            }
            answer.append(cur);
        }
        return answer.toString();
    }
}