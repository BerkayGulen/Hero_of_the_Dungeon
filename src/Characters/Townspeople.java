package Characters;

public class Townspeople extends Character {
    private static int countHealers;
    private boolean isHealer = false;


    public Townspeople() {
        if (getCountHealers() % 5 == 0) {
            setHealer();
        }
        countHealers++;
    }

    public void heal(Hero hero) {
        if (isHealer) {
            hero.setHp(hero.getHp() + 10);
        }
    }


    @Override
    public void display() {
        System.out.println("healer: " + isHealer());
        System.out.println("count: " + getCountHealers());
    }


    // getter and setters
    public static int getCountHealers() {
        return countHealers;
    }

    public static void setCountHealers(int countHealers) {
        Townspeople.countHealers = countHealers;
    }

    public boolean isHealer() {
        return isHealer;
    }

    public void setHealer() {
        this.isHealer = true;
    }


}
