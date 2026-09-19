import java.util.*;

public class meetingRoomsThree {
    public static class Room{
        long endTime;
        int roomNumber;
        public Room(long endTime, int roomNumber){
            this.endTime = endTime;
            this.roomNumber = roomNumber;
        }
    }

    public static int minMeetingRooms(int[][] meetings, int n) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            availableRooms.offer(i);
        }

        PriorityQueue<Room> busyRooms = new PriorityQueue<>((a,b) -> {
            if(a.endTime != b.endTime){
                return Long.compare(a.endTime, b.endTime);
            }
            return Integer.compare(a.roomNumber, b.roomNumber);
        });

        int[] count = new int[n];
        for(int[] meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            long duration = (long) end - start;

            while(!busyRooms.isEmpty() && busyRooms.peek().endTime <= start){
                Room room = busyRooms.poll();
                availableRooms.offer(room.roomNumber);
            }

            if(!availableRooms.isEmpty()){
                int roomNumber = availableRooms.poll();
                busyRooms.offer(new Room(end, roomNumber));
                count[roomNumber]++;
            }else{
                Room room = busyRooms.poll();
                long newEndTime = room.endTime + duration;
                busyRooms.offer(new Room(newEndTime, room.roomNumber));
                count[room.roomNumber]++;
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            if(count[i] > count[answer]){
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings = {{0,10}, {1,5}, {2,7}, {3,4}};
        System.out.println(minMeetingRooms(meetings, n));
    }
}