public class Invalid_password extends RuntimeException{
    public Invalid_password(String text){
        super(text);
    }
    public Invalid_password(){
        super("Error : password wrong!");
    }
}
