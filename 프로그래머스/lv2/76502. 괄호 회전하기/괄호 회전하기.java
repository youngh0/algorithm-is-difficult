import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int totalLength = s.length();
        char[] chars = s.toCharArray();
        
        
        for(int start =0;start<totalLength;start++){
            
            Deque<Character> buckets = new ArrayDeque<>();
            boolean flag = true;
            for(int length = 0; length < totalLength;length++){
                int validIndex = (start + length) % totalLength;
            
                char element = chars[validIndex];
                if(element == '(' || element == '{' || element == '['){
                    buckets.offerLast(element);
                
                    continue;
                }
                
                if(buckets.isEmpty()){
                    flag = false;
                    break;
                }
                if(element == ')' && buckets.peekLast() != '('){
                    flag = false;
                    break;
                }
                
                if(element == '}' && buckets.peekLast() != '{'){
                    flag = false;
                    break;
                }
                if(element == ']' && buckets.peekLast() != '['){
                    flag = false;
                    break;
                }
                buckets.pollLast();
            }
            
            if(flag && buckets.isEmpty()){
                answer ++;
            }
        }
        
        return answer;
    }
}