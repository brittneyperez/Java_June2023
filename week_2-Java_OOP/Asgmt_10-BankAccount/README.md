# BankAccount Class

The `BankAccount` class represents a bank account with checking and savings balances. It provides methods to perform operations such as depositing and withdrawing money, checking balances, and tracking the total amount of money across all accounts.

### Class Attributes

- `checkingBalance`: Represents the balance of the checking account (private).
- `savingsBalance`: Represents the balance of the savings account (private).
- `numberOfAccounts`: Tracks the total number of bank accounts (static).
- `totalAmountOfMoney`: Stores the total amount of money across all accounts (static).

### Constructor

- `BankAccount()`: Initializes a new bank account with default balances of 0 and increments the `numberOfAccounts` count.

### Getter and Setter Methods

- `getCheckingBalance()`: Retrieves the checking account balance formatted as a string.
- `getSavingsBalance()`: Retrieves the savings account balance formatted as a string.

### Methods

- `depositCheck(double amountDeposited, String accountName)`: Deposits the specified amount into the checking or savings account based on the provided account name. Updates the account balance and adds the deposited amount to the `totalAmountOfMoney`.
- `withdraw(double amountWithdrawed, String accountName)`: Withdraws the specified amount from the checking or savings account based on the provided account name. Checks for sufficient funds and updates the account balance. Subtracts the withdrawn amount from the `totalAmountOfMoney`.
- `hasSufficientFunds(double amount, String accountName)`: Private method that checks if there are sufficient funds in the specified account for a withdrawal.
- `checkBalance()`: Displays the total balance across all accounts formatted as a string.

Note: The `DecimalFormat` class is used to format the balance and amounts with two decimal places.