import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};
        if(n < 5){
            if(n == 1){
                return "1";
            }
            if(n == 2){
                return "2";
            }if(n == 3){
                return "4";
            }
        }
        
        Deque<String> q = new ArrayDeque<>();

        while(n > 0){
            
            int remainder = n % 3;
            
            if(remainder == 0){
                q.addFirst("4");    
                n--;
                }else if(remainder == 1){
                    q.addFirst("1");
                }else if(remainder == 2){
                    q.addFirst("2");
                }
        
            
            n /= 3;
        }
        StringBuilder sb = new StringBuilder();
        for(String s : q){
            sb.append(s);
        }
        return sb.toString();
    }
}