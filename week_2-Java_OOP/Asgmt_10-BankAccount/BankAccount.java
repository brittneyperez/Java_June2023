public class BankAccount {
    
    // * CLASS ATTRIBUTES
    private double checkingBalance;
    private double savingsBalance;
    
    // * CLASS MEMBER VARIABLES - static
    public static int numberOfAccounts;
    // public double totalAmountOfMoney;
    public static double totalAmountOfMoney;
    
    
    // * CONSTRUCTOR
    // Todo: In the constructor, be sure to increment the account count.
    public BankAccount() { //? Upon creating of BankAccount, default values = 0
        BankAccount.numberOfAccounts += 1;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
    }
    
    // * GETTERS * SETTERS
    // Getter method for the user's checking account balance.
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    // Getter method for the user's saving account balance.
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    
    // Todo: Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    public void depositCheck( double amountDeposited, String accountName ) {
        if( accountName == "checking" ) {
            this.checkingBalance += amountDeposited;
        } else {
            this.savingsBalance += amountDeposited;
        }
        this.totalAmountOfMoney += amountDeposited;
    }
    // Todo: Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public void withdraw( double amountWithdrawed, String accountName ) {
        if( accountName == "checking" ) {
            //! Warn user that there is insufficient balance
            if( amountWithdrawed > this.checkingBalance ) {
                System.out.println("Insufficient Funds!");
                return;
            }
            this.checkingBalance -= amountWithdrawed;
        } else {
            if( amountWithdrawed > this.savingsBalance ) {
                System.out.println("Insufficient Funds!");
                return;
            }
            this.savingsBalance -= amountWithdrawed;
        }
        this.totalAmountOfMoney -= amountWithdrawed;
    }
    // Todo: Create a method to see the total money from the checking and saving.
    // Todo: Users should not be able to set any of the attributes from the class.
    
    
    
    
    
    // Todo: depositCheck()
    // Todo: checkBalance()
    // Todo: withdraw()
}
