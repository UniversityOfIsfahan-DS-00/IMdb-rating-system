import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String user_name;
    private String user_password;
    public static ArrayList<User> user_all_list=new ArrayList<>();

    public User(String user_name,String user_password){
        this.user_name=user_name;
        this.user_password=user_password;
    }
    public static void newUser(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter the user name:");
        String userName=sc.next();
        System.out.println("please enter the user password:");
        String userPassword=sc.next();
        user_all_list.add(new User(userName,userPassword));
    }
    public static User login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter the user name:");
        String userName=sc.next();
        for(int i=0;i<user_all_list.size();i++){
            if(userName.equals(user_all_list.get(i).user_name)){
                System.out.println("please enter the password:");
                String password=sc.next();
                if (password.equals(user_all_list.get(i).user_password)) {
                    return user_all_list.get(i);
                }
                else
                    throw new Invalid_password();
            }
        }
        throw new Exist_User_Exception("Error : this user name not exist!");
    }

}
