public class Samurai extends Human{
    private static int numberOfSamurai = 0;
    public Samurai(String samuraiName){
        super(samuraiName, 3, 3, 3, 200);
        numberOfSamurai++;
    }

    public void deathBlow(Human target){
        target.setHealth(0);
        this.setHealth(this.getHealth()/2);
    }

    public void meditate(){
        int boostAmount = this.getHealth()/2;
        this.setHealth(getHealth() + boostAmount);
    }

    public static int samuraiCount(){
        return numberOfSamurai;
    }
    
    
}
