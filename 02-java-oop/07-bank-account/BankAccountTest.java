public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(100.00, 100.00);
        System.out.println("");
        account1.displayAccounts();
        System.out.println("");
        account1.deposit("Checking", 50.00);
        System.out.println("Checking Balance = " + account1.getCheckingBalance());
        System.out.println("");
        account1.withdraw("Checking", 25.00);
        System.out.println("Checking Balance = " + account1.getCheckingBalance());
        System.out.println("");
        account1.deposit("Savings", 25.00);
        System.out.println("Savings Balance = " + account1.getSavingsBalance());
        System.out.println("");
        account1.withdraw("Savings", 75.00);
        System.out.println("Savings Balance = " + account1.getSavingsBalance());
        System.out.println("");
        account1.displayAccounts();
        System.out.println("");
        System.out.println("Total Money in Account(s) = " + account1.totalMoney());
        System.out.println("");
        System.out.println("Total Number of Accounts = " + account1.numberOfAccounts());
        BankAccount account2 = new BankAccount(50.00, 50.00);
        System.out.println("***New Account Created***");
        System.out.println("Total Number of Accounts = " + account2.numberOfAccounts());
        System.out.println("");
        account2.withdraw("Checking", 75.00);
        account2.withdraw("Savings", 75.00);



    }
    
}
