import java.util.*;

class Solution {
    
    int[] board;
    int answer = 0;
    
    public int solution(int n) {
        board = new int[n];
        Arrays.fill(board, -1);
        dfs(0);
        return answer;
    }
    
    public void dfs(int depth){
        
        if(depth == board.length){
            answer++;
            return;
        }
        
        for(int i = 0; i < board.length;i++){
            if(board[i] != -1){
                // System.out.println(depth + " ???");
                continue;
            }
            if(invalid(depth, i)){
                // System.out.println(depth + " !!");
                continue;
            }
            board[i] = depth;
            dfs(depth+1);
            board[i] = -1;
        }
    }
    
    public boolean invalid(int row, int col){
        for(int i = 0; i < board.length;i++){
            if(board[i] == -1){
                continue;
            }
            if(Math.abs(row - board[i]) == Math.abs(col - i)){
                return true;
            }
        }
        return false;
    }
}