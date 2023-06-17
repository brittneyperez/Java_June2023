import java.text.DecimalFormat;
import java.util.Random;

public class BankAccount {
    
    //* CLASS ATTRIBUTES - Users should not be able to set any of the attributes from the class (make them private).
    private double checkingBalance;
    private double savingsBalance;
    private long accountNumber; // 忍者BONUS ①: Add the the following class attribute: `account number`.
    
    //* CLASS MEMBER VARIABLES - static
    public static int numberOfAccounts;
    public static double totalAmountOfMoney;
    
    
    //* CONSTRUCTOR - Increment the account count.
    public BankAccount() { //? Upon creating of BankAccount, default values = 0
        BankAccount.numberOfAccounts += 1;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        // 忍者BONUS ③: In the constructor, call the private method from above so that each user has a random ten digit account.
        this.accountNumber = generateAccountNumber();
    }
    
    //* GETTERS & SETTERS - Getter methods for the user's checking and savings account balance.
    public String getCheckingBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(this.checkingBalance);
    }
    public String getSavingsBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(this.savingsBalance);
    }
    public long getAccountNumber() {
        return this.accountNumber;
    }
    
    //* METHODS
    // Allow a user to deposit money into either the checking or saving, as well as add to total amount stored.
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
    
    // Allow a user to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
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
    
    // Checks the total money from the checking and saving.
    public void checkBalance() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        System.out.println("Total Balance: $" + decimalFormat.format(totalAmountOfMoney) + "\n");
    }
    
    // 忍者Bonus ②: Private method that returns a random 10-digit accountNumber;
    private long generateAccountNumber() {
        /* How to generate a speicific set of numbers?
            long min = 1_000_000_000L; // from the minimum value...
            long max = 9_999_999_999L; // ...to the maximum value...
        We can make an accountNumber using this range of numbers in this format.
         */
        Random random = new Random();
        long newAccountNumber = 1_000_000_000L + random.nextLong(9_000_000_000L);
        return newAccountNumber;
    }
}
