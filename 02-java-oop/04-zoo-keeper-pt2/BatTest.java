public class BatTest {
    public static void main(String[] args) {
        Bat vamp = new Bat();
        vamp.displayEnergy();
        vamp.attackTown(vamp.getEnergyLevel());
        vamp.attackTown(vamp.getEnergyLevel());
        vamp.attackTown(vamp.getEnergyLevel());
        vamp.eatHumans(vamp.getEnergyLevel());
        vamp.eatHumans(vamp.getEnergyLevel());
        vamp.fly(vamp.getEnergyLevel());
        vamp.displayEnergy();

    }
    
}
