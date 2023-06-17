import java.text.DecimalFormat;

public class BankAccount {
    
    //* CLASS ATTRIBUTES
    // Todo: Users should not be able to set any of the attributes from the class. √
    // This means to make them "private".
    private double checkingBalance;
    private double savingsBalance;
    
    //* CLASS MEMBER VARIABLES - static
    public static int numberOfAccounts;
    public static double totalAmountOfMoney;
    
    
    //* CONSTRUCTOR
    // Todo: In the constructor, be sure to increment the account count.
    public BankAccount() { //? Upon creating of BankAccount, default values = 0
        BankAccount.numberOfAccounts += 1;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
    }
    
    //* GETTERS & SETTERS
    //? Getter methods for the user's checking and savings account balance.
    public String getCheckingBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(this.checkingBalance);
    }
    public String getSavingsBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(this.savingsBalance);
    }
    
    //* METHODS
    // Todo: Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    public void depositCheck( double amountDeposited, String accountName ) {
        if( accountName == "checking" ) {
            this.checkingBalance += amountDeposited;
            System.out.printf("You deposited $%.2f to your %s account.\n", amountDeposited, accountName);
        } else {
            this.savingsBalance += amountDeposited;
            System.out.printf("You deposited $%.2f to your %s account.\n", amountDeposited, accountName);
        }
        BankAccount.totalAmountOfMoney += amountDeposited;
    }
    // Todo: Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    private boolean hasSufficientFunds( double amount, String accountName ) {
        if(accountName.equals("checking")) { //? Check if there's an account obj called "checking"
            return amount <= this.checkingBalance;
        } else {
            return amount <= this.savingsBalance;
        }
    }
    
    public void withdraw( double amountWithdrawed, String accountName ) {
        if( !hasSufficientFunds(amountWithdrawed, accountName) ) {
            System.out.println("Insufficient Funds!");
            return;
        }
        if(accountName.equals("checking")) {
            this.checkingBalance -= amountWithdrawed;
            System.out.printf("You withdrawed $%.2f from your %s account.\n", amountWithdrawed, accountName);
        } else {
            this.savingsBalance -= amountWithdrawed;
            System.out.printf("You withdrawed $%.2f from your %s account.\n", amountWithdrawed, accountName);
        }
        BankAccount.totalAmountOfMoney -= amountWithdrawed;
    }
    
    // Checks the total money from the checking and saving. √
    public void checkBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println("Total Balance: $" + decimalFormat.format(totalAmountOfMoney) + "\n");
    }
}
