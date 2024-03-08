import java.util.*;

class Solution
{
    static int[] dr = {1,1,0};
    static int[] dc = {1,0,1};
    static int mapWidth;
    static int mapHeight;
    public int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        if(row<2||col<2){
            return 1;
        }
        
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(board[i][j] !=0){                
                    board[i][j] = Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1]))+1;
                }                
                if(answer < board[i][j]) answer = board[i][j];
            }
        }

        return answer*answer;
    }
}