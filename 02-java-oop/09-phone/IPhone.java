public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "IPhone " + this.getVersionNumber() + " says " + this.getRingTone();
    }
    @Override
    public String unlock() {
        return "Unlocked via finger print";
    }
    @Override
    public void displayInfo() {
        System.out.println(String.format("IPhone %s from %s", this.getVersionNumber(), this.getCarrier()));            
    }
}