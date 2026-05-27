package PersistenceAndOOP.ImprovedLibrary;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class UserSystem {
    private ArrayList<User> users = new ArrayList<>();
    private User actualUser = null;

    public User getActualUser(){
        return actualUser;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void saveUsers(){

        try {
            FileWriter writer = new FileWriter("Users.csv");
            for(User user : users){
                writer.write(user.exportUserData() + "\n");
            }
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadUsers(){
        try {
            Scanner scanner = new Scanner(new File("Users.csv"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length < 3) continue;
                String id = parts[0];
                String password = parts[1];
                boolean active = Boolean.parseBoolean(parts[2]);
                boolean admin = Boolean.parseBoolean(parts[3]);
                users.add(new User(id, password, admin, active));
            }
            scanner.close();
        } catch (IOException e){
            System.out.println("No save file found");
        }
    }


    private User findUser(String id){
        for(User user : users){
            if (user.getIdNumber().equals(id)){
                return user;
            }
        }
        return null;
    }


    private static void errorInfo(){
        System.out.println("Be sure to fulfill the blanks properly!");
    }

    private static void loginError(){
        System.out.println("We found an error trying to login to your account, be sure that account does exists and each blank is fulfill properly");
    }

    public void createUser(String idNumber, String password, boolean admin, boolean active){
        if (!idNumber.isBlank() && !password.isBlank()){
            if (findUser(idNumber)==null) {
                users.add(new User(idNumber, password,admin, active));
                System.out.println("User successfully registered");
                saveUsers();
            }else {
                System.out.println("Theres already an user with this id! ");
            }
        }else {
            errorInfo();
        }
    }

    public void logIn(String id,String password){
        if (id.isBlank() || password.isBlank()){
            loginError();
            return;
        }
        User user = findUser(id);
        if (user==null){
            loginError();
            return;
        }
        if (!user.passwordMatch(password) || !user.isActive()){
            loginError();
            return;
        }
        this.actualUser = user;
        System.out.println("Welcome user " + actualUser.getIdNumber());
    }

    public void logOut(){
        if (actualUser == null){
            System.out.println("There's already no account logged");
            return;
        }
        actualUser=null;
    }

    public void changeActualUserPassword(String newpassword){
        if (actualUser == null || newpassword.isBlank()){
            errorInfo();
            return;
        }
        actualUser.changePassword(newpassword);
        saveUsers();

    }

    public void deactivateAccount(){
        if ( actualUser == null|| !actualUser.isActive()){
            errorInfo();
            return;
        }
        actualUser.deactivate();
        saveUsers();
    }
}
