Test on remix

modifier isOwner - checked if the sender if owner and then call the function 
constructor - set the Owner to the sender, could have also used tx.origin
pow - helper function for getCompounInterest. It is a pure function because it does not change or view the state variables. 
getCompoundInterest - pure function for similar reasons.
reqloan - neither pure nor view, coz changes loan mapping
getOwnerBalance- view function since it views balance of owner
viewDues - views loans hences view function
settleDues- changes loan so neither view or pure


