import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Movie implements Comparable<Movie>{
    public static ArrayList<Movie> movie_list=new ArrayList<>();
    public ArrayList<User> user_list=new ArrayList<>();
    private String title_ID;
    private int ordering;
    private String title;
    private String regions;
    private String language;
    private String types;
    private String attributes;
    private int isOriginal;
    private double rate;
    private int numVotes;

    public Movie(String title_ID,int ordering,String title,String regions,String language,String types,String attributes,int isOriginal,double rate,int numVotes){
        this.title_ID=title_ID;
        this.ordering=ordering;
        this.title=title;
        this.regions=regions;
        this.language=language;
        this.types=types;
        this.attributes=attributes;
        this.isOriginal=isOriginal;
        this.rate=rate;
        this.numVotes=numVotes;
    }

    public void setNumVotes(int numVotes) {
        this.numVotes = numVotes;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setTitle_ID(String title_ID) {
        this.title_ID = title_ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOrdering(int ordering) {
        this.ordering = ordering;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setIsOriginal(int isOriginal) {
        this.isOriginal = isOriginal;
    }

    public static void setMovie_list(ArrayList<Movie> movie_list) {
        Movie.movie_list = movie_list;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public double getRate() {
        return rate;
    }

    public int getNumVotes() {
        return numVotes;
    }

    public int getIsOriginal() {
        return isOriginal;
    }

    public String getTypes() {
        return types;
    }

    public String getTitle_ID() {
        return title_ID;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public String getAttributes() {
        return attributes;
    }

    public int getOrdering() {
        return ordering;
    }

    public String getRegions() {
        return regions;
    }


    public static void new_Movie(String title_ID, int ordering, String title, String regions, String language, String types, String attributes, int isOriginal,double rate,int numVotes){
        movie_list.add(new Movie(title_ID,ordering,title,regions,language,types,attributes,isOriginal,rate,numVotes));
    }

    public String toString(){
        return "title ID: "+this.title_ID+"\tordering: "+this.ordering+"\ttitle: "+this.title+"\tregions: "+this.regions+"\tlanguage: "+this.language+"\ttype: "+this.types+"\tattributes: "+this.attributes+"\tis original: "+this.isOriginal+"\trate: "+this.rate+"\tnumber of votes: "+this.numVotes;
    }
    public void print_info(){
        System.out.println("___________________ MOVIE ____________________");
        System.out.println("TITLE ID : "+this.title_ID);
        System.out.println("ORDERING : "+this.ordering);
        System.out.println("TITLE : "+this.title);
        System.out.println("REGIONS : "+this.regions);
        System.out.println("LANGUAGE : "+this.language);
        System.out.println("TYPES : "+this.types);
        System.out.println("ATTRIBUTE : "+this.attributes);
        System.out.println("IS ORIGINAL : "+this.isOriginal);
        System.out.println("RATE : "+this.rate);
        System.out.println("VOTE NUMBER : "+this.numVotes);
        System.out.println("________________________________________________");
    }
    public boolean isExist_User(User user){
        for(int i=0;i<user_list.size();i++){
            if(user_list.get(i).equals(user))
                return true;
        }
        return false;
    }
    public void rate(User user){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter your rate for this movie:");
        double rate=sc.nextDouble();
        if(isExist_User(user)){
            throw new Exist_User_Exception();
        }else{
            this.rate=(this.numVotes*this.rate+rate)/(this.numVotes+1);
            this.numVotes=this.numVotes+1;
            System.out.println("rate is successfully!");
        }
    }
    public static Movie get_search_Movie(){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<movie_list.size();i++){
            System.out.println(i+")");
            movie_list.get(i).print_info();
        }
        System.out.println("please enter the number of movie:");
        return movie_list.get(sc.nextInt());
    }

    @Override
    public int compareTo(Movie o) {
        if(this.rate>o.rate){
            return 1;
        }
        else if(this.rate==o.rate){
            return 0;
        }
        else{
            return -1;
        }
    }
    public static void top10(){
        Collections.sort(movie_list);
        int index=1;
        for(int i=movie_list.size()-1;i>=movie_list.size()-10;i--){
            System.out.println(index+")");
            movie_list.get(i).print_info();
            index++;
        }
    }
}
