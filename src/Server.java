import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Server {

    private LinkedList<Lender> lenders;
    private LinkedList<Borrower> borrowers;

    private HashMap<Pair<Borrower,Lender>, Integer> ledger; // ledger stores the list of all unpaid dues

    public Server()
    {
        lenders= new LinkedList<>();
        borrowers= new LinkedList<>();
        ledger = new HashMap<>();
    }

    void registerLender(Lender l)
    {
        lenders.add(l);
    }
    void registerBorrower(Borrower b)
    {
        borrowers.add(b);
    }

    void withdraw (Borrower b, Lender l, int amount) throws NotEnoughFundsException
    {
        Pair p =new Pair(b,l);
        if(amount>l.getFunds()) //asking to borrow money that lender does not have funds for
        {
            throw new NotEnoughFundsException(l.getName()+" does not have enough money to lend "+b.getName());
        }
        if (ledger.containsKey(p)) // previous transaction has already been made
        {
            ledger.put(p, amount+ledger.get(p));
        }
        else
        {
            ledger.put(p, amount);
        }
    }

    void repay(Borrower b, Lender l, int amount) throws RepayingMoreThanBorrowedException, NoSuchTransactionException
    {
        Pair p = new Pair(b,l);
        if (ledger.containsKey(p))
        {
            if (amount>ledger.get(p)) // repaying more than what was borrowed. We shall not reward philanthropy.
            {
                throw new RepayingMoreThanBorrowedException(b.getName()+" is attempting to repay "+l.getName()+" more than the amount borrowed");
            }

            if (amount == ledger.get(p)) // full debt cleared
            {
                ledger.remove(p);
            }
            else
            {
                ledger.put(p, ledger.get(p) - amount);
            }

        }
        else // borrower did not borrow money yet attempting to pay. Again maintaining strict capitalistic standards.
        {
            throw new NoSuchTransactionException(l.getName()+" did not lend " + b.getName()+" any money");
        }
    }

    void printBorrowers()
    {
        for(Borrower b:borrowers)
        {
            System.out.println(b+"\n");
        }
    }

    void printLenders()
    {
        for(Lender l:lenders)
        {
            System.out.println(l+"\n");
        }
    }

    void printLedger()
    {
        Iterator it=ledger.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry element = (Map.Entry)it.next();
            Pair k = (Pair)element.getKey();
            int v = (Integer)element.getValue();
            Borrower b = (Borrower) k.getLeft();
            Lender l = (Lender) k.getRight();
            System.out.println(b.getName()+" owes "+l.getName()+ " "+v);
        }
    }

}

class Pair<L,R>  //creating my own pair class since unfortunately Java does not have Pair inbuilt
{
    private L left;
    private R right;
    public Pair(L left_, R right_)
    {
        left=left_;
        right=right_;
    }

    public L getLeft()
    {
        return left;
    }
    public R getRight()
    {
        return right;
    }

    @Override
    public String toString()
    {
        return left.toString()+" "+right.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft()) &&
                this.right.equals(pairo.getRight());
    }
    @Override
    public int hashCode() //
    {
        String s = left.toString()+right.toString();
        int hash=0;
        for(char c:s.toCharArray())
        {
            hash+=(int)c;
            hash%=723293422;
        }
        return hash;
    }
}

class NotEnoughFundsException extends Exception
{
    public NotEnoughFundsException(String msg)
    {
        super(msg);
    }

}

class NoSuchTransactionException extends Exception
{
    public NoSuchTransactionException(String msg)
    {
        super(msg);
    }
}

class RepayingMoreThanBorrowedException extends Exception
{
    public RepayingMoreThanBorrowedException(String msg)
    {
        super (msg);
    }
}