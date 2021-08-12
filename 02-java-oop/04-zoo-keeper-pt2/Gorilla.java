public class Gorilla extends Mammal{
    public Gorilla(){
        super(100);
    }
    public void throwSomething(int energyLevel){
        int energy = this.energyLevel;
        this.setEnergyLevel(energy-5);
        System.out.println("The gorilla threw something and its energy decreased by 5.");
    }

    public void eatBananas(int energyLevel){
        int energy = this.energyLevel;
        this.setEnergyLevel(energy+10);
        System.out.println("The gorilla ate some bananas and increased its energy by 10!");
    }
    
    public void climb(int energyLevel){
        int energy = this.energyLevel;
        this.setEnergyLevel(energy - 10);
        System.out.println("After climbing a tree the gorilla's energy decreased by 10.");
    }

}   
