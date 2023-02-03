import java.util.ArrayList;

public class Level {
    public ArrayList<Room> rooms = new ArrayList<>();
    int m;
    int n;
    ArrayList<Integer> randomNumbers = new ArrayList<>();
    int level;

    public Level(int level, int m, int n) {
        this.level = level;
        this.m = m;
        this.n = n;
        initilizeLevel(level);
    }

    public void initilizeLevel(int level) {

        for (int i = 0; i < m; i++) {
            rooms.add(new Room(level));
            for (int j = (n * i); j < (i * n) + (n - 1); j++) {
                rooms.add(new Room(level));
                rooms.get(j).addDors(rooms.get(j + 1));
                rooms.get(j + 1).addDors(rooms.get(j));
            }
        }
        bindCorridors();
    }

    public void bindCorridors() {
        for (int i = 0; i < m; i++) {
            int randNum = (i * n) + (int) (Math.random() * (((i + 1) * n) - (i * n)));
            randomNumbers.add(randNum);
        }

        for (int i = 0; i < randomNumbers.size() - 1; i++) {
            rooms.get(randomNumbers.get(i)).addDors(rooms.get(randomNumbers.get(i + 1)));
            rooms.get(randomNumbers.get(i + 1)).addDors(rooms.get(randomNumbers.get(i)));


        }
    }


    public void seeRooms() {
        for (Room room : rooms) {
            room.display();
        }
    }


}

