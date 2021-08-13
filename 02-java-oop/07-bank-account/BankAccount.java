public class BankAccount {
    private Double checkingBalance;
    private Double savingsBalance;
    public static int numberOfAccounts = 0;
    public static Double totalMoney = 0.00;


    //Constructor
    public BankAccount(Double checkingBalance, Double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        totalMoney += checkingBalance + savingsBalance;
    }
    //Getters
    public Double getCheckingBalance(){
        return checkingBalance;
    }
    public Double getSavingsBalance(){
        return savingsBalance;
    }
    //Setters
    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    //Methods

    public void deposit(String rout, double deposit){
        if(rout == "Checking"){
            this.setCheckingBalance(this.getCheckingBalance()+deposit);
            totalMoney+=deposit;
        }  else if(rout == "Savings") {
            this.setSavingsBalance(this.getSavingsBalance()+deposit);
            totalMoney+=deposit;
        }
    }

    public void withdraw(String rout, double amount){
        
        if(rout == "Checking"){
            if(this.getCheckingBalance()-amount<0.00){
                System.out.println("Insufficient Funds");
            } else {
                this.setCheckingBalance(this.getCheckingBalance()-amount);
                totalMoney -= amount;
            }
        }  else if(rout == "Savings") {
            if(this.getSavingsBalance()-amount<0.00){
                System.out.println("Insufficient Funds");
            } else{
                this.setSavingsBalance(this.getSavingsBalance()-amount);
                totalMoney -= amount;
            }
        }
    }

    public void displayAccounts(){
        System.out.println("Checking Balance: " + this.getCheckingBalance());
        System.out.println("Savings Balance: " +this.getSavingsBalance());
    }

    public double totalMoney(){
        return totalMoney;
    }

    public int numberOfAccounts(){
        return numberOfAccounts;
    }
}