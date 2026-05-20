package classes;

import java.util.Scanner;

public class Contacts {
    String name;
    String number;

    public Contacts(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void printContacts(){
        System.out.println(name+" - "+number);
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Contacts murilo = new Contacts("murilo","123");
        Contacts zeca = new Contacts("zeca","122");
        Contacts miguel = new Contacts("miguel","ohara");
        murilo.printContacts();
        miguel.printContacts();
    }
}