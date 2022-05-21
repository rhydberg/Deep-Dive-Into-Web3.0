public class Driver
{
    public static void main(String[] args) throws NotEnoughFundsException, RepayingMoreThanBorrowedException, NoSuchTransactionException {
        Server bank = new Server();
        Borrower Hugh_Jass,Dixie_Normus,Gabe_Itch;
        Lender Jenna_Tells, Ben_Dover;
        Hugh_Jass=new Borrower("Hugh Jass", "1771", "hughjasshughjerteets@snt.com");
        Dixie_Normus=new Borrower("Dixie Normus", "80085", "mumu@snt.com");
        Gabe_Itch=new Borrower("Gabe Itch", "69420", "normiegg@snt.com");
        Jenna_Tells=new Lender("Jenna Tells", "42069", "barrymckockiner@peeclub.com", 6.9);
        Ben_Dover=new Lender("Ben Dover", "666", "littlekidlover@peeclub.com", 4.2);

        Jenna_Tells.addFunds(1000);
        Ben_Dover.addFunds(100);

        bank.registerBorrower(Hugh_Jass);
        bank.registerBorrower(Dixie_Normus);
        bank.registerBorrower(Gabe_Itch);
        bank.registerLender(Jenna_Tells);
        bank.registerLender(Ben_Dover);

        bank.printBorrowers();
        bank.printLenders();
        System.out.println("----------------------------");
        System.out.println("Hugh Jass borrows 500 from Jenna Tells");
        bank.withdraw(Hugh_Jass, Jenna_Tells, 500);
        System.out.println("Dixie Normus borrows 200 from Jenna Tells");
        bank.withdraw(Dixie_Normus,Jenna_Tells,200);
        System.out.println("Dixie Normus borrows 50 from Ben Dover");
        bank.withdraw(Dixie_Normus,Ben_Dover,50);
        System.out.println("Gabe Itch borrows 20 from Ben Dover");
        bank.withdraw(Gabe_Itch,Ben_Dover,20);
        System.out.println("----------------------------");

        bank.printLedger();
        System.out.println("----------------------------");

        bank.repay(Hugh_Jass,Jenna_Tells,500);
        System.out.println("Hugh Jass repays 500 to Jenna Tells");
        bank.repay(Dixie_Normus,Jenna_Tells,200);
        System.out.println("Dixie Normus repays 200 to Jenna Tells");
        System.out.println("----------------------------");

        bank.printLedger();



    }
}
