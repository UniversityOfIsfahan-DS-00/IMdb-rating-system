import java.io.*;
import java.util.Scanner;

public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    input_data();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t1.join();
//        for(Movie m:Movie.movie_list){
//            m.print_info();
//        }
        L1:
        while (true) {
            try {
                System.out.println("1) LOG IN");
                System.out.println("2) CREATE ACCOUNT");
                System.out.println("3) EXIT");
                switch (sc.nextInt()) {
                    case 1: {
                        L2:
                        while (true) {
                            User temp_user = User.login();
                            System.out.println("1) RATE");
                            //System.out.println("2) TOP BEST MOVIE");
                            System.out.println("3) LOG OUT");
                            switch (sc.nextInt()) {
                                case 1: {
                                    Movie temp = Movie.get_search_Movie();
                                    temp.rate(temp_user);
                                    break;
                                }
//                                case 2: {
//                                    Movie.top10();
//                                    break;
//                                }
                                case 3: {
                                    break L2;
                                }
                            }

                        }
                        break;
                    }
                    case 2: {
                        User.newUser();
                        break;
                    }
                    case 3: {
                        break L1;
                    }
                }
            }catch (RuntimeException re){
                re.printStackTrace();
            }
        }
    }
    public static void input_data()throws IOException {
        File f1=new File("title.akas.txt");
        File f2=new File("title.ratings.txt");
        FileInputStream is1=new FileInputStream(f1);
        FileInputStream is2=new FileInputStream(f2);

        DataInputStream di1=new DataInputStream(is1);
        DataInputStream di2=new DataInputStream(is2);

        di1.readLine();
        di2.readLine();
        while (f1.canRead() && f2.canRead()){
            String[] s1=di1.readLine().split("\t");
            String[] s2=di2.readLine().split("\t");

            int ordering=Integer.valueOf(s1[1]);
            int isOriginal=Integer.valueOf(s1[7]);
            double rate=Double.parseDouble(s2[1]);
            int numVotes=Integer.valueOf(s2[2]);
            Movie.new_Movie(s1[0],ordering,s1[2],s1[3],s1[4],s1[5],s1[6],isOriginal,rate,numVotes);
        }
        di1.close();
        di2.close();
        is1.close();
        is2.close();
    }
}
