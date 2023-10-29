import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Long, Long> rooms = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];
            long possibleRoom = find(room);
            answer[i] = possibleRoom;
        }
        return answer;
    }

    public long find(long room) {
        if (!rooms.containsKey(room)) {
            rooms.put(room, room + 1);
            return room;
        }

        long nextRoom = find(rooms.get(room));
        rooms.put(room, nextRoom + 1);
        return nextRoom;
    }
}
