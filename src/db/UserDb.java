package db;

import enums.Role;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
   private static List<User> users = new ArrayList<>();
    public static List<User> getUsers(){
        return users;
    }
    public static void addUser(User user){
        users.add(user);
    }
    public static boolean deleteQuiz(String name){
        for (User user : users) {
            if(user.getIsm().equalsIgnoreCase(name)){
                users.remove(user);
                return true;
            }
        }
        return false;
    }
    public static Role getAdmin(){
        return Role.ADMIN;
    }
    public static void replaceUser(int i, User user) {
        users.set(i,user);
    }
}
