import java.util.*;

class Solution {
    int answer = 0;
    int[] eraseCount;
    
    public int solution(int m, int n, String[] board) { 
        List<int[]> eraseList = new ArrayList<>();
        eraseCount = new int[n];
        
        String[][] boardMap = new String[m][n];
        for(int i = 0;i < m;i++){
            boardMap[i] = board[i].split("");
        }
        
        for(int i = 0;i < m-1;i++){
            for(int j = 0;j < n-1;j++){
                String cur = boardMap[i][j];
                
                if(cur.equals(boardMap[i+1][j]) && cur.equals(boardMap[i+1][j+1]) && cur.equals(boardMap[i][j+1])){
                    eraseList.add(new int[]{i,j});
                }
            }
        }
        
        while(!eraseList.isEmpty()){
            for(int[] e: eraseList){
                int eraseH = e[0];
                int eraseW = e[1];
                erase(eraseH, eraseW, boardMap);
                erase(eraseH+1, eraseW, boardMap);
                erase(eraseH+1, eraseW+1, boardMap);
                erase(eraseH, eraseW+1, boardMap);
            }
            eraseList.clear();
            
            for(int i = 0;i < n;i++){
                List<String> tmpList = new ArrayList<>();
                for(int j = m-1;j > -1;j--){
                    if(!boardMap[j][i].equals("-")){
                        tmpList.add(boardMap[j][i]);
                    }
                }
                
                int eraseCount = m - tmpList.size();

                for(int q = 0; q < eraseCount;q++){
                    tmpList.add("-");
                }
                
                for(int idx = 0;idx < tmpList.size();idx++){
                    boardMap[idx][i] = tmpList.get(tmpList.size()-1-idx);
                }
            }
            
            for(int i = 0;i < m-1;i++){
                for(int j = 0;j < n-1;j++){
                    String cur = boardMap[i][j];

                    if(!cur.equals("-") && cur.equals(boardMap[i+1][j]) && cur.equals(boardMap[i+1][j+1]) && cur.equals(boardMap[i][j+1])){
                        eraseList.add(new int[]{i,j});
                    }
                }
            }
        }
            
        // for(int i = 0;i < m;i++){
        //     for(int j = 0;j < n;j++){
        //         System.out.print(boardMap[i][j]);
        //     }
        //     System.out.println();
        // }
        
//         for(int cnt: eraseCount){
//             System.out.println(cnt);
//         }
        
        return answer;
    }
    
    public void erase(int h, int w, String[][] boardMap){
        if(!boardMap[h][w].equals("-")){
            answer++;
            eraseCount[w]++;
        }
        boardMap[h][w] = "-";    
        
    }
}