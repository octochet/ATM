
# CASE STUDY 2 : ATM



This project is made entirely on java and utilizes the 
various object oriented programming concepts we have learned 
until now.

This project aims to imitate the working of an ATM 
as much as possible. 

The ATM consists of funcionalities like withdrawal, 
deposit and changing pin.

It also includes use of access specifiers for security of 
information.







## FEATURES

The ATM consists of the following features:
- Withdrawal
- Deposit
- Check Balance / Transactions
- Change PIN


## CODE

The code is split into various different classes. 
A list is given below :

| S.No. | Class |
|:-----:|:-----------:|
|     01|      [MAIN](#main)     |
|     02|      [ATM](#atm)      |
|     03|    [ACCOUNT](#account)    |
|     04| [BANK DATABASE](#bankdatabase) |
|     05|  [TRANSACTION](#transaction)  |
|     06|   [WITHDRAWAL](#withdrawal)  |
|     07| [CASH DISPENSER](#cashdispenser)|
|     08|    [DEPOSIT](#deposit)    |
|     09| [DEPOSIT SLOT](#depositslot)  |
|     10|[BALANCE INQUIRY](#balanceinquiry)|
|     11|   [CHANGE PIN](#changepin)  |
|     12|     [KEYPAD](#keypad)    |
|     13|     [SCREEN](#screen)    |

### Main
Contains the Main Driver code which will run the ATM. The 
method used is,
```
ATM MyATM = new ATM();
MyATM.run();
```
### ATM
Contains authentication, main menu and perform transactions methods.
All of this is utilized in the run method which will run the ATM. 

It Authenticates the user credentials, displays the Main Menu, creates a transaction based on the user's choice, performs the transaction.
The methods are listed below ,
```
private void authenticateUser()
private int displayMainMenu()
private Transaction createTransaction(int MainMenuChoice)
private void performTransactions()
public void run()
```
### Account
Contains basic account information such as, account number, pin, balance and 
number of pin tries/fails.

Methods include:
```
public boolean ValidatePin(int userPIN)
public double getBalance()
public int getAccountNumber()
public void credit(double amount)
public void debit(double amount)
public void changePIN(int newPIN)
```
### BankDatabase
Contains information regarding accounts, gets account, authentication and etc.

Methods are:
```
static Account getAccount(int accountNumber)
public boolean authenticateUser(int userAccountNumber, int userPIN)
```

### Transaction
It is an Abstract class which is used for executing different types of transactions.

It will be inherited to different types of transactions listed in main menu
such as deposit and withdrawal.

### Withdrawal
It inherits transaction abstract class and is used for withdrawing money from the ATM.
It has a limit on withdrawal amount and utilizes the cash dispenser to output the required number of denomination
notes.

### CashDispenser
Contains fields for the amount of notes inside the ATM, Has the dispense cash method which
will calculate what currency notes will be required for the withdrawal amount 
and out the number of notes with respective denominations.
It also checks if it has sufficient cash to facilitate a withdrawal or not.
```
public void dispenseCash(int amount)
public boolean isSufficientCashAvailable( int amount)
```
### Deposit
It inherits transaction abstract class and is used for depositing envelopes in the ATM.
It makes use of the deposit slot in the ATM to check if the envelope is recieved or not.

It has the following method to get deposit amount , 
```
private double promptForDepositAmount()
```
### DepositSlot
Checks if envelope is recieved or not.

### BalanceInquiry
Prints the Account information and Balance available in the account. It also inherits the abstract class Transaction.

### ChangePIN 
It extends the abstract class transaction. It asks for a new PIN from the user 
twice for cofirmation and updates it using the update pin method in account. It also has
the cancel feature incase the user wants to not change the PIN.

It contains the method, 
```
private int promptForNewPIN()
```
for getting the new PIN input from keypad.

### Keypad 
It is a utility class to imitate a real ATM's keypad. It takes input in the form of
digits from the user.
```
public int getInput()
```

### Screen
It is also a utility class to imitate a real ATM'S screen. It is used to display messages on the screen
using the method,
```
public void displayMessage(String Message)
public void displayAmount(double amount)
```


## Class Diagram

```mermaid
classDiagram
      Main o-- ATM
      ATM *-- Keypad
      ATM *-- Screen
      ATM *-- DepositSlot
      ATM *-- CashDispenser
      ATM o-- BankDatabase
      Withdrawal o-- Keypad
      Withdrawal o-- CashDispenser
      Deposit o-- DepositSlot
      Deposit o-- Keypad
      ChangePIN o-- Keypad
      Account *-- BankDatabase
      BankDatabase *-- Transaction
      Transaction <|-- Withdrawal
      Transaction <|-- BalanceInquiry
      Transaction <|-- Deposit
      Transaction <|-- ChangePIN
      Transaction o-- Screen
      Transaction : +private int accountNumber
      Transaction : +private Screen screen
      Transaction : +private BankDatabase bankDataBase
      Transaction: +public getAccountNumber()
      Transaction: +getScreen()
      Transaction: +getBankDataBase()
      Transaction: +execute()
      Main: + ATM MyATM
      Main: +main(String args[]) void
      class Withdrawal{
          +private int amount
          +private Keypad keypad
          +private CashDispenser cashDispenser
          +private double availableBalance
          +execute()
      }
      class BalanceInquiry{
          +int accountNumber
          +execute()
      }
      class ChangePIN{
          +private Keypad keypad
          +private int newPIN
          +execute()
          +promptForNewPIN() int
      }
      class Deposit{
          +private double amount
          +private Keypad keypad
          +private DepositSlot depositSlot
          +private final static int CANCELLED = 0
          +execute()
          +promptForDepositAmount() double
      }
      class Account {
          +private final int accountNumber
          +private int pin
          +private double Balance
          +public int PINTries
          +credit(double amount) void
          +debit(double amount) void
          +changePIN(int newPIN) void
      }
      class BankDatabase {
          +private static Account[] accounts
          +getAccount(int accountNumber) Account
          +authenticateUser(int userAccountNumber, int userPIN) boolean
          +getBalance(int userAccountNumber) double
          +credit(int userAccountNumber, double amount) void
          +debit(int userAccountNumber, double amount) void
      }
      class CashDispenser {
          +private static int two_thousands
          +private static int five_hundreds
          +private static int two_hundreds
          +private static int one_hundreds
          +private static int fifty
          +private int transaction_count
          +private static int count
          +dispenseCash(int amount) void
          +isSufficientCashAvailable(int amount) boolean
      }
      class DepositSlot {
          +isEnvelopeReceived() boolean
      }
      class Keypad {
          +private Scanner input
          +getInput() void
      }
      class Screen {
          +displayMessage(String Message) void
          +displayAmount(double amount) void
      }
      class ATM {
          +private boolean Authentication
          +private int currentAccountNumber
          +private Screen screen
          +private Keypad keypad
          +private CashDispenser cashDispenser
          +private BankDatabase bankDatabase
          +private DepositSlot depositSlot
          +private static final int BALANCE_INQUIRY
          +private static final int WITHDRAWAL
          +private static final int DEPOSIT
          +private static final int PIN_CHANGE
          +private static final int EXIT
          +authenticateUser() void
          +displayMainMenu() int 
          +createTransaction(int type) Transaction
          +performTransactions() void
          +run() void          
      }
```

## OOPs Concepts
I have utilized all the OOPs concepts in this project.

### Encapsulation 
- Created classes for most things in an ATM and their respective methods.

### Inheritance 
- Classes such as Withdrawal, Deposit and changePIN inherit the 
Transaction class.

### Abstraction
- Created an abstract class Transaction which contains field and methods common
to all types of transactions.

### Polymorphism
- Screen : displayMessage takes two types of inputs string an double.
- execute method in differet classes.


## Use of Access Specifiers

- Private final Account Number : Since account number is never changed it is final
- Private class Account has Private fields for more privacy.
- Account class has public getter setter.
- Private static final ... :For option types in ATM and Deposit, As they will never change

## Authors

- Chetan Moturi: [@octochet](https://www.github.com/octochet)
- ###### Made by : Chetan Moturi (CS21B017)
