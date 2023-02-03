package Characters;
import Items.Armor;
import Items.Weapon;

public class Monster extends Character{

    public Monster(String name){
        this.setName(name);
       generateRandomMonster();
    }

    public void generateRandomMonster(){
        setWeapon((Weapon) Weapon.generateRandomWeapon());
        setArmor((Armor) Armor.generateRandomArmor());
        setHp(8);
    }

    public void attack(Hero hero){
        hero.setHp(hero.getHp()-calculatePureDamage(hero));
    }

    //calculate pure damage (monster damage - hero armor)
    public double calculatePureDamage(Hero hero){
        double pureDamage = (this.getWeapon().getDamage()-hero.getArmor().getArmor());
        if ( pureDamage> 0){
            return pureDamage;
        }
        return 0;
    }



}
