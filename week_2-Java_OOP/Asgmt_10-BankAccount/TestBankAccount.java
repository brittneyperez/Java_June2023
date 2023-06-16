public class TestBankAccount {
    
    public static void main(String[] args) {
        
        BankAccount testBankAccount = new BankAccount(); // Instance pf Class
        
        //* APP SIMULATOR
        testBankAccount.depositCheck(360, "checking");
        testBankAccount.depositCheck(200, "savings");
        System.out.println("Test Checking Balance: $" + testBankAccount.getCheckingBalance());
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
        System.out.println("Total Balance: $" + testBankAccount.totalAmountOfMoney + "\n");
        
        testBankAccount.withdraw(90, "checking");
        testBankAccount.withdraw(25, "savings");
        // System.out.println("Test Checking Balance: $" + testBankAccount.getCheckingBalance());
        // System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
        // System.out.println("Total Balance: $" + testBankAccount.totalAmountOfMoney);
        
        testBankAccount.withdraw(200, "savings");
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
    }
}
