public class Monster extends Character{
    private int damage, health;
    private boolean defends;

    public Monster(int damage, int health){
        this.damage = damage;
        this.health = health;
    }

    public void setDefends(boolean bool){
        this.defends = bool;
    }

    public boolean getDefends(){
        return this.defends;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void attack(Hero hero){
        if(hero.getDodge()){

        }
        hero.setHealth(hero.getHealth()-this.damage);
    }

    public boolean isDead(){
        return this.health<=0;
    }


}
