public class HumanTest {
    public static void main(String[] args) {
        Ninja nancy = new Ninja();
        Wizard will = new Wizard();
        Samurai sam = new Samurai();

        nancy.attack(will);
        nancy.attack(sam);
        will.attack(sam);
        
        System.out.println(nancy.getHealth());
        System.out.println(will.getHealth());
        System.out.println(sam.getHealth());

        
    }
    
}
