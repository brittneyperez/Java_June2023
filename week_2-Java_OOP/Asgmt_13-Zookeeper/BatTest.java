public class BatTest {
    public static void main(String[] args) {
        
        Bat testBat = new Bat();
        System.out.println("Test Bat's energy level: " + testBat.getEnergyLevel() + ".\n");
        
        testBat.attackTown();
        testBat.attackTown();
        testBat.attackTown();
        System.out.println("Test Bat's energy level: " + testBat.getEnergyLevel() + ".\n");
        
        testBat.eatHumans();
        testBat.eatHumans();
        System.out.println("Test Bat's energy level: " + testBat.getEnergyLevel() + ".\n");
        
        testBat.fly();
        testBat.fly();
        System.out.println("Test Bat's energy level: " + testBat.getEnergyLevel() + ".\n");
    }
}