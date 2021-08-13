public class Ninja extends Human {
    public Ninja(String ninjaName){
        super(ninjaName, 3, 3, 10, 100);

    }
    
    public void steal(Human target){
        int stealAmount = this.getStealth();
        int newHealth = target.getHealth() - stealAmount;
        target.setHealth(newHealth);
        this.setHealth(this.getHealth()+stealAmount);
    }

    public void runAway(){
        this.setHealth(this.getHealth()-10);
    }

    
}
