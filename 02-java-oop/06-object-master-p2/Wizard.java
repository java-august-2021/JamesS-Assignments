public class Wizard extends Human{
    public Wizard(String wizardName){
        super(wizardName, 3, 8, 3, 50);
    }
    
    public void heal(Human target){
        int healAmount = this.getIntelligence();
        int newHealth = target.getHealth() + healAmount;
        target.setHealth(newHealth);
    }

    public void fireball(Human target){
        int attackAmount = this.getIntelligence() * 3;
        int newHealth = target.getHealth() - attackAmount;
        target.setHealth(newHealth);
    }

    

    

}
