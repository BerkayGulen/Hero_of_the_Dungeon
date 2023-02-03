package Characters;
import Items.Armor;
import Items.Item;
import Items.Weapon;
import java.util.ArrayList;

public class Character {

    private String name;
    private double hp;
    private Weapon weapon;
    private Armor armor;
    private double maxInventoryWeight;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Character(){}
    public Character(String name, double hp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
        this.armor = armor;
    }

    public void addItemToInventory(Item item){
        inventory.add(item);
    }

    public void display(){
        System.out.println("name: "+getName());
        System.out.println("hp: "+getHp());
        System.out.println("weapon: "+getWeapon().getName());
        System.out.println("get armor: "+getArmor().getName());
    }



//getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public double getMaxInventoryWeight() {
        return maxInventoryWeight;
    }

    public void setMaxInventoryWeight(double maxInventoryWeight) {
        this.maxInventoryWeight = maxInventoryWeight;
    }

}
