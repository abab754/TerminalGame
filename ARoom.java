import java.util.*;
public class ARoom extends Room{
    private Accessory accessory;

    public ARoom(){
    }

    public void setAccessory(Accessory accessory){
        this.accessory = accessory;
    }

    public Accessory getAccessory(){
        return this.accessory;
    }
    Scanner scanner = new Scanner(System.in);

    public void welcomeMessage(Hero hero){
        System.out.println("Hello Welcome to the Accessories room where you'll find 1 of 4 accessories.");
        System.out.println("This room has the "+ getAccessory());
    }

}
