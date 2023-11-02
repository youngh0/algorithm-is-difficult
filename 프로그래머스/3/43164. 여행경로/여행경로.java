import java.util.*;

class Solution {
    
    public boolean[] visited;
    public int N;
    public List<String> resultList = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        N = tickets.length;
        
        dfs("ICN", "ICN", 0, tickets);
        Collections.sort(resultList);
    
        String finalResult = resultList.get(0);
        return finalResult.split(" ");
        // return answer;
        // return answer;
    }
    
    public void dfs(String src, String result, int count, String[][] tickets){
    
        if(N == count){
            resultList.add(result);
            return;
        }
    
        for(int i = 0;i < N;i++){
            
            if(tickets[i][0].equals(src) && !visited[i]){
                
                visited[i] = true;
                dfs(tickets[i][1], result + " " + tickets[i][1], count+1, tickets);
                visited[i] = false;
            }
        }
    }
}