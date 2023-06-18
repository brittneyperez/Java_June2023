public class GorillaTest {
    public static void main(String[] args) {
        
        Gorilla testGorilla = new Gorilla(100);
        System.out.println("Test Gorilla's energy level: " + testGorilla.getEnergyLevel() + ".\n");
        
        testGorilla.throwSomething();
        testGorilla.throwSomething();
        testGorilla.throwSomething();
        System.out.println("Test Gorilla's energy level: " + testGorilla.getEnergyLevel() + ".\n");
        
        testGorilla.eatBananas();
        testGorilla.eatBananas();
        System.out.println("Test Gorilla's energy level: " + testGorilla.getEnergyLevel() + ".\n");
        
        testGorilla.climb();
        System.out.println("Test Gorilla's energy level: " + testGorilla.getEnergyLevel() + ".\n");
    }
}