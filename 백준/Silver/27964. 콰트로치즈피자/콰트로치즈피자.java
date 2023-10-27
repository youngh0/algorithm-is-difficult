

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> topings = new HashSet<>();
        while (st.hasMoreTokens()) {
            String toping = st.nextToken();
            if (toping.endsWith("Cheese")) {
                topings.add(toping);
            }
            if (topings.size() == 4) {
                System.out.println("yummy");
                return;
            }
        }
        System.out.println("sad");
    }
}
