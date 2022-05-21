public class Borrower {

    private String name;
    private String contact;
    private String email;
    private int credit_score; // TODO

    public Borrower(String name_, String contact_, String email_)
    {
        name=name_;
        contact=contact_;
        email=email_;
    }



    void increase_credit()
    {
        credit_score++;
    }
    int getCredit_score()
    {
        return credit_score;
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

    @Override
    public String toString()
    {
        return "Name: "+name+"\nContact: "+contact+"\nEmail: "+email;
    }
}
