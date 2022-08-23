import java.util.*;

public class Hero extends Character{
    private int damage, health, dexterity, weapon_count;
    private boolean hasSword, hasFlameThrower, hasPotion, hasRing, hasShield, hasKey, dodge;
    private LinkedList<Accessory> accessories, battle_options, turn_options;
    private Room room;

    public Hero(int damage, int health, int dexterity){
        this.damage = damage;
        this.health = health;
        this.dexterity = dexterity;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getHealth(){
        return this.health;
    }

    public int getDexterity(){
        return this.dexterity;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setDexterity(int dexterity){
        this.dexterity= dexterity;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public Room getRoom(){
        return this.room;
    }

    public void setHasPotion(boolean bool){
        this.hasPotion = bool;
    }

    public boolean getHasPotion(){
        return this.hasPotion;
    }

    public void usePotion(){

    }

    public void setHasRing(boolean bool){
        this.hasRing = bool;
    }

    public boolean getHasRing(){
        return this.hasRing;
    }

    public int useRing(){
        return this.dexterity++;
    }

    public void setHasShield(boolean bool){
        this.hasShield = bool;
    }

    public boolean getHasShield(){
        return this.hasShield;
    }

    public int useShield(){
        return health--;
    }

    public void setAccessories(LinkedList<Accessory> accessories){
        this.accessories = accessories;
    }

    public boolean getAccessory(Accessory accessory){
        if (this.accessories.size() != 3){
            accessories.add(accessory);
            return true;
        }
        return false;
    }

    public Accessory removeAccessory(int i){
        return accessories.remove(i);
    }

    public LinkedList<Accessory> getAccessories(){
        return this.accessories;
    }

    public void setHasSword(boolean bool){
        this.hasSword = bool;
    }

    public boolean getHasSword(){
        return this.hasSword;
    }

    public int useSword(){
        this.damage = damage+3;
        return this.damage;
    }

    public void setHasKey(boolean bool){
        this.hasKey = bool;
    }

    public boolean getHasKey(){
        return this.hasKey;
    }

    public void setHasFlameThrower(boolean bool){
        this.hasFlameThrower = bool;
    }

    public boolean getHasFlamethrower(){
        return this.hasFlameThrower;
    }

    public void useFlameThrower(){
        this.damage = damage+10;
        this.dexterity = dexterity+2;
    }

    public void attackMonster(Monster monster){
        if(monster.getDefends()==true){
            monster.setHealth(monster.getHealth()-(1/2*this.damage));
        }
        else{
            monster.setHealth(monster.getHealth()-this.damage);
        }
    }

    public void setDodge(boolean bool){
        this.dodge = bool;
    }

    public boolean getDodge(){
        return this.dodge;
    }

    public boolean isDead(){
        return this.health<=0;
    }

    public void moveNorth(){
        this.setRoom(this.getRoom().north);
    }

    public void moveSouth(){
        this.setRoom(this.getRoom().south);
    }

    public void moveEast(){
        this.setRoom(this.getRoom().east);
    }

    public void moveWest(){
        this.setRoom(this.getRoom().west);
    }

    public void drinkFountain(){
        double rand = Math.random();

        if(rand<0.2){
            this.setDamage(this.getDamage()+1);
        }

        else if(rand>0.2 && rand<0.4){
            this.setDexterity(this.getDexterity()+1);
        }
        else if(rand>0.4 && rand<0.6){
            this.setHealth(this.getHealth()-2);
        }
    }




}
