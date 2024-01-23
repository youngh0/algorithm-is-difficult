import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<File> fileList = new ArrayList<>();
        
        for(String file: files){
            boolean isDigit = false;

            StringBuilder headStr = new StringBuilder();
            StringBuilder numStr = new StringBuilder();
            
            
            for(int i = 0;i < file.length();i++){
                // // head -> isDigit false, isTail false 면서 숫자 아닌거
                // if(!isDigit && !Character.isDigit(file.charAt(i))){
                //     headStr.append(file.charAt(i));
                // }
                // // number -> isDigit false, isTail false 면서 숫자 or isDigit true 면서 숫자
                // if((!isDigit && Character.isDigit(file.charAt(i))) || (isDigit && Character.isDigit(file.charAt(i)))){
                //     numStr.append(file.charAt(i));
                //     isDigit = true;
                // }
                // if(isDigit && !Character.isDigit(file.charAt(i))){
                //     break;
                // }
                
                if(!isDigit && !Character.isDigit(file.charAt(i))){
                    headStr.append(file.charAt(i));
                }

                else if(!isDigit && Character.isDigit(file.charAt(i))){
                    isDigit = true;
                    numStr.append(file.charAt(i));
                }

                else if(isDigit && Character.isDigit(file.charAt(i))){
                    numStr.append(file.charAt(i));
                }

                else if(isDigit && !Character.isDigit(file.charAt(i))){
                    
                    break;
                }

            }
            fileList.add(new File(headStr.toString().toLowerCase(), numStr.toString(), file));
            
        }
//         for(File file: fileList){
//             System.out.println(file.fileName);
//             System.out.println(file.head);
//             System.out.println(file.number);
//             System.out.println();
            
//         }
        
        Collections.sort(fileList, (f1, f2) -> {
            if(f1.head.equals(f2.head)){
                return f1.number - f2.number;
            }else{
                return f1.head.compareTo(f2.head);
            }
        });
        for(int i = 0; i < fileList.size();i++){
            answer[i] = fileList.get(i).fileName;
        }
        
        return answer;
    }
    
    class File{
        String head;
        int number;
        String fileName;
        
        public File(String head, String number, String fileName){
            this.head = head;
            this.number = Integer.parseInt(number);
            this.fileName = fileName;
        }
    }
}