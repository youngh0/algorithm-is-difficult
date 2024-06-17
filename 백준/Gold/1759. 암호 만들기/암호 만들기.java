

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static List<String> tmp = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    static Set<String> mo = Set.of("a", "e", "i", "o", "u");
    static int l;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            list.add(st.nextToken());
        }
        Collections.sort(list);
        tracking(0, 0, 0);

    }

    public static void tracking(int moCount, int jaCount, int start) {
        if (tmp.size() == l) {
            if (moCount >= 1 && jaCount >= 2) {
                for (String s : tmp) {
                    System.out.print(s);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < c; i++) {
            tmp.add(list.get(i));
            if (mo.contains(list.get(i))) {
                tracking(moCount + 1, jaCount, i + 1);
            } else {
                tracking(moCount, jaCount + 1, i + 1);
            }
            tmp.remove(tmp.size() - 1);
        }
    }
}
