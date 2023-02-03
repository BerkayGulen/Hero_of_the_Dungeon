import Characters.Hero;
import Characters.Monster;
import Items.Item;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Events {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Room> rooms = Dungeon.allRooms;

    public void changeHeroCurrentItem(Hero hero, ArrayList<Item> items) {
    }

    public static void battle(Hero hero, String action) {
        Room currentRoom = getCurrentRoom(hero);
        int monsterIndex = (Integer.parseInt(String.valueOf(action.charAt((action.length()) - 1))));//get monster index


        try {
            Monster monster = currentRoom.getCorrespondingMonster(monsterIndex);
            hero.attack(monster);
            monster.attack(hero);
            System.out.printf("Hero causes %.1f HP damage to m%d, the monster fights back and does %.1f HP damage.%n", hero.calculatePureDamage(monster), monsterIndex, monster.calculatePureDamage(hero));
            Thread.sleep(1200);
            if ((int)hero.getHp() <= 0) {
                //calculate point and write it to database
                Gamer gamer = new Gamer(hero.getName(), (int) hero.getScore(), hero.getNumberOfRescuedPeople());
                writeToFile(gamer);
                System.out.println();
                System.out.println("\t\t\t\t YOU DIED!!! ");
                System.out.printf("[SCORE: %d]\t\t[NUMBER OF MONSTER KILLED: %d]\t\t[NUMBER OF TOWNS PEOPLE SAVED: %d]\n", (int) hero.getScore(), hero.getNumberOfMonstersKilled(), hero.getNumberOfRescuedPeople());
                System.exit(1);
            } else if (monster.getHp() <= 0) {
                System.out.println("You Killed One Of The Monsters!!!");
                Thread.sleep(1000);
                currentRoom.removeMonster(monster);
                currentRoom.addMonsterItemToLoots(monster.getWeapon());
                currentRoom.addMonsterItemToLoots(monster.getArmor());
                hero.increaseNumberOfMonsterKilled();

            }
        } catch (Exception exception) {
            try {
                System.out.println("there is no such a monster");
                Thread.sleep(500);
            }catch (Exception e){

            }

        }

    }

    public static void gotHeal(Hero hero) {

        System.out.println("[Towns people] Thank you for saving us. I can heal you if you want!!!");
        while (true) {
            System.out.println("do you want to get heal? [y][n]");
            System.out.print("Choice: ");
            String choice = input.next().toLowerCase(Locale.ROOT);
            if (choice.equals("y")) {
                hero.setHp(hero.getHp() + 15);
                if (hero.getHp() > 40) {
                    hero.setHp(40);
                }
                System.out.println("[GOT HEALED]");
                break;
            } else if (choice.equals("n")) {
                System.out.println("[Towns People] Good luck on your quest");
                break;
            } else {
                System.out.println("[INVALID INPUT -_-]");

            }
        }


    }

    public static String getInput() {
        System.out.print("Action: ");
        return input.next();
    }


    public static Hero createCharacter(Hero hero) {
        Display.displayHeroCreationMenu();
        String name = input.next();
        return new Hero(name);
    }

    public static void changeHeroesRoom(Hero hero, String x) {
        try {
            x = x.toLowerCase(Locale.ROOT);
            if (x.equals("move d1")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getDoors().get(0).getRoomNumber());
            } else if (x.equals("move d2")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getDoors().get(1).getRoomNumber());
            } else if (x.equals("move d3")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getDoors().get(2).getRoomNumber());
            } else if (x.equals("move d4")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getDoors().get(3).getRoomNumber());
            } else if (x.equals("move d5")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getDoors().get(4).getRoomNumber());
            } else if (x.equals("move up")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getStairs().getRoomNumber());
            } else if (x.equals("move down")) {
                hero.setCurrentRoom(rooms.get(hero.getCurrentRoom()).getStairs().getRoomNumber());
            } else {
                System.out.println("[WRONG INPUT]");
                Thread.sleep(500);
            }
        } catch (Exception exception) {
            try {
                System.out.println("[PICK VALID DOOR]");
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void loot(Hero hero) {
        Room currentRoom = getCurrentRoom(hero);
        ArrayList<Item> currentLoot = currentRoom.getLoots();
        System.out.println("********** LOOTS **********");
        currentRoom.displayLoots();
        while (true) {
            try {
                System.out.println("[PRESS a TO LOOT ALL]    [ENTER 2 FOR LOOT SPECIFIC ITEM]   [PRESS 3 FOR EXIT]  ");
                String choice = getInput().toLowerCase(Locale.ROOT);
                if (choice.equals("a")) {

                    if (hero.getRemainingInventoryWeight() >= currentRoom.getLootWeight()) {
                        for (Item item : currentLoot) {
                            hero.addItemToInventory(item);
                        }
                        currentLoot.clear();
                        System.out.println("ALL ITEMS LOOTED!!!");
                        Thread.sleep(1000);
                        break;
                    } else {
                        System.out.println("Remaining inventory weight: " + hero.getRemainingInventoryWeight());
                        System.out.println("current loot weight: " + currentRoom.getLootWeight());
                        System.out.println("Hero's inventory weight is not enough for loot all items :(");
                    }
                } else if (choice.equals("2")) {
                    lootSpecificItem(hero, currentLoot, currentRoom);
                } else if (choice.equals("3")) {
                    break;
                } else {
                    System.out.println("INVALID INPUT -_-");
                    Thread.sleep(500);

                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    //Inventory interaction
    public static void inventory(Hero hero) {
        Room currentRoom = getCurrentRoom(hero);
        hero.displayInventory();
        System.out.println("[PRESS 1 TO CHANGE CURRENT ARMOR]\t\t[PRESS 2 TO CHANGE CURRENT WEAPON]\t\t[PRESS 3 FOR DROP ITEM]\t\t[PRESS -1 TO EXIT INVENTORY]");
        String action = getInput();
        try {
            if (action.equals("1")) {
                System.out.print("Enter Armor Number: ");
                String choice = input.next();
                hero.changeCurrentArmor(Integer.parseInt(choice));

            } else if (action.equals("2")) {
                System.out.print("Enter Weapon Number: ");
                String choice = input.next();
                hero.changeCurrentWeapon(Integer.parseInt(choice));

            } else if (action.equals("3")) {

                System.out.print("Enter Item Number: ");
                String choice = input.next();
                currentRoom.getLoots().add(hero.getInventory().get(Integer.parseInt(choice)));
                hero.getInventory().remove(Integer.parseInt(choice));
                System.out.println("[LOOT IS DROP]");
                Thread.sleep(500);

            }else if(action.equals("-1")){

            } else {
                System.out.println("[INVALID INPUT -_-]");
                Thread.sleep(500);

            }
        } catch (Exception exception) {
            System.out.println("[ENTER A INTEGER VALUE -_-]");

        }


    }

    public static void displayCurrentRoomInfo(Hero hero) {

        hero.display();
        Room currentRoom = getCurrentRoom(hero);

        if (currentRoom.getMonsterNumber() == 0 && currentRoom.getNumberOfTownsPeople() > 0) {
            if (currentRoom.isHasHealer()) {
                gotHeal(hero);
                hero.increaseRescuedPeople(currentRoom.getNumberOfTownsPeople());
                currentRoom.removeAllPeopleFromRoom();
            } else {
                hero.increaseRescuedPeople(currentRoom.getNumberOfTownsPeople());
                currentRoom.removeAllPeopleFromRoom();
            }
        }

        rooms.get(hero.getCurrentRoom()).display();

    }

    public static Room getCurrentRoom(Hero hero) {

        return rooms.get(hero.getCurrentRoom());
    }


    public static void lootSpecificItem(Hero hero, ArrayList<Item> loots, Room currentRoom) {
        while (currentRoom.getNumberOfLoots() > 0) {
            currentRoom.displayLoots();
            System.out.println("[Which item do you want to loot]");
            System.out.println("[Press -1 to exit]");
            System.out.print("Enter Loot Number: ");
            String choice = input.next();
            if (choice.equals("-1")) {
                break;
            }
            try {
                if ((hero.getCurrentInventoryWeight() + loots.get(Integer.parseInt(choice)).getWeight()) < hero.getMaxInventoryWeight()) {
                    hero.addItemToInventory(loots.get(Integer.parseInt(choice)));
                    System.out.println("[LOOT ADDED!!!]");
                    Thread.sleep(1000);
                    loots.remove(Integer.parseInt(choice));
                } else {
                    System.out.println("[THERE IS NO SPACE IN INVENTORY]");
                    Thread.sleep(1000);
                    break;
                }

            } catch (Exception exception) {
                try {
                    System.out.println("[INVALID LOOT INPUT]");
                    Thread.sleep(500);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    //Write to a file
    public static void writeToFile(Gamer newGamer) {
        try {
            ArrayList<Gamer> gamers = new ArrayList<>();
            ArrayList<Gamer> toRemove = new ArrayList<Gamer>();
            ArrayList<Gamer> toAdd = new ArrayList<Gamer>();

            gamers = readFile();
            boolean find = false;

            if (gamers.size() == 0) {
                gamers.add(newGamer);
            } else {
                for (Gamer gamer : gamers) {
                    if (gamer.getNickName().equals(newGamer.getNickName())) {
                        find = true;
                        if (gamer.getScore() < newGamer.getScore()) {
                            toRemove.add(gamer);
                            toAdd.add(newGamer);
                        }
                    }
                }
                if (!find) {
                    toAdd.add(newGamer);
                }
                gamers.removeAll(toRemove);
                gamers.addAll(toAdd);
                Collections.sort(gamers);

                if (gamers.size()>5){
                    for (int i = 5; i<=gamers.size();i++){
                        gamers.remove(i);
                    }
                }
            }


            FileOutputStream fileOutputStream = new FileOutputStream("scores.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gamers);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (Exception exception) {
        }
    }


    // Read from file
    public static ArrayList readFile() {
        ArrayList<Gamer> gamers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("scores.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gamers = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return gamers;

        } catch (Exception exception) {
        }
        return gamers;
    }


}


