public class Display {


    public static void Welcome() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome traveler.......");
        System.out.println("-----------------------");
        System.out.println("       MAIN MENU       ");
        System.out.println("_______________________");
        System.out.println();
        System.out.println(" 1.      NEW GAME        ");
        System.out.println();
        System.out.println(" 2.   SEE TOP SCORERS    ");
        System.out.println();
        System.out.println(" 3.      EXIT GAME        ");
        System.out.println();
        System.out.println(" 4.      HOW TO PLAY        ");
        System.out.println();


    }

    public static void displayHeroCreationMenu(){
        System.out.println("Welcome to the dungeon ");
        System.out.println("lets create a HERO");
        System.out.print("What is your hero name: ");
    }

    public static void displayHowToPlayMenu(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("[HOW TO ATTACK] To attack a monster, you should type [attack] and after that you should give the monster name");
        System.out.println("[EXAMPLE] attack m1");
        System.out.println("[HOW TO MOVE INSIDE THE DUNGEON] To move inside the dungeon, you should type [move] and after that you should give the door name ");
        System.out.println("[EXAMPLE] move d1");
        System.out.println("[MOVING BETWEEN LEVELS] It is same as the previous command, however this time you should type [up] or [down] after the [move] command");
        System.out.println("[EXAMPLE] move up      move down");
        System.out.println("[TYPE -1 TO EXIT THIS MENU]");
        System.out.print("action: ");
    }

    public static void displayTopScorers(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println();
        System.out.println();
        System.out.println("\t\t****** TOP 5 HIGHSCORES ******");
        System.out.println("---------------------------------------------");
    }
}
