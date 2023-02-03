package Items;

public  class Item {

    private String name;
    private double weight;
    private int value;
    private String type;


    public Item(String name, double weight, int value, String type){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.type = type;
    }


// display weapon information
    public  void displayItemInfo(){
        System.out.println("Name: "+this.getName());
        System.out.println("Type: "+this.getType());
        System.out.println("Weight: "+this.getWeight());
        System.out.println("Value: "+this.getValue());
    }


// getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
