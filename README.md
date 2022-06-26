**PROJECT DESCRIPTION**

This is a program designed to act as a nexus for borrowers to borrow and lenders to lender. I have used an OOP approach to this program. I have created classes Borrower and Lender each with its set of basic attributes. All data in these objects are made private and getter functions are implemented accordingly. There is another class called Server which basically acts like a bank/forum connecting borrowers and lenders.  This server contains a ledger which keeps track of who owes who how much. New borrowers and lenders can be registered on the server by giving appropriate details. There are functions I implemented to simulate borrowers requesting sums of money from a lender and borrowers repaying the loan. I implemented a few custom exception classes to simulate real world problems that might be encountered such as the lender not having enough money to lend or borrowers repaying excess money or there being an erroneous repayment that there was no transaction for.  Finally there is a Driver class containing main which is meant to demonstrate the working of the project with some sample data.

TODO:

These are some additional features that I would like to implement given more time.
- a credit score for each borrower, which increases every time he repays the money on time. 
- an interest system where the borrowers have to repay more than what they borrowed. 

The above could be implemented by adding a time parameter to every transaction. However for the sake of simplicity and sleep I have not gone into those. (Also I was unsure of how to deal with the interest when partial loans are repayed, which is something that my program allows for)

**USER INSTRUCTIONS**

All code is stored in the src folder. Download the code and run the main method in the Driver class. I have included some sample data (hardcoded) for the sake of illustration. I have also uploaded an image of the output on that data on this repo.

----------------------------------------------

**Is the loaning system that you implemented centralized or decentralized? Point out the demerit(s) of a centralized system.**

The loaning system I have implemeted is centralized since it depends on a single all-powerful entity (here an instance of Server) to handle all the transactions. All the data flows through it and functioning of all the transactions depend solely on it. 

The demerits of such a system are manyfold. 
- the system is dependant on a single entity which might act as a failure point or a bottleneck.
- there might be a human element of mistrust, corruption etc. If this program actually gets deployed I could easily tweak the RepayingMoreThanBorrowedException to act in the favour of my non-existent girlfriend (hmm yes i am a programmer).
- the rules of the game may not be well codified and may be very inflexible to change and evolution since there is only a single body in charge.





Test on remix

modifier isOwner - checked if the sender if owner and then call the function 
constructor - set the Owner to the sender, could have also used tx.origin
pow - helper function for getCompounInterest. It is a pure function because it does not change or view the state variables. 
getCompoundInterest - pure function for similar reasons.
reqloan - neither pure nor view, coz changes loan mapping
getOwnerBalance- view function since it views balance of owner
viewDues - views loans hences view function
settleDues- changes loan so neither view or pure


