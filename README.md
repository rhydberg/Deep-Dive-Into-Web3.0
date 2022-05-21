----------PROJECT DESCRIPTION------------

This is a program designed to act as a nexus for borrowers to borrow and lenders to lender. I have used an OOP approach to this program. I have created classes Borrower and Lender each with its set of basic attributes. All data in these objects are made private and getter functions are implemented accordingly. There is another class called Server which basically acts like a bank/forum connecting borrowers and lenders.  This server contains a ledger which keeps track of who owes who how much. New borrowers and lenders can be registered on the server by giving appropriate details. There are functions I implemented to simulate borrowers requesting sums of money from a lender and borrowers repaying the loan. I implemented a few custom exception classes to simulate real world problems that might be encountered such as the lender not having enough money to lend or borrowers repaying excess money or there being an erroneous repayment that there was no transaction for. 

TODO:
These are some additional features that I would like to implement given more time.
- a credit score for each borrower, which increases every time he repays the money on time. 
- an interest system where the borrowers have to repay more than what they borrowed. 
- 
