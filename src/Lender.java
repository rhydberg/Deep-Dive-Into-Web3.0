public class Lender {
    private final String name;
    private final String contact;
    private final String email;
    private final double interest_rate; // TODO
    private int funds; //maximum amount of money that a lender can lend to a borrower at a time.

    public Lender(String name_, String contact_, String email_, double interest_rate_)
    {
        name=name_;
        contact=contact_;
        email=email_;
        interest_rate=interest_rate_;
    }


    public void addFunds(int money)
    {
        funds=money;
    }
    public String getName()
    {
        return name;
    }
    public String getContact()
    {
        return contact;
    }
    public String getEmail()
    {
        return email;
    }

    public int getFunds()
    {
        return funds;
    }

    public double getInterest_rate()
    {
        return interest_rate;
    }

    @Override
    public String toString()
    {
        return "Name: "+name+"\nContact: "+contact+"\nEmail: "+email+"\nAvailable Funds: "+funds+"\nRate: "+interest_rate;
    }

}
