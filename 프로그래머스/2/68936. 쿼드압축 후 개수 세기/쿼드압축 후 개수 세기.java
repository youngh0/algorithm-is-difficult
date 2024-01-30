class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);
        
        return answer;
    }
    
    public void quad(int[][] arr, int x, int y, int size){
        // if(size == 1){
        //     answer[arr[x][y]]++;
        //     return;
        // }
        if(isZip(arr, arr[x][y], x, y, size)){
            answer[arr[x][y]]++;
            return;
        }
        
        quad(arr, x, y, size/2);
        quad(arr, x + size/2, y, size/2);
        quad(arr, x, y + size/2, size/2);
        quad(arr, x + size/2, y + size/2, size/2);
    }
    
    public boolean isZip(int[][] arr, int cur, int x, int y, int size){
        for(int i = x;i < x + size;i++){
            for(int j = y; j < y + size;j++){
                if(arr[i][j] != cur){
                    return false;
                }
            }
        }
        return true;
    }
}