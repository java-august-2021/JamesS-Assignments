class ProjectTest {
    public static void main(String[] args) {
        Project candle = new Project();
        Project wheel = new Project("Wheel");
        Project light = new Project("Lightbulb", "A way to light a room using electricity.");

        System.out.println(candle.elevatorPitch());
        System.out.println(wheel.elevatorPitch());
        System.out.println(light.elevatorPitch());


    }
    
}

