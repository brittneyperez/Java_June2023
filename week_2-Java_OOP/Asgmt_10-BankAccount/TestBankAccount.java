public class TestBankAccount {
    
    public static void main(String[] args) {
        
        BankAccount testBankAccount = new BankAccount(); // Instance pf Class
        BankAccount myBankAccount = new BankAccount();
        
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
        System.out.println("Test Checking Balance: $" + testBankAccount.getCheckingBalance());
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance() + "\n");
        
        // System.out.println("Total Balance: $" + testBankAccount.totalAmountOfMoney);
        //? the above line would work if I used this.totalAmountOfMoney in the deposit/withdraw methods
        
        testBankAccount.withdraw(200, "savings");
        System.out.println("Test Savings Balance: $" + testBankAccount.getSavingsBalance() + "\n");
        
        // Check total money from the checking and savings:
        testBankAccount.checkBalance();
        
        myBankAccount.depositCheck(250, "checking");
        myBankAccount.depositCheck(50, "checking");
        System.out.println("My Checking Balance: $" + myBankAccount.getCheckingBalance());
        System.out.println("My Savings Balance: $" + myBankAccount.getSavingsBalance());
        myBankAccount.depositCheck(1000, "savings");
        myBankAccount.withdraw(175, "savings");
        System.out.println("My Savings Balance: $" + myBankAccount.getSavingsBalance());
        myBankAccount.checkBalance();
        
        System.out.println("--- Ninja Bonus: Check Account Number ---");
        long testAccountNumber = testBankAccount.getAccountNumber();
        long myAccountNumber = myBankAccount.getAccountNumber();
        System.out.println("Test Account Num: " + testAccountNumber); // randomly generated with each print
        System.out.println("My Account Num: " + myAccountNumber);
    }
}
