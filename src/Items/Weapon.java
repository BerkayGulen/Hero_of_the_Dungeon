package Items;

import Items.Weapons.Axe;
import Items.Weapons.Bow;
import Items.Weapons.Sword;

import java.util.ArrayList;

public class Weapon extends Item{
    private double damage;
    private double range;
    private static ArrayList<Weapon> allWeapons = new ArrayList<>();

    public Weapon(String name, double weight, int value, double damage, double range,String type) {
        super(name, weight, value,type);
        this.damage = damage;
        this.range = range;
    }



// display weapon information
    @Override
    public  void displayItemInfo(){
        super.displayItemInfo();
        System.out.println("Damage: "+this.damage);
        System.out.println("Range: "+this.range);
    }

// generate all weapons
    public static void generateWeapons(){

        allWeapons.add(new Sword("Daedric Sword",3.0,5,10,1,"Short Sword"));
        allWeapons.add(new Sword("Silver Sword",3.5,3,9,1,"Short Sword"));
        allWeapons.add(new Sword("Dwarven Sword",2.0,4,10,1,"Short Sword"));

        allWeapons.add(new Sword("Aerondight",3.0,10,15,1.5,"Long Sword"));
        allWeapons.add(new Sword("Teigr",3.0,7,12,1.5,"Long Sword"));
        allWeapons.add(new Sword("Longclaw",4.0,6,11,1.5,"Long Sword"));

        allWeapons.add(new Sword("Dwarven Dagger",1.0,4,8.5,0.3,"Dagger"));
        allWeapons.add(new Sword("Keening",1.0,5,8.1,0.5,"Dagger"));
        allWeapons.add(new Sword("Daedric Dagger",0.5,6,8.2,0.7,"Dagger"));

        allWeapons.add(new Axe("Ancient Nord War Axe",5,5,12,2,"Axe"));
        allWeapons.add(new Axe("Daedric War Axe",4,4,11,2.2,"Axe"));
        allWeapons.add(new Axe("Dwarven War Axe",6,4,12,2.6,"Axe"));

        allWeapons.add(new Axe("Forsworn Axe",4,6,9,2,"Broad Axe"));
        allWeapons.add(new Axe("Hoarfrost ",5,3,10,2.1,"Broad Axe"));
        allWeapons.add(new Axe("Okin",6,4,11,1.8,"Broad Axe"));

        allWeapons.add(new Axe("Headsman’s Small Axe",3,6,10,1.1,"Small Axe"));
        allWeapons.add(new Axe("Elven Battle Small Axe",4,4,9,1.2,"Small Axe"));
        allWeapons.add(new Axe("Glass Battle Small Axe",5,3,8.5,1,"Small Axe"));

        allWeapons.add(new Axe("Ancient Nord Short Bow",5,7,12,5,"Short Bow"));
        allWeapons.add(new Axe("Daedric Short Bow",6,8,11,6,"Short Bow"));
        allWeapons.add(new Axe("Nightingale Short Bow",5,5,10,5,"Short Bow"));

        allWeapons.add(new Axe("Zephyr",4,8,12,7,"Long Bow"));
        allWeapons.add(new Axe("Orcish Long Bow",5,4,11,5,"Long Bow"));
        allWeapons.add(new Axe("Nord Hero Bow",3,8,12,7,"Long Bow"));

        allWeapons.add(new Axe("Karliah's Bow",4,8,12,7,"Composite Bow"));
        allWeapons.add(new Axe("Gauldur Blackbow",3,5,11,5,"Composite Bow"));
        allWeapons.add(new Axe("Ebony Bow",5,4,10,6,"Composite Bow"));



    }
// give random weapon
    public static Item generateRandomWeapon(){
       int randIndex = (int)(Math.random()*allWeapons.size());
       return allWeapons.get(randIndex);
    }












// getter and setters
    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }



}
