import Characters.Monster;
import Characters.Townspeople;
import Items.Item;
import java.util.ArrayList;
public class Room {

    private boolean hasUpStairs = false;
    private int roomNumber;
    private ArrayList<Room> doors = new ArrayList<Room>();
    private boolean hasDownStairs = false;
    private int roomLevel;
    private boolean hasCorridorEntrance = false;
    private static int roomCounter = -1;
    private Room door;
    private Room stairs;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<Townspeople> townspeople = new ArrayList<Townspeople>();
    private int monsterNumber = 2 + (int) (Math.random() * 3);
    private ArrayList<Item> loots = new ArrayList<Item>();
    private boolean hasHealer;
    private int itemCount;
    private double lootWeight = 0;


    public Room(int roomLevel) {
        roomCounter++;
        setRoomNumber(roomCounter);
        this.roomLevel = roomLevel;
        generateMonsters();
        generateTownsPeople();
    }


    //methods
    public void addDors(Room room) {
        doors.add(room);
    }

    //generate random monsters
    public void generateMonsters() {

        for (int i = 0; i < getMonsterNumber(); i++) {
//            monsters.add(new Monster());
            monsters.add(new Monster("m" + Integer.toString((i + 1))));
        }
    }


    //get corresponding monster
    public Monster getCorrespondingMonster(int monsterIndex) {
        String monsterName = "m" + Integer.toString(monsterIndex);
//        System.out.println(monsterName);
        for (Monster monster: monsters){
            if (monster.getName().equals(monsterName)){
                return monster;
            }
        }
        return null;

    }

    //add monster items to the loot list when they die
    public void addMonsterItemToLoots(Item item) {
        loots.add(item);
    }

    //remove monster from monsters list
    public void removeMonster(Monster monster) {
        monsters.remove(monster);
        setMonsterNumber(getMonsterNumber() - 1);
    }


    //calculate and return all loots weight
    public double getLootWeight() {
        double dummyWeight = 0;
        for (Item item : loots) {
            dummyWeight += item.getWeight();
        }
        setLootWeight(dummyWeight);
        return dummyWeight;
    }


    //generate random monsters
    public void generateTownsPeople() {
        for (int i = 0; i < (getMonsterNumber() / 2); i++) {
            townspeople.add(new Townspeople());
            if (townspeople.get(i).isHealer()) {
                setHasHealer();
            }
        }

    }

    // get number of towns people
    public int getNumberOfTownsPeople() {
        return this.townspeople.size();
    }




    //remove all towns people from room
    public void removeAllPeopleFromRoom() {
        townspeople.clear();
    }


    public void displayLoots(){
        int i = 0;
        for (Item item: loots){
            item.displayItemInfo();
            System.out.println("Loot Number: " +i);
            System.out.println("---------------------------------");
            i++;
        }
    }


    //Display
    public void display() {

        System.out.println("ROOM NUMBER: " + this.roomNumber);
        System.out.println("ROOM LEVEL: " + this.roomLevel);

        System.out.println("The Hero Sees The Following");
        for (int i = 0; i < monsters.size(); i++) {
//            System.out.println("Monster [m" + (i + 1) + "]");
            System.out.println("Monster ["+monsters.get(i).getName()+"]");

        }
        for (int i = 0; i < townspeople.size(); i++) {
            System.out.println("Town People [t" + (i + 1) + "]");
        }

        for (int i = 0; i < doors.size(); i++) {
            System.out.println("Door (D" + (i + 1) + ")");
        }
        if (this.hasUpStairs) {
            System.out.println("there is a stairs [up]");
        }
        if (this.hasDownStairs) {
            System.out.println("there is a stairs [down]");
        }
        if (getMonsterNumber() == 0 && getNumberOfTownsPeople() == 0) {
            if (getNumberOfLoots() != 0) {
                System.out.println("This Room Has Full Of Loots :) ");
                System.out.println("Do you want to see the items? [y][move]");
            }
        }


        System.out.println();
    }


    //getter and setters
    public static int getRoomCounter() {
        return roomCounter;
    }

    public static void setRoomCounter(int roomCounter) {
        Room.roomCounter = roomCounter;
    }

    public Room getDoor() {
        return door;
    }

    public void setDoor(Room door) {
        this.door = door;
    }

    public Room getStairs() {
        return stairs;
    }

    public void setStairs(Room stairs) {
        this.stairs = stairs;
    }

    public boolean isHasUpStairs() {
        return hasUpStairs;
    }

    public void setHasUpStairs() {
        this.hasUpStairs = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ArrayList<Room> getDoors() {
        return doors;
    }

    public void setDoors(ArrayList<Room> doors) {
        this.doors = doors;
    }

    public boolean isHasDownStairs() {
        return hasDownStairs;
    }

    public void setHasDownStairs() {
        this.hasDownStairs = true;
    }

    public int getRoomLevel() {
        return roomLevel;
    }

    public void setRoomLevel(int roomLevel) {
        this.roomLevel = roomLevel;
    }

    public boolean isHasCorridorEntrance() {
        return hasCorridorEntrance;
    }

    public void setHasCorridorEntrance(boolean hasCorridorEntrance) {
        this.hasCorridorEntrance = hasCorridorEntrance;
    }

    public int getMonsterNumber() {
        return monsterNumber;
    }

    public void setMonsterNumber(int monsterNumber) {
        this.monsterNumber = monsterNumber;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public boolean isHasHealer() {
        return hasHealer;
    }

    public void setHasHealer() {
        this.hasHealer = true;
    }

    public int getNumberOfLoots() {
        return loots.size();
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public ArrayList<Item> getLoots() {
        return loots;
    }

    public void setLoots(ArrayList<Item> loots) {
        this.loots = loots;
    }


    public void setLootWeight(double lootWeight) {
        this.lootWeight = lootWeight;
    }
}
