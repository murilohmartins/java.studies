package classes;

import java.util.Scanner;

public class Profiles{
    String name;
    String number;
    int id = 0;
    Profiles[] profiles = new Profiles[100];

    public Profiles(String name, String number){
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public void registerProfile(String name,String number){
        profiles[id] = new Profiles(name,number);
        id++;
        System.out.println("User successfully registered ");
    }

    public void printAllProfiles(){
        for( int i = 0; i<id; i++){
        System.out.println(profiles[i].name+" - "+profiles[i].number);
    }
    }

    public void findUser(String name){
        boolean exists = false;
        String userNumber= "";
        for(int i= 0; i< profiles.length;i++){
            if (profiles[i].name.equals(name)){
                exists = true;
                userNumber = profiles[i].number;
                break;
            }
        }
        if (exists){
            System.out.println("User "+name+" sucefully found! his nummber is "+userNumber);

        }else{
            System.out.println("Unfortenelly we couldnt find this specific user");
        }
    }

    public void countUsers(){
        System.out.println("theres currently "+id+" profiles registered");
    }

    public static void main(String[] args){
        Profiles system = new Profiles("", "");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Choose 1 for register a profile, 2 to see all profiles, 3 to find a profile by name, 4 to see how profiles do exist, anything else to exit");
            String choice = scanner.nextLine();
            if (choice.equals("1")){
                System.out.print("what is the name of the profile you want to create? ");
                String name= scanner.nextLine().trim();
                System.out.print("Which number you want to tie to this name? ");
                String number= scanner.nextLine().trim();
                system.registerProfile(name,number);
            } else if (choice.equals("2")){
                system.printAllProfiles();
            } else if(choice.equals("3")){
                System.out.print("Which name you want to try find a profile tied to it? ");
                String name= scanner.nextLine().trim();
                system.findUser(name);
            } else if(choice.equals("4")){
                system.countUsers();
            } else{
                System.out.print("Seeya");
                break;
            }

        }
    }
}