import Characters.Hero;
import Items.Armor;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        Weapon.generateWeapons();
        Armor.generateAllArmors();
        Dungeon dungeon = new Dungeon();
        boolean welcomeMenu = true;
        boolean characterCreationMenu = false;
        boolean game = false;
        boolean topScorersMenu = false;
        boolean howToPlayMenu = false;
        Hero hero = null;
        String action;


        while (true) {
            while (welcomeMenu) {
                Display.Welcome();
                action = Events.getInput();
                if (action.equals("1")) {
                    characterCreationMenu = true;
                    welcomeMenu = false;
                    break;
                } else if (action.equals("2")) {
                    topScorersMenu = true;
                    welcomeMenu = false;
                    characterCreationMenu = false;
                    game = false;

                } else if (action.equals("3")) {
                    System.exit(1);
                }else if (action.equals("4")) {
                    welcomeMenu = false;
                    howToPlayMenu = true;
                } else {
                    System.out.println("Wrong Input");
                }
            }

            while (topScorersMenu) {
                Display.displayTopScorers();
                ArrayList<Gamer> gamers = Events.readFile();
                if (gamers.size() != 0) {
                    for (Gamer gamer : gamers) {
                      gamer.display();
                    }
                } else {
                    System.out.println("[THERE ARE NO SCORES]");
                }
                System.out.println("[PRESS -1 TO GO BACK]");
                action = Events.getInput();
                if (action.equals("-1")) {
                    topScorersMenu = false;
                    welcomeMenu = true;
                    break;
                } else {
                    System.out.println("[WRONG INPUT]");
                }
            }

            while (characterCreationMenu) {
                hero = Events.createCharacter(hero);
                characterCreationMenu = false;
                game = true;
            }

            while (howToPlayMenu){
                Display.displayHowToPlayMenu();
                action = input.nextLine();
                if (action.equals("-1")){
                    howToPlayMenu = false;
                    welcomeMenu = true;
                    break;
                }else {
                    System.out.println("[INVALID INPUT -_-]");
                }
            }

            while (game) {
                try {
                    System.out.println("\n\n\n");
                    Events.displayCurrentRoomInfo(hero);
                    System.out.print("action: ");
                    action = input.nextLine().toLowerCase(Locale.ROOT);
                    if (action.startsWith("move")) {
                        Events.changeHeroesRoom(hero, action);
                    } else if (action.startsWith("attack")) {
                        Events.battle(hero, action);
                    } else if (action.equals("y")) {
                        Events.loot(hero);
                    } else if (action.equals("n")) {
                        System.out.println();
                    } else if (action.equals("p")) {
                        Events.inventory(hero);
                    } else {
                        System.out.println("[invalid input]");
                    }
                }catch (Exception e){
                    System.out.println("[INVALID INPUT]");
                }
            }
        }

    }


}
