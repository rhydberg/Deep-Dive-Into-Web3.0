// SPDX-License-Identifier: MIT
pragma solidity >=0.4.25 <0.7.0;

contract MetaCoin {
	mapping (address => uint256) balances;

	event Transfer(address indexed _from, address indexed _to, uint256 _value);

	constructor() public {
		balances[tx.origin] = 100000;
	}

	function sendCoin(address receiver, uint256 amount, address sender) public returns(bool sufficient) {
		if (balances[sender] < amount) return false;
		balances[sender] -= amount;
		balances[receiver] += amount;
		emit Transfer(sender, receiver, amount);
		return true;
	}


	function getBalance(address addr) public view returns(uint256) {
		return balances[addr];
	}
}


contract Loan is MetaCoin {
    mapping (address => uint256) private loans;
     
    event Request(address indexed _from, uint256 P, uint R, uint T, uint256 amt);
    
    address private Owner;
    
    modifier isOwner() {
        require(msg.sender == Owner);
        _;
    }
    
    constructor() public {
        Owner=msg.sender; 
    }
    
   
    function pow (uint x, uint n)
    public pure returns (uint r) {
    r = 1.0;
    while (n > 0) {
        if (n % 2 == 1) {
        r *= x;
        n -= 1;
        } else {
        x *= x;
        n /= 2;
        }
    }
    }
    function getCompoundInterest(uint256 principle, uint rate, uint time) public pure returns(uint256) {
    return principle * pow (1 + rate, time);        
    }
    
    function reqLoan(uint256 principle, uint rate, uint time) public returns(bool correct) {
        uint256 toPay = getCompoundInterest(principle, rate, time);

        loans[msg.sender]=toPay;
        if(toPay>=principle)
        {
            emit Request(msg.sender, principle, rate, time, toPay);
            return true;
        }
              
        return false;

    }
    
    function getOwnerBalance() public view returns(uint256) {
        return getBalance(Owner);
		}
    
    function viewDues(address cred) private view isOwner returns (uint256)
    {
        return loans[cred];
    }
    function settleDues(address cred) private isOwner returns (bool)
    {
        if(getOwnerBalance()>=loans[cred])
        {
            loans[cred]=0;
            return true;
        }
        return false;
    }    
}