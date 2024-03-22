import java.util.*;

class Solution {
    
    int n;
    List<List<Integer>> diceList = new ArrayList<>();
    public int[] solution(int[][] dice) {
        
        n = dice.length;
        int[] answer = new int[n/2];
        int maxValue = 0;
        dfs(new ArrayList<>(), 0);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(List<Integer> diceA: diceList){
            List<Integer> diceB = new ArrayList<>();
            boolean[] visited = new boolean[n];
            for(int a: diceA){
                visited[a] = true;
            }
            for(int i = 0;i < n;i++){
                if(!visited[i]){
                    diceB.add(i);
                }
            }
            
            List<Integer> pqA = new ArrayList<>();
            List<Integer> pqB = new ArrayList<>();
            calculateSum(pqA, 0,0,diceA,dice);
            calculateSum(pqB, 0,0,diceB,dice);
            
            Collections.sort(pqB);
            int count = 0;
            
            for(int i: pqA){
                int left = 0;
                int right = pqB.size()-1;
                
                while(left <= right){
                    int mid = (left + right) / 2;
                    if(pqB.get(mid) >= i){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                
                count += left;
                
            }
            
            if(count > maxValue){
                maxValue = count;
                for(int j = 0;j < n/2;j++){
                    answer[j] = diceA.get(j) + 1;
                }
            }
        }
        
        return answer;
    }
    
    public void calculateSum(List<Integer> pq, int diceIdx, int sum, List<Integer> curDiceList, int[][] dice){
        if(curDiceList.size() == diceIdx){
            pq.add(sum);
            return;
        }
        
        for(int i = 0;i < 6;i++){
            calculateSum(pq, diceIdx+1, sum + dice[curDiceList.get(diceIdx)][i],curDiceList, dice);
        }
    }
    
    public void dfs(List<Integer> dices, int start){
        if(dices.size() == n / 2){
            diceList.add(new ArrayList<>(dices));
        }
        for(int i = start; i < n;i++){
            dices.add(i);
            dfs(dices, i+1);
            dices.remove(dices.size()-1);
        }
    }
}