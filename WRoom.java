import java.util.*;
public class WRoom extends Room{
    private Weapon weapon;
    private boolean hasSword, hasFlameThrower;

    public WRoom(){
        weapon = new Weapon();
    }

    public void setHasSword(boolean bool){
        this.hasSword = bool;
    }

    public void setHasFlameThrower(boolean bool){
        this.hasFlameThrower = bool;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }
    Scanner scanner = new Scanner(System.in);
    public void welcomeMessage(Hero hero,Weapon weapon){
        System.out.println("Hello, welcome to the weapons room. Here you will find either the sword or flamethrower");
        Sword sword = new Sword();
        Flamethrower flamethrower = new Flamethrower();
        if (weapon.equals(sword)){
            System.out.println("There is a sword in this weapons room!! Would you like to use it?\nPress 1 to pick up sword\nPress 2 to continue as is");
            System.out.println();
            int pickup = scanner.nextInt();
            if(pickup==1){
                hero.setHasSword(true);
                hero.useSword();
                setHasFlameThrower(true);
                System.out.println("Congrats you picked up the sword! Your damage is now increased by 3!");
                System.out.println();
            }
            System.out.println();

        }
        hero.setHasFlameThrower(true);
        hero.useFlameThrower();
        setHasFlameThrower(true);
        System.out.println("Congrats you picked up the flamethrower! Your damage is now increased by 10 and your dexterity by 2!");
        System.out.println();
    }


}
