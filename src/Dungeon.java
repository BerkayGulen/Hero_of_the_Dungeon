import java.util.ArrayList;

public class Dungeon {
    ArrayList<Level> levels = new ArrayList<>();
    static ArrayList<Room> allRooms = new ArrayList<>();
    ArrayList<Integer> randomNumbers = new ArrayList<>();
    ArrayList<Integer> firstIndexOfLevel = new ArrayList<>();
    ArrayList<Integer> randomRoomIndexInLevels = new ArrayList<>();


    public Dungeon() {
        initilizeLevels();
        initilizeAllRooms();
        bindLevels();
    }

    public void initilizeLevels() {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            int m = 2 + (int) (Math.random() * 5);
            int n = 2 + (int) (Math.random() * 5);
            sum += (m * n);
            firstIndexOfLevel.add(sum);
            levels.add(new Level((i + 1), m, n));
        }
    }

    public void initilizeAllRooms() {
        for (Level level : levels) {
            allRooms.addAll(level.rooms);
        }
    }

    public void bindLevels() {
        int sum = 1;
        for (Level level : levels) {
            int index1 = sum + (int) (Math.random() * ((level.rooms.size())));
            sum += level.rooms.size()-1;
            randomRoomIndexInLevels.add(index1);
        }
        for (int i=0; i<randomRoomIndexInLevels.size()-1;i++){
            allRooms.get(randomRoomIndexInLevels.get(i)).setStairs(allRooms.get(firstIndexOfLevel.get(i)));
            allRooms.get(randomRoomIndexInLevels.get(i)).setHasDownStairs();

            allRooms.get(firstIndexOfLevel.get(i)).setStairs(allRooms.get(randomRoomIndexInLevels.get(i)));
            allRooms.get(firstIndexOfLevel.get(i)).setHasUpStairs();
        }


    }


    public void seeAllRooms() {
        for (Room room : allRooms) {
            room.display();
        }
    }

    public void seeLevels() {
        for (Level level : levels) {
            level.seeRooms();
        }
    }
}
