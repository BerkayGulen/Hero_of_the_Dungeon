package Characters;
import Items.Armor;
import Items.Clothings.LightArmor;
import Items.Item;
import Items.Weapon;
import Items.Weapons.Sword;


public class Hero extends Character {

    private int currentRoom;
    private double attackDamage;
    private int numberOfRescuedPeople = 0;
    private int numberOfMonstersKilled = 0;
    private double currentInventoryWeight = 0;
    private double score;



    public Hero(String name) {
        this.currentRoom = 0;
        setName(name);
        setHp(40);
        addItemToInventory(new Sword("Basic Short Sword", 2, 1, 10, 1,"Short Sword"));
        addItemToInventory(new LightArmor("Basic Light Armor", 10, 1, 8,"Light Armor"));
        setWeapon((Weapon) getInventory().get(0));
        setArmor((Armor) getInventory().get(1));
        setMaxInventoryWeight(50);
    }

    @Override
    public void display() {
        System.out.println("Hero " + this.getName() + ", " + (int)getHp() + " HP, " + getWeapon().getName() + ", " + getArmor().getName() + "\t\t [PRESS P FOR INVENTORY]\t\t" +
                "[Number Of Monsters Killed: " + getNumberOfMonstersKilled()+"]" + "\t\t[Number of Townspeople Rescued: " + getNumberOfRescuedPeople()+"]");
    }

    //increase rescued people
    public void increaseRescuedPeople(int numberOfTownsPeople) {
        setNumberOfRescuedPeople(getNumberOfRescuedPeople() + numberOfTownsPeople);
    }

    public void increaseNumberOfMonsterKilled() {
        setNumberOfMonstersKilled(getNumberOfMonstersKilled() + 1);
    }


    @Override
    public void addItemToInventory(Item item) {
        getInventory().add(item);
    }


    public void displayInventory(){
        int i = 0;
        System.out.println("CURRENT INVENTORY WEIGHT: "+getCurrentInventoryWeight()+"  MAX WEIGHT["+getMaxInventoryWeight()+"]");
        for (Item item: getInventory()){
            item.displayItemInfo();
            System.out.println("Item Number: " +i);
            System.out.println("---------------------------------");
            i++;
        }
    }

    //remove current armor
    public void changeCurrentArmor(int armorIndex){
        try {
            setArmor((Armor) getInventory().get(armorIndex));
            System.out.println("[ARMOR IS CHANGED]");
        }catch (Exception exception){
            System.out.println("[WRONG INPUT]");
        }

    }

    //change current weapon
    public void changeCurrentWeapon(int weaponIndex){
        try {
            setWeapon((Weapon) getInventory().get(weaponIndex));
            System.out.println("[Weapon IS CHANGED]");
        }catch (Exception exception){
            System.out.println("[WRONG INPUT]");
        }

    }

    public void attack(Monster monster) {
        monster.setHp(monster.getHp() - calculatePureDamage(monster));
//        System.out.println("hero hp: "+monster.getHp());
//        System.out.println("monster attack damage: "+calculatePureDamage(monster));
    }

    //calculate pure damage (monster damage - hero armor)
    public double calculatePureDamage(Monster monster) {
        double pureDamage = (this.getWeapon().getDamage() - monster.getArmor().getArmor());
        if (pureDamage > 0) {
            return pureDamage;
        }
        return 0;
    }

    //get inventory weight
    public double getCurrentInventoryWeight() {
        double dummyWeight = 0;
        for (Item item : getInventory()) {
            dummyWeight += item.getWeight();
        }
        setCurrentInventoryWeight(dummyWeight);
        return dummyWeight;
    }

    public double getRemainingInventoryWeight(){
        return (getMaxInventoryWeight() - getCurrentInventoryWeight());
    }

    //Calculate score
    public double calculateScore(){
        double dummyScore = 0;
        for (Item item: getInventory()){
            dummyScore += item.getValue();
        }
        dummyScore += getNumberOfMonstersKilled();
        dummyScore += getNumberOfRescuedPeople();
        return dummyScore;
    }


    //getter and setters
    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public void setCurrentRoom(int currentRoom) {
        this.currentRoom = currentRoom;
    }

    public int getCurrentRoom() {
        return currentRoom;
    }

    public int getNumberOfRescuedPeople() {
        return numberOfRescuedPeople;
    }

    public void setNumberOfRescuedPeople(int numberOfRescuedPeople) {
        this.numberOfRescuedPeople = numberOfRescuedPeople;
    }

    public int getNumberOfMonstersKilled() {
        return numberOfMonstersKilled;
    }

    public void setNumberOfMonstersKilled(int numberOfMonstersKilled) {
        this.numberOfMonstersKilled = numberOfMonstersKilled;
    }


    public void setCurrentInventoryWeight(double currentInventoryWeight) {
        this.currentInventoryWeight = currentInventoryWeight;
    }

    public double getScore() {
        this.score = calculateScore();
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


}
