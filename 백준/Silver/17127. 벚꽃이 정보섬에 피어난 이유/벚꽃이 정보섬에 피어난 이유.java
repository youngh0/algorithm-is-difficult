import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> trees = new ArrayList<>();

        while (st.hasMoreTokens()) {
            int tree = Integer.parseInt(st.nextToken());
            trees.add(tree);
        }

        int answer = 0;

        int tmp = 1;
        for (int i = 3; i < n; i++) {
            tmp *= trees.get(i);
        }
        tmp += trees.get(0);
        tmp += trees.get(1);
        tmp += trees.get(2);

        answer = Integer.max(answer, tmp);

        tmp = 1;
        for (int i = 2; i < n - 1; i++) {
            tmp *= trees.get(i);
        }
        tmp += trees.get(0);
        tmp += trees.get(1);
        tmp += trees.get(n - 1);

        answer = Integer.max(answer, tmp);

        tmp = 1;
        for (int i = 1; i < n - 2; i++) {
            tmp *= trees.get(i);
        }
        tmp += trees.get(0);
        tmp += trees.get(n - 2);
        tmp += trees.get(n - 1);

        answer = Integer.max(answer, tmp);

        System.out.println(answer);
    }
}
