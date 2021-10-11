public class Exist_User_Exception extends RuntimeException{
    public Exist_User_Exception(String text){
        super(text);
    }
    public Exist_User_Exception(){
        super("Error : this user already rating this movie!");
    }
}
