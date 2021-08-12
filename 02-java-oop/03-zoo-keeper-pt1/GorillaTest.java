public class GorillaTest {
    public static void main(String[] args) {
        Gorilla bobo = new Gorilla();
        bobo.displayEnergy();
        bobo.throwSomething(bobo.getEnergyLevel());
        bobo.throwSomething(bobo.getEnergyLevel());
        bobo.throwSomething(bobo.getEnergyLevel());
        bobo.eatBananas(bobo.getEnergyLevel());
        bobo.eatBananas(bobo.getEnergyLevel());
        bobo.climb(bobo.getEnergyLevel());
        bobo.displayEnergy();
    }
    
}
