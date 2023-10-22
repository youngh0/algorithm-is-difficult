

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Room> rooms = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            Player player = new Player(level, nickname);
            boolean flag = false;
            for (Room room : rooms) {
                if (room.isEnter(level, m)) {
                    room.players.add(player);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                rooms.add(new Room(level, player));
            }
        }

        for (Room room : rooms) {
            if (room.players.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            room.players.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));
            for (Player player : room.players) {
                System.out.println(player.level + " " + player.nickname);
            }
        }
    }

    static class Room {
        int standard;
        List<Player> players;

        public Room(int standard, Player player) {
            this.standard = standard;
            this.players = new ArrayList<>();
            players.add(player);
        }

        public boolean isEnter(int level, int maxPlayerNum) {
            return level >= standard - 10 && level <= standard + 10 && players.size() < maxPlayerNum;
        }
    }

    static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
}
