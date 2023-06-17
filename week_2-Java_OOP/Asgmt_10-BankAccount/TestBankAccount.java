public class TestBankAccount {
    
    public static void main(String[] args) {
        
        BankAccount testBankAccount = new BankAccount(); // Instance pf Class
        
        //* APP SIMULATOR
        testBankAccount.depositCheck(360, "checking");
        testBankAccount.depositCheck(200, "savings");
        System.out.println("Test Checking Balance: $" + testBankAccount.getCheckingBalance());
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
        testBankAccount.checkBalance();
        /* Long-Hand Version
            Without this method, it'll be written as...
            System.out.println("Total Balance: $" + testBankAccount.totalAmountOfMoney + "\n");
        */
        
        testBankAccount.withdraw(90, "checking");
        testBankAccount.withdraw(25, "savings");
        // System.out.println("Test Checking Balance: $" + testBankAccount.getCheckingBalance());
        // System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
        
        // System.out.println("Total Balance: $" + testBankAccount.totalAmountOfMoney);
        //? the above line would work if I used this.totalAmountOfMoney in the deposit/withdraw methods
        
        testBankAccount.withdraw(200, "savings");
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance());
        
        // Check total money from the checking and savings:
        testBankAccount.checkBalance();
    }
}
