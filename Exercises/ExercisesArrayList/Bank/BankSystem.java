package ExercisesArrayList.Bank;

import java.util.ArrayList;

public class BankSystem {
    ArrayList<Account> account = new ArrayList<>();
    Account actualAccount = null;

    public void addAccount(String name, String userNumber, String password, Double balance) {
        boolean found = false;
        if (balance>=0) {
            for (Account accounts: account){
                if (accounts.accountNumber.equals(userNumber)){
                    found=true;
                    break;
                }
            } if (!found) {
                account.add(new Account(name, userNumber, password, balance, true));
            } else {
                System.out.println("Theres already an account with this number tied to it");
            }
        } else {
            System.out.println("Be sure to fill properly the blanks");
        }
    }

    public void login(String name, String userNumber, String password) {
        boolean found = false;
        for (Account accounts : account) {
            if (accounts.name.equals(name) && accounts.accountNumber.equals(userNumber) && accounts.password.equals(password) && accounts.active) {
                this.actualAccount = accounts;
                found = true;
                System.out.println("Login successfully made! Welcome " + accounts.name);
                break;
            }
        }
        if (!found) {
            System.out.println("We couldnt perform login successfully");
        }
    }

    public void logout() {
        this.actualAccount = null;
        System.out.println("Logout successfully made");

    }

    public void withdraw(double amount) {
        if (amount>=0) {
            if (actualAccount != null && actualAccount.active) {
                if (actualAccount.balance >= amount) {
                    actualAccount.balance -= amount;
                    System.out.println("Withdraw successfully made! Current amount: " + amount);
                    System.out.println("Current amount on account: " + actualAccount.balance);
                } else {
                    System.out.println("Unfortunately isnt possible to withdraw this amount, since is current balance is: " + actualAccount.balance);
                }
            } else {
                System.out.println("Be sure to first be logged to manage money from an account");
            }
        }else {
            System.out.println("Be sure to retire an positive value");
        }
    }

    public void deposit(double amount) {
        if (amount>0)
            if (actualAccount != null && actualAccount.active) {
                actualAccount.balance += amount;
                System.out.println("Deposit successfully made! Current amount: "+actualAccount.balance);
            } else {
                System.out.println("Be sure to first be logged to manage money from an account");
            }
        else{
            System.out.println("Be sure to deposit an positive amount");
        }
    }

    public void transfer(String accountnumber, double amount){
        boolean found= false;
        if (amount>0) {
            if (actualAccount != null && actualAccount.active) {
                for (Account accounts : account) {
                    if (accounts.accountNumber.equals(accountnumber) && !accounts.accountNumber.equals(actualAccount.accountNumber) && accounts.active) {
                        found = true;
                        if (actualAccount.balance >= amount) {
                            actualAccount.balance -= amount;
                            accounts.balance += amount;
                            System.out.println("Transference successfully made! Current amount: " + actualAccount.balance);
                            break;
                        } else {
                            System.out.println("Unfortunately isnt possible to make this transference since your current amount is: " + actualAccount.balance);
                            break;
                        }
                    }
                }
                if (!found) {
                    System.out.println("We couldnt find an active account that matches this account number");
                }
            }
        } else {
            System.out.println("Be sure to try to transfer a positive amount");
        }
    }

    public void findUser(String userNumber){
        boolean found = false;
        for(Account accounts: account){
            if (accounts.accountNumber.equals(userNumber)){
                found= true;
                System.out.println("User successfully found! Account owner name: "+accounts.name);
                if (accounts.active){
                    System.out.println("This account is currently active!");
                } else {
                    System.out.println("This account is currently inactive");
                }
                break;
            }
        } if (!found){
            System.out.println("Unfortunately we coudlnt find an account that matches this user number");
        }
    }

    public void printAllUsers(){
        boolean empty = true;
        for (Account accounts: account){
            empty = false;
            System.out.println("Owner name: "+accounts.name+", account number: "+accounts.accountNumber);
        } if (empty){
            System.out.println("Theres no users currently registered");
        }
    }

    public void printAllUsersActive(){
        boolean empty = true;
        for (Account accounts: account){
            if (accounts.active){
                empty = false;
                System.out.println("Owner name: "+accounts.name+", account number: "+accounts.accountNumber);
            }
        } if (empty){
            System.out.println("Theres no users currently active");
        }
    }

    public void deactivateAccount(){
        if (actualAccount !=  null && actualAccount.balance ==0) {
            if (actualAccount.active) {
                actualAccount.active = false;
                this.actualAccount = null;
                System.out.println("Successfully deactivated");
            }
        } else {
            System.out.println("Be sure to not try to deactivate an account with a positive amount");
        }
    }

    public void currentBalance(){
        if (actualAccount != null && actualAccount.active){
            System.out.println("Actual amount is :"+actualAccount.balance);
        }
    }
}