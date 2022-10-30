# Test Cases : Input and Output
This file contains the input and output the code generates. The content under each heading is the screen of the console after the required input.

## I/O 1 : Successful login
--------Welcome to ATM!!!--------

Enter account number: 

12345

PIN number: 

54321


Main Menu


1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.


 enter a choice
 
 
 ## I/O 2 : Unsuccessful login and Pin tries Exhausted
 --------Welcome to ATM!!!--------
 
Enter account number: 

12345

PIN number: 

12345

Invalid PIN enter again : 

23456

Invalid PIN enter again : 

34567

Invalid account number or PIN. Please try again.


--------Welcome to ATM!!!--------

Enter account number: 

12345

PIN number: 

12345

Account locked due to multiple wrong PIN attempts. Please contact bank officials.

Invalid account number or PIN. Please try again.


## I/O 3 : Check Balance
--------Welcome to ATM!!!--------

Enter account number: 

23456

PIN number: 

65432


Main Menu


1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.


 enter a choice
 
1

Account information


Balance available:

50000.0



Total balance:

50000.0


## I/O 4 : Withdrawal
--------Welcome to ATM!!!--------

Enter account number:

23456

PIN number: 

65432


Main Menu


1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.


 enter a choice
 
2

Max Limit: Rs. 50,000.

Enter amount to withdraw:

12350

Please collect your cash from the dispenser :

Total amount = 12350

Total Note count : 8

6x Two thousands.

1x Two Hundreds.

1x One Hundreds.

1x Fifties.

Main Menu

1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
1

Account information

Balance available:

37650.0

Total balance:

37650.0

## I/O 4 : Deposit
Main Menu

1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
3

 Enter the deposit amount in Rupees [option 0 cancels]: 
 
12000

 Insert the envelope with the money
 
12000.0

.

 Your envelope has been received. \nNOTE: Money will be deposited as soon as possible.First we will have to check the envelope.
 
 ## I/O 5 : Change PIN and re-login
  
 --------Welcome to ATM!!!--------
 
Enter account number: 

12345

PIN number: 

54321

Main Menu

1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
4

Enter NEW PIN :

12345

Confirm NEW PIN :

12345

PIN changed successfully!!

Main Menu

1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
5

exiting the system...


Thank You for using ATM.

--------Welcome to ATM!!!--------

Enter account number: 

12345

PIN number: 

12345

Main Menu

1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
 ## I/O 5 : Logout
 --------Welcome to ATM!!!--------
 
Enter account number: 

12345

PIN number: 

12345


Main Menu


1 - View Balance.

2 - Withdraw.

3 - Deposit

4 - Change PIN.

5 - Logout.

 enter a choice
 
5

exiting the system...



Thank You for using ATM.

