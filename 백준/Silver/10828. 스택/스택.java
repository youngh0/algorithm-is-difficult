import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                arr.add(num);
            } else if (command.equals("pop")) {
                if (arr.size() == 0) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(arr.get(arr.size() - 1));
                arr.remove(arr.size() - 1);
            } else if (command.equals("size")) {
                System.out.println(arr.size());
            } else if (command.equals("empty")) {
                if (arr.size() == 0) System.out.println(1);
                else System.out.println(0);
            } else {
                if (arr.size() == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(arr.get(arr.size() - 1));
                }
            }
        }
    }
}
