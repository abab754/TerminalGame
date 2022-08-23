import java.util.*;

public class Dungeon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();


        SRoom start = new SRoom();
        MRoom mRoom1 = new MRoom();
        MRoom mRoom2 = new MRoom();
        MRoom mRoom3 = new MRoom();
        MRoom mRoom4 = new MRoom();
        ARoom aRoom1 = new ARoom();
        ARoom aRoom2 = new ARoom();
        ARoom aRoom3 = new ARoom();
        ARoom aRoom4 = new ARoom();
        Room fountain = new Room();
        WRoom wRoom1 = new WRoom();
        WRoom wRoom2 = new WRoom();
        BRoom bossRoom = new BRoom();
        start.north = mRoom1;
        mRoom1.south = start;
        mRoom1.east = aRoom1;
        mRoom1.west = aRoom2;
        aRoom1.west = mRoom1;
        aRoom2.east = mRoom1;
        mRoom1.north = fountain;
        fountain.south = mRoom1;
        aRoom1.north = mRoom2;
        mRoom2.south = aRoom1;
        mRoom2.west = fountain;
        mRoom2.east = wRoom1;
        fountain.east = mRoom2;
        wRoom1.west = mRoom2;
        mRoom2.north = aRoom3;
        aRoom3.south = mRoom2;
        aRoom2.north = mRoom3;
        mRoom3.south = aRoom2;
        mRoom3.west= wRoom2;
        wRoom2.east = mRoom3;
        mRoom3.east = fountain;
        fountain.west = mRoom3;
        mRoom3.north = aRoom4;
        aRoom4.south = mRoom3;
        aRoom4.east = mRoom4;
        mRoom4.west = aRoom4;
        mRoom4.south = fountain;
        fountain.north = mRoom4;
        mRoom4.east = aRoom3;
        aRoom3.west = mRoom4;

        System.out.println("Welcome to the Dungeon Game! The objective of this game is to ge to the Boss Room and defeat the Wizard living there.\nYou will have to kill multiple monsters while acquiring weapons and accessories on the way. Don't forget to grab the key in order to unlock the gate!\nYou are currently in the Starting room, but you will face a monster in the first monster room now. Enter a name for our hero: ");
        String hero_name = scanner.nextLine();

        int hero_damage = (int)(Math.random()*6) + 1;
        int hero_health = 10 + rand.nextInt(11);
        int hero_dexterity = 3+rand.nextInt(6);
        Hero hero = new Hero(hero_damage, hero_health, hero_dexterity);
        hero.setRoom(start);
        System.out.println(hero_name + "'s damage: "+ hero_damage + "\n health: " + hero_health+ "\n dexterity: " + hero_dexterity);

        System.out.println();

        hero.moveNorth();
        int monster1_damage = (int)(Math.random()*4)+1;
        int monster1_health = 5 + rand.nextInt(6);
        Monster monster1 = new Monster(monster1_damage,monster1_health);
        System.out.println("Monster 1's damage:"+ monster1_damage+ "\nhealth: "+ monster1_health);

        System.out.println();

        mRoom1.setMonster(monster1);
        System.out.println("You are now in the first monster room. Prepare for battle!");
        Character winner = new Character();
        winner = mRoom1.battle(hero, monster1);
        System.out.println();
        if (winner.equals(hero)){
            System.out.println("Congrats. You have won the first room. Now you will move to one of the adjacent rooms where\nyou can pick up accessories or drink from the mysterious fountain.\nPress 1 to move West: \nPress 2 to move North: \nPress 3 to move East: ");
            int user = scanner.nextInt();
            if(user == 1){
                hero.moveWest();
                System.out.println("You are now in this room: "+ hero.getRoom());
            }
            else if(user == 2){
                hero.moveNorth();
                System.out.println("You are now in this room: "+ hero.getRoom());
            }
            else if(user ==3){
                hero.moveEast();
                System.out.println("You are now in this room: "+ hero.getRoom());
            }
            else{
                System.out.println("You have entered an invalid number");
            }
        }
        System.out.println();

        Key key = new Key();
        Shield shield = new Shield();
        Ring ring = new Ring();
        Potion potion = new Potion();
        double randomRoom = Math.random();
        if(randomRoom<0.25){
            double acc = Math.random();
            if(acc<0.25){
                aRoom1.setAccessory(key);
            }
            else if(acc>=0.25 && acc<0.5){
                aRoom2.setAccessory(key);
            }
            else if(acc>=0.5&& acc<0.75){
                aRoom3.setAccessory(key);
            }
            else{
                aRoom4.setAccessory(key);
            }
        }
        else if(randomRoom >=0.25 && randomRoom<0.5){
            double acc = Math.random();
            if(acc<0.25){
                aRoom1.setAccessory(shield);
            }
            else if(acc>=0.25 && acc<0.5){
                aRoom2.setAccessory(shield);
            }
            else if(acc>=0.5&& acc<0.75){
                aRoom3.setAccessory(shield);
            }
            else{
                aRoom4.setAccessory(shield);
            }
        }
        else if(randomRoom >=0.5 && randomRoom<0.75){
            double acc = Math.random();
            if(acc<0.25){
                aRoom1.setAccessory(potion);
            }
            else if(acc>=0.25 && acc<0.5){
                aRoom2.setAccessory(potion);
            }
            else if(acc>=0.5&& acc<0.75){
                aRoom3.setAccessory(potion);
            }
            else{
                aRoom4.setAccessory(potion);
            }
        }
        else{
            double acc = Math.random();
            if(acc<0.25){
                aRoom1.setAccessory(ring);
            }
            else if(acc>=0.25 && acc<0.5){
                aRoom2.setAccessory(ring);
            }
            else if(acc>=0.5&& acc<0.75){
                aRoom3.setAccessory(ring);
            }
            else{
                aRoom4.setAccessory(ring);
            }
        }


        if (hero.getRoom().equals(aRoom1)) {
            aRoom1.welcomeMessage(hero);
            System.out.println("Would you like to pick up an accessory? Press 1 to Pick up\nPress 2 to continue fighting without weapons");
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println("Nice! You now have a"+ aRoom1.getAccessory());
                if(aRoom1.getAccessory().equals(ring)){
                    hero.setHasRing(true);
                    hero.useRing();
                }
                else if(aRoom1.getAccessory().equals(potion)){
                    hero.setHasPotion(true);
                    hero.usePotion();
                }
                else{
                    hero.setHasShield(true);
                    hero.useShield();
                }
                hero.getAccessory(aRoom1.getAccessory());
                hero.getAccessories();
            }
            else{
                System.out.println("You chose not to pick up a weapon.\n Good luck fighting your enemies without one");
            }
            System.out.println( "hero's damage: "+ hero_damage + "\n health: " + hero_health+ "\n dexterity: " + hero_dexterity);
            System.out.println("You are now done with this room. Which room would you like to go to next?\n Press 1 to move west back into the first monster room(not recommended)\nPress 2 to move north into the second monster");
            int pick = scanner.nextInt();
            if(pick == 1){
                hero.moveEast();
            }
            else if (pick ==2){
                hero.moveNorth();
            }
            else{
                System.out.println("You have entered an invalid number");
            }
        }


        else if(hero.getRoom().equals(aRoom2)){
            aRoom2.welcomeMessage(hero);
            System.out.println("Would you like to pick up an accessory? Press 1 to Pick up\nPress 2 to continue fighting without weapons");
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println("Nice! You now have a"+ aRoom1.getAccessory());
                if(aRoom1.getAccessory().equals(ring)){
                    hero.setHasRing(true);
                    hero.useRing();
                }
                else if(aRoom1.getAccessory().equals(potion)){
                    hero.setHasPotion(true);
                    hero.usePotion();
                }
                else{
                    hero.setHasShield(true);
                    hero.useShield();
                }
                hero.getAccessory(aRoom1.getAccessory());
                hero.getAccessories();
            }
            else{
                System.out.println("You chose not to pick up an accessory.\n Good luck fighting your enemies without one");
            }
            System.out.println( "hero's damage: "+ hero_damage + "\n health: " + hero_health+ "\n dexterity: " + hero_dexterity);
            System.out.println("You are now done with this room. Which room would you like to go to next?\n Press 1 to move east back into the first monster room(not recommended)\nPress 2 to move north into monster room 3 where you'll have to battle a monster again");
            int pick = scanner.nextInt();
            if(pick == 1){
                hero.moveEast();
            }
            else if (pick ==2){
                hero.moveNorth();
            }
            else{
                System.out.println("You have entered an invalid number");
            }

        }

        else{

            System.out.println("hero's damage: "+ hero_damage + "\n health: " + hero_health+ "\n dexterity: " + hero_dexterity);
        }








    }
}
