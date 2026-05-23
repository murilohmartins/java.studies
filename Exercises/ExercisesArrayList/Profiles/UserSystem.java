package ExercisesArrayList.Profiles;

import java.util.ArrayList;

public class UserSystem{

    ArrayList<User> user = new ArrayList<>();

    public void  registerUser(String username,String email,String password,int age){
        boolean exists= false;
        for (User users: user){
            if (users.email.equals(email)){
                exists= true;
                break;
            }
        } if (exists){
            System.out.println("This email is already tied to an existent account");
        } else {
            user.add(new User(username,email,password,age));
            System.out.println("User successfully registered! ");
        }
    }

    public void findUser(String email){
        boolean exists= false;
        for (User users: user){
            if (users.email.equals(email)){
                exists= true;
                break;
            }
        }if(exists){
            System.out.println("User successfully found");
        }else {
            System.out.println("Unfortunately user not found ");
        }

    }

    public void listUsers(){
        System.out.println("List of the users registered by usernames: ");
        for (User users: user){
            System.out.println(users.username);
        }
    }

    public void deleteUser(String email){
        boolean exists = false;
        for(User users: user){
            if (users.email.equals(email)) {
                user.remove(users);
                System.out.println("User successfully deleted");
                exists= true;
                break;
            }
        } if(!exists){
            System.out.println("We couldnt find an user that matches this email");
        }
    }

    public void printInfoOfUser(String email){
        boolean exists = false;
        for(User users: user){
            if (users.email.equals(email)) {
                exists= true;
                System.out.println("Informations of the email:"+email+":");
                System.out.println(users.username);
                System.out.println(users.age);
                System.out.println(users.password);
                break;
            }
        } if(!exists){
            System.out.println("We couldnt find an user that matches this email");
        }
    }

    public void login(String emailOrUsername, String password){
        boolean exists = false;

        for(User users : user){
            if(users.email.equals(emailOrUsername) ||
                    users.username.equals(emailOrUsername)){
                exists = true;
                if(users.password.equals(password)){
                    System.out.println("Login successfully made");
                } else {
                    System.out.println("Wrong password");
                }
                break;
            }
        }if(!exists){
            System.out.println("We couldn't find this user");
        }
    }
}