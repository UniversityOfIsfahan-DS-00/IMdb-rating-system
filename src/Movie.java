import java.util.ArrayList;

public class Movie {
    public static ArrayList<Movie> movie_list=new ArrayList<>();
    private String title_ID;
    private int ordering;
    private String title;
    private String regions;
    private String language;
    private String types;
    private String attributes;
    private int isOriginal;

    public Movie(String title_ID,int ordering,String title,String regions,String language,String types,String attributes,int isOriginal){
        this.title_ID=title_ID;
        this.ordering=ordering;
        this.title=title;
        this.regions=regions;
        this.language=language;
        this.types=types;
        this.attributes=attributes;
        this.isOriginal=isOriginal;
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


    public void new_Movie(String title_ID, int ordering, String title, String regions, String language, String types, String attributes, int isOriginal){
        movie_list.add(new Movie(title_ID,ordering,title,regions,language,types,attributes,isOriginal));
    }

    public String toString(){
        return "title ID: "+this.title_ID+"\tordering: "+this.ordering+"\ttitle: "+this.title+"\tregions: "+this.regions+"\tlanguage: "+this.language+"\ttype: "+this.types+"\tattributes: "+this.attributes+"\tis original: "+this.isOriginal;
    }
    public void print_info(){
        System.out.println("___________________ MOVIE ____________________");
        System.out.println("TITLE ID:"+this.title_ID);
        System.out.println("ORDERING :"+this.ordering);
        System.out.println("TITLE :"+this.title);
        System.out.println("REGIONS:"+this.regions);
        System.out.println("LANGUAGE:"+this.language);
        System.out.println("TYPES:"+this.types);
        System.out.println("ATTRIBUTE:"+this.attributes);
        System.out.println("IS ORIGINAL:"+this.isOriginal);
        System.out.println("________________________________________________");



    }
}
