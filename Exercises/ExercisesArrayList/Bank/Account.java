package ExercisesArrayList.Bank;

public class Account{
    String name;
    String accountNumber;
    String password;
    double balance;
    boolean active = true;

    public Account(String name, String accountNumber, String password, double balance, boolean active){
        this.name= name;
        this.accountNumber= accountNumber;
        this.password= password;
        this.balance= balance;
        this.active = active;
    }
}