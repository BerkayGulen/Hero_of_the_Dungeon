package Items;
import Items.Clothings.ChainmailArmor;
import Items.Clothings.LeatherArmor;
import Items.Clothings.LightArmor;



import java.util.ArrayList;

public class Armor extends Item{

    private double armor;
    private static ArrayList<Armor> allArmors = new ArrayList<>();

    public Armor(String name, double weight, int value, double armor,String type) {
        super(name, weight, value, type);
        this.armor = armor;

    }

// generate all armors
    public static void generateAllArmors(){
        allArmors.add(new LightArmor("Daedric Light Armor",5,3,4,"Light Armor"));
        allArmors.add(new LightArmor("Dwarven Light Armor",6,4,5,"Light Armor"));
        allArmors.add(new LightArmor("Wolven light armor",7,5,6,"Light Armor"));
        allArmors.add(new LeatherArmor("Daedric Leather Armor",8.5,4,4,"Leather Armor"));
        allArmors.add(new LeatherArmor("Dwarven Leather Armor",8.5,3,5,"Leather Armor"));
        allArmors.add(new LeatherArmor("Wolven Leather Armor",8,5,6,"Leather Armor"));
        allArmors.add(new ChainmailArmor("Daedric Chainmail Armor",8,4,6,"Chainmail Armor"));
        allArmors.add(new ChainmailArmor("Dwarven Chainmail Armor",9,5,7,"Chainmail Armor"));
        allArmors.add(new ChainmailArmor("Wolven Chainmail Armor",9.5,6,8,"Chainmail Armor"));


    }

// give random armor
    public static Item generateRandomArmor(){
        int randIndex = (int)(Math.random()*allArmors.size());
        return allArmors.get(randIndex);
    }



//display armor information
    @Override
    public void displayItemInfo(){
        super.displayItemInfo();
        System.out.println("Armor: "+this.armor);
    }



//setter and getters
    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }


}
