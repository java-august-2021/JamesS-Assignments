public class Bat extends Mammal {
    public Bat(){
        super(300);
    }

    public void fly(int energyLevel){
        int energy = this.energyLevel;
        this.setEnergyLevel(energy-50);
        System.out.println("The bat took flight and decreased its energy by 50.");
    }

    public void eatHumans(int energyLevel){
        int energy  = this.energyLevel;
        this.setEnergyLevel(energy+25);
        System.out.println("The bat has increased its energy by 25 after eating a human.");
    }

    public void attackTown(int energyLevel){
        int energy = this.energyLevel;
        this.setEnergyLevel(energy-100);
        System.out.println("The bat attacked a town and decreased its energy by 100!");
    }
}
