public class Human {
    protected String name;
    private int strength;
    private int intelligence;
    private int stealth;
    private int health;


    //Constructor
    public Human(String name, int strength, int intelligence, int stealth, int health){
        this.name = name;
        this.strength = strength;
        this.intelligence = intelligence;
        this.stealth = stealth;
        this.health = health;
    }

    //Getters
    public String getName(){
        return name;
    }

    public int getStrength(){
        return strength;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public int getStealth(){
        return stealth;
    }
    public int getHealth(){
        return health;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public void setStealth(int stealth){
        this.stealth = stealth;
    }
    public void setHealth(int health){
        this.health = health;
    }

    //Methods
    public void attack(Human target){
        int attackAmount = this.getStrength();
        int newHealth = target.getHealth()- attackAmount;
        target.setHealth(newHealth);
    }



}