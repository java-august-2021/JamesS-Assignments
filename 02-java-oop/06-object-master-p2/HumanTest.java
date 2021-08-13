import java.util.ArrayList;
public class HumanTest {
    public static void main(String[] args) {
        Ninja nancy = new Ninja("Nancy");
        Wizard will = new Wizard("Will");
        Samurai sam = new Samurai("Sam");
        Samurai sal = new Samurai("Sal");
        
        ArrayList<Human> humans = new ArrayList<Human>();
        humans.add(nancy);
        humans.add(will);
        humans.add(sam);
        humans.add(sal);

        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");

        
        
        will.fireball(nancy);
        will.fireball(sam);
        System.out.println("*** Will Fireballed Sam and Nancy and takes decreases health by 24 ***");
        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");
        
        
        
        nancy.steal(will);
        System.out.println("*** Nancy Steals Will's health (10) and adds it to hers ***");   
        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");

        
        
        will.heal(sam);
        System.out.println("*** Will heals Sam by 8 ***");   

        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");


        nancy.runAway();
        System.out.println("*** Nancy runs away and decreases health by 10 ***");   
        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");



        sam.deathBlow(nancy);
        sam.meditate();
        System.out.println("*** Sam deals a death blow to nancy but also loses half of his health ***");   
        System.out.println("*** Sam meditates and increases his health by half ***");
        for(Human h : humans) {
            System.out.println(h.name + ": Strength = " + h.getStrength() + ", Stealth = " + h.getStealth() + ", Intelligence = " + h.getIntelligence() + ", Health = " + h.getHealth());
        }
        System.out.println("");

        
        System.out.println("Total number of Samurai = " + sal.samuraiCount());   

    }
    
}
