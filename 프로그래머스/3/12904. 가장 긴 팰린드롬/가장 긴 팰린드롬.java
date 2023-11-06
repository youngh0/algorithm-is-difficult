import java.util.*;

class Solution
{
    public int solution(String s)
    {
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2) -> o2.length() - o1.length());
        
        int answer = 1;
        
        for(int i = 0;i < s.length()-1;i++){
            if(s.length() - i < answer){
                return answer;
            }
            for(int j = s.length()-1; j > i; j--){
                int left = i;
                int right = j;
                boolean flag = true;
                while(left<=right){
                    char leftChar = s.charAt(left);
                    char rightChar = s.charAt(right);

                    if(leftChar != rightChar){
                        flag = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if(flag){
                    answer = Math.max(answer, j-i+1);
                }
            }
        }
        
        return answer;
    }
}