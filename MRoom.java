import java.util.*;
public class MRoom extends Room{
    private Monster monster;
    Scanner scanner = new Scanner(System.in);
    private boolean hasNoSouth, hasNoNorth;

    public Character battle(Hero hero, Monster monster){
        Character winner = new Character();
        System.out.println("You are now in battle! First, it is your turn.\nEnter 1 to attack\nEnter 2 to dodge\nEnter 3 to run");
        int first_turn = scanner.nextInt();
        if(first_turn == 1){
            System.out.print("Good, you have attacked the monster. ");
            hero.attackMonster(monster);
            System.out.print("the monster's health is now "+ monster.getHealth());
        }
        else if(first_turn == 2){
            hero.setDodge(true);
            System.out.print("Good, you have chosen to dodge the monster's attack. Now with the probability of \na tenth of our hero's dexterity, we can avoid the monster's attack");
            System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
            System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
        }
        else if(first_turn == 3){
            System.out.print("HaHaHa you are a scared loser! You have chosen to run away from the monster\nNow with the probability equal to a tenth of the hero's dexterity, you \nwill randomly end up in one of the adjacent rooms");
            if(hero.getRoom().hasNoSouth){
                double random = Math.random();
                if(random<=0.33){
                    hero.moveEast();
                }
                else if(random>0.33 && random<=0.66){
                    hero.moveNorth();
                }
                else{
                    hero.moveWest();
                }
                System.out.println("You are now in this room: "+ hero.getRoom());
            }
            else if(hero.getRoom().hasNoNorth){
                double random = Math.random();
                if(random<=0.33){
                    hero.moveEast();
                }
                else if(random>0.33 && random<=0.66){
                    hero.moveSouth();
                }
                else{
                    hero.moveWest();
                }
                System.out.println("You are now in this room: "+ hero.getRoom());
            }
            else {
                double random = Math.random();
                if(random<0.25){
                    hero.moveEast();
                }
                else if(random>=0.25 && random<0.50){
                    hero.moveNorth();
                }
                else if(random >= 0.50 && random<0.75){
                    hero.moveWest();
                }
                else{
                    hero.moveSouth();
                }
                System.out.println("You are now in this room: "+ hero.getRoom());
                winner = hero;
                return winner;
            }


        }
        else{
            System.out.println("You have entered an invalid number");
        }

        //if hero died during battle
        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            return monster;
        }
        //if monster died during battle
        else if(monster.isDead()){
            winner = hero;
            return winner;
        }
        //Monster's first turn if no on has won yet
        else{
            System.out.println("It is now the monster's turn. The monster will either attack or defend.\nIf you chose to dodge first, then you have a 10% chance of dodging this attack.");
            double rand = Math.random();
            if(rand<0.7){
                if(hero.getDodge()==true){
                    double prob = Math.random();
                    double tenth = ((1/10)*hero.getDexterity());
                    if(prob < tenth){
                        System.out.println("Nice Job! You have avoided the monster's attack. Get prepared for your turn again");
                    }
                    System.out.println("You suck! You did not avoid the attack and have taken damage. Get prepared for your turn");
                }
                monster.attack(hero);
                System.out.println("The monster has attacked you");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());

            }
            else{
                monster.setDefends(true);
                System.out.println("The monster has chosen to defend your attack. This means it only takes 1/2 of the damage you dealt it");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }
        }

        System.out.println();
        hero.setDodge(false);

        //check to see if anyone has won after monsters turn
        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            winner = hero;
            return winner;
        }
        //Second round of battle starts if no on has won yet
        //hero's second turn
        else{
            System.out.println("The first round of the battle is done. It is your turn again.\nPress 1 to attack\nPress 2 to dodge\nPress 3 to run");
            int round2 = scanner.nextInt();
            if(round2 == 1){
                System.out.print("Good, you have attacked the monster ");
                hero.attackMonster(monster);
                System.out.print("the monster's health is now "+ monster.getHealth());
            }
            else if(round2 == 2){
                hero.setDodge(true);
                System.out.print("Good, you have chosen to dodge the monster's attack. Now with the probability of \na tenth of our hero's dexterity, we can avoid the monster's attack");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }
            else if(round2 == 3){
                System.out.print("HaHaHa you are a scared loser! You have chosen to run away from the monster\nNow with the probability equal to a tenth of the hero's dexterity, you \nwill randomly end up in one of the adjacent rooms");
                if(hero.getRoom().hasNoSouth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveNorth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());


                }
                else if(hero.getRoom().hasNoNorth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveSouth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                else {
                    double random = Math.random();
                    if(random<0.25){
                        hero.moveEast();
                    }
                    else if(random>=0.25 && random<0.50){
                        hero.moveNorth();
                    }
                    else if(random >= 0.50 && random<0.75){
                        hero.moveWest();
                    }
                    else{
                        hero.moveSouth();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                winner=hero;
                return winner;
            }
            else{
                System.out.println("You have entered an invalid number");
            }
            System.out.println();
        }


        hero.setDodge(false);

        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            System.out.println("Congrats. You have won the first battle. Now you will move to one of the adjacent rooms where\nyou can pick up accessories or drink from the mysterious fountain.");
            winner = hero;
            return winner;
        }
        //Monster's second turn
        else {
            System.out.println("It is now the monster's second turn. The monster will either attack or defend.\nIf you chose to dodge on your turn, then you have a 10% chance of dodging this attack.");
            double random = Math.random();
            if(random<0.7){
                if(hero.getDodge()==true){
                    double probs = Math.random();
                    double tenth = ((1/10)*hero.getDexterity());
                    if(probs < tenth){
                        System.out.println("Nice Job! You have avoided the monster's attack. Get prepared for your turn again ");
                    }
                    System.out.println(" You suck! You did not avoid the attack and have taken damage. Get prepared for your turn ");
                }
                monster.attack(hero);
                System.out.println("The monster has attacked you");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ "\ndamage: "+monster.getDamage()+ "\nhealth:  "+ monster.getHealth());

            }
            else{
                monster.setDefends(true);
                System.out.println("The monster has chosen to defend your attack. This means it only takes 1/2 of the damage you dealt it ");
                System.out.println("hero's stats: "+  "\ndamage: "+hero.getDamage()+"\nhealth:  "+ hero.getHealth()+"\ndexterity:  "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }

            System.out.println();
        }

        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            System.out.println("Congrats. You have won the first battle. Now you will move to one of the adjacent rooms where\n you can pick up accessories or drink from the mysterious fountain.");
            winner = hero;
            return winner;
        }
        //hero's third turn
        else{
            System.out.println("The first second of the battle is done. It is your turn again. \nPress 1 to attack\n Press 2 to dodge\n Press 3 to run");
            int round2 = scanner.nextInt();
            if(round2 == 1){
                System.out.print("Good, you have attacked the monster ");
                hero.attackMonster(monster);
                System.out.print("the monster's health is now "+ monster.getHealth());
            }
            else if(round2 == 2){
                hero.setDodge(true);
                System.out.print("Good, you have chosen to dodge the monster's attack. Now with the probability of \na tenth of our hero's dexterity, we can avoid the monster's attack");
                System.out.println("hero's stats: "+ "\ndamage: "+ hero.getDamage()+"\nhealth: "+ hero.getHealth()+"\ndexterity: "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }
            else if(round2 == 3){
                System.out.print("HaHaHa you are a scared loser! You have chosen to run away from the monster\nNow with the probability equal to a tenth of the hero's dexterity, you \nwill randomly end up in one of the adjacent rooms");
                if(hero.getRoom().hasNoSouth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveNorth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                else if(hero.getRoom().hasNoNorth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveSouth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                else {
                    double random = Math.random();
                    if(random<0.25){
                        hero.moveEast();
                    }
                    else if(random>=0.25 && random<0.50){
                        hero.moveNorth();
                    }
                    else if(random >= 0.50 && random<0.75){
                        hero.moveWest();
                    }
                    else{
                        hero.moveSouth();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                winner=hero;
                return winner;
            }
            else{
                System.out.println("You have entered an invalid number");
            }

            System.out.println();
        }

        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            System.out.println("Congrats. You have won the first battle. Now you will move to one of the adjacent rooms where\nyou can pick up accessories or drink from the mysterious fountain.\nPress 1 to move West: \nPress 2 to move North: \nPress 3 to move East: ");
            winner = hero;
            return winner;
        }
        //Monster's third turn
        else {
            System.out.println("It is now the monster's third turn. The monster will either attack or defend.\nIf you chose to dodge on your turn, then you have a 10% chance of dodging this attack.");
            double random = Math.random();
            if(random<0.7){
                if(hero.getDodge()==true){
                    double probs = Math.random();
                    double tenth = ((1/10)*hero.getDexterity());
                    if(probs < tenth){
                        System.out.println("Nice Job! You have avoided the monster's attack. Get prepared for your turn again ");
                    }
                    System.out.println(" You suck! You did not avoid the attack and have taken damage. Get prepared for your turn ");
                }
                monster.attack(hero);
                System.out.println("The monster has attacked you");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ "\ndamage: "+monster.getDamage()+ "\nhealth:  "+ monster.getHealth());

            }
            else{
                monster.setDefends(true);
                System.out.println("The monster has chosen to defend your attack. This means it only takes 1/2 of the damage you dealt it ");
                System.out.println("hero's stats: "+  "\ndamage: "+hero.getDamage()+"\nhealth:  "+ hero.getHealth()+"\ndexterity:  "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }

            System.out.println();
        }
        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            System.out.println("Congrats. You have won the first battle. Now you will move to one of the adjacent rooms where\n you can pick up accessories or drink from the mysterious fountain.");
            winner = hero;
            return winner;
        }
        //hero's 4th turn
        else{
            System.out.println("The third round of the battle is done. It is your turn again. \nPress 1 to attack\n Press 2 to dodge\n Press 3 to run");
            int round2 = scanner.nextInt();
            if(round2 == 1){
                System.out.print("Good, you have attacked the monster ");
                hero.attackMonster(monster);
                System.out.print("the monster's health is now "+ monster.getHealth());
            }
            else if(round2 == 2){
                hero.setDodge(true);
                System.out.print("Good, you have chosen to dodge the monster's attack. Now with the probability of \na tenth of our hero's dexterity, we can avoid the monster's attack");
                System.out.println("hero's stats: "+ "\ndamage: "+ hero.getDamage()+"\nhealth: "+ hero.getHealth()+"\ndexterity: "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }
            else if(round2 == 3){
                System.out.print("HaHaHa you are a scared loser! You have chosen to run away from the monster\nNow with the probability equal to a tenth of the hero's dexterity, you \nwill randomly end up in one of the adjacent rooms");
                if(hero.getRoom().hasNoSouth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveNorth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                else if(hero.getRoom().hasNoNorth){
                    double random = Math.random();
                    if(random<=0.33){
                        hero.moveEast();
                    }
                    else if(random>0.33 && random<=0.66){
                        hero.moveSouth();
                    }
                    else{
                        hero.moveWest();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                else {
                    double random = Math.random();
                    if(random<0.25){
                        hero.moveEast();
                    }
                    else if(random>=0.25 && random<0.50){
                        hero.moveNorth();
                    }
                    else if(random >= 0.50 && random<0.75){
                        hero.moveWest();
                    }
                    else{
                        hero.moveSouth();
                    }
                    System.out.println("You are now in this room: "+ hero.getRoom());
                }
                winner=hero;
                return winner;
            }
            else{
                System.out.println("You have entered an invalid number");
            }

            System.out.println();
        }
        if(hero.isDead()){
            System.out.println("The game is over. You are garbage and have lost the game");
            winner = monster;
            return winner;
        }
        else if(monster.isDead()){
            System.out.println("Congrats. You have won the first battle. Now you will move to one of the adjacent rooms where\nyou can pick up accessories or drink from the mysterious fountain.");
            winner = hero;
            return winner;
        }
        //Monster's 4th turn
        else {
            System.out.println("It is now the monster's fourth turn. The monster will either attack or defend.\nIf you chose to dodge on your turn, then you have a 10% chance of dodging this attack.");
            double random = Math.random();
            if(random<0.7){
                if(hero.getDodge()==true){
                    double probs = Math.random();
                    double tenth = ((1/10)*hero.getDexterity());
                    if(probs < tenth){
                        System.out.println("Nice Job! You have avoided the monster's attack. Get prepared for your turn again ");
                    }
                    System.out.println(" You suck! You did not avoid the attack and have taken damage. Get prepared for your turn ");
                }
                monster.attack(hero);
                System.out.println("The monster has attacked you");
                System.out.println("hero's stats: "+  hero.getDamage()+" "+ hero.getHealth()+" "+ hero.getDexterity());
                System.out.println("monster's stats: "+ "\ndamage: "+monster.getDamage()+ "\nhealth:  "+ monster.getHealth());

            }
            else{
                monster.setDefends(true);
                System.out.println("The monster has chosen to defend your attack. This means it only takes 1/2 of the damage you dealt it ");
                System.out.println("hero's stats: "+  "\ndamage: "+hero.getDamage()+"\nhealth:  "+ hero.getHealth()+"\ndexterity:  "+ hero.getDexterity());
                System.out.println("monster's stats: "+ monster.getDamage()+ " "+ monster.getHealth());
            }

            System.out.println();
        }
        return winner;


    }

    public void setHasNoSouth(boolean bool){
        this.hasNoSouth = bool;
    }

    public void setHasNoNorth(boolean bool){
        this.hasNoNorth = bool;
    }

    public void setMonster(Monster monster1){
        this.monster = monster1;
    }




}
