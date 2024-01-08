// import java.util.*;

// class Solution {
//     int x = 5;
//     int y = 5;
//     Set<Integer> moves = new HashSet<>();
//     boolean visited[][][] = new boolean[11][11][4];
    
//     public int solution(String dirs) {
//         int answer = 0;
        
//         for(int i = 0;i < dirs.length();i++){
//             char c = dirs.charAt(i);
//             int dir = 0;
//             int revDir = 0;
//             if(c == 'L'){
//                 if(y == 0){
//                     continue;
//                 }
//                 y -= 1;
//                 revDir = 1;
//             }else if(c == 'R'){
//                 if(y == 10){
//                     continue;
//                 }
//                 y += 1;
//                 dir = 1;
//                 revDir = 0;
//             }else if(c == 'D'){
//                 if(x == 10){
//                     continue;
//                 }
//                 x += 1;
//                 dir = 2;
//                 revDir = 3;
//             }else if(c == 'U'){
//                 if(x == 0){
//                     continue;
//                 }
//                 x -= 1;
//                 dir = 3;
//                 revDir = 2;
//             }
//             System.out.println(i + " " + dir + " " + visited[x][y][dir]);
//             if(!visited[x][y][dir]){
//                 answer++;
//                 visited[x][y][dir] = true;
//                 visited[x][y][revDir] = true;
//             }
            
//         }
//         return answer;
//     }
// }

import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> s = new HashSet<String>();  //중복확인 위해 사용하는 set
        
        int len = dirs.length();
        
        int nowX = 0;
        int nowY = 0;
        
        for(int i=0; i<len; i++){
            int nextX = nowX;
            int nextY = nowY;
            String road = "";       //경로 저장할 문자열
            // U : "현재 좌표"+"이동 후 좌표"
            if(dirs.charAt(i) == 'U'){
                nextY++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }
            // D :  "이동 후 좌표" + "현재 좌표"
            else if(dirs.charAt(i) == 'D'){
                nextY--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }
            // R : "현재 좌표"+"이동 후 좌표"
            else if(dirs.charAt(i) == 'R'){
                nextX++;
                road += nowX;
                road += nowY;
                road += nextX;
                road += nextY;
            }
            // L :  "이동 후 좌표" + "현재 좌표"
            else if(dirs.charAt(i) == 'L'){
                nextX--;
                road += nextX;
                road += nextY;
                road += nowX;
                road += nowY;
            }
            
            //범위 벗어나면 무시
            if(nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
                continue;
            System.out.println(i + " " + road);
            s.add(road);
            nowX = nextX;
            nowY = nextY;
        }
        answer = s.size();
        return answer;
    }
}
