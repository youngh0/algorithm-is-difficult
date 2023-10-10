import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int memoNum = Integer.parseInt(st.nextToken());
        int blogNum = Integer.parseInt(st.nextToken());

        Set<String> keywords = new HashSet<>();
        for (int i = 0; i < memoNum; i++) {
            keywords.add(br.readLine());
        }

        for (int i = 0; i < blogNum; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String keyword = st.nextToken();
                if (keywords.contains(keyword)) {
                    keywords.remove(keyword);
                }
            }
            System.out.println(keywords.size());
        }
    }
}
