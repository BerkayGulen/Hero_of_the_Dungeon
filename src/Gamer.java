import java.io.Serializable;
import java.util.Locale;

public class Gamer implements Comparable, Serializable {

    private String nickName;
    private int score;


    private int numberOfRescued;

    public Gamer(){}
    public Gamer(String nickName, int score, int numberOfRescued) {
        super();
        this.nickName = nickName.toUpperCase(Locale.ROOT);
        this.score = score;
        this.numberOfRescued = numberOfRescued;
    }



    @Override
    public int compareTo( Object comparesTo) {
        int compareScore =((Gamer)comparesTo).getScore();
        /* For Ascending order*/
        return compareScore-this.score;
    }

    public void display(){
        System.out.println("Hero Name: " +getNickName());
        System.out.println("Score: "+getScore());
        System.out.println("Number Of Townspeople Saved: "+getNumberOfRescued());
        System.out.println("---------------------------------------------");
    }




    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfRescued() {
        return numberOfRescued;
    }

    public void setNumberOfRescued(int numberOfRescued) {
        this.numberOfRescued = numberOfRescued;
    }


}
