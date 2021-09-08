package basic.recap;

import basic.recap.jdbcClass.MovieController;
import basic.recap.jdbcClass.SeriesController;
import basic.recap.oopConcepts.model.Film;
import basic.recap.oopConcepts.model.Movie;
import basic.recap.oopConcepts.model.Series;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {

        Scanner input = new Scanner(System.in);
        int option;
        do{
            System.out.println("Select option:");
            System.out.println("1. Movie\n" + "2. Series");
             option = input.nextInt();

            switch (option){
                case 1:
                    Movie movie = new Movie();
                    System.out.println("Movie ID");
                    movie.setId(input.nextInt());
                    System.out.println("Title");
                    movie.setTitle(input.nextLine());
                    System.out.println("Country");
                    movie.setCountry(input.nextLine());
                    System.out.println("Owner");
                    movie.setOwner(input.nextLine());
                    System.out.println("Distributed By");
                    movie.setDistributedBy(input.nextLine());
                    System.out.println("Duration (hrs)");
                    movie.setDuration(input.nextInt());
                    MovieController movieController = new MovieController();
                    movieController.add(movie);
                    break;
                case 2:
                    Series series = new Series();
                    System.out.println("Series ID");
                    series.setId(input.nextInt());
                    System.out.println("Title");
                    series.setTitle(input.nextLine());
                    System.out.println("Country");
                    series.setCountry(input.nextLine());
                    System.out.println("Owner");
                    series.setOwner(input.nextLine());
                    System.out.println("Distributed By");
                    series.setDistributedBy(input.nextLine());
                    System.out.println("No of Seasons ");
                    series.setNoOfSeasons(input.nextInt());
                    SeriesController seriesController = new SeriesController();
                    seriesController.add(series);
                    break;
                default:
                    throw new IllegalStateException("Unexpected Option: " + option);
            }
        }while (option < 2);
    }

    private static void displayInfomation(Film inception, Film theMechanic, Film eli, Film theBlacklist, Film theFlash, Film suits) {
        //Movie inception = new Movie(1,"Inception", "United Kingdom", "Box office", "Netflix", 3);
        //Movie theMechanic = new Movie(2,"The Mechanic", "United States", " Millenium  Studio", "Netflix", 2);
        //Movie eli = new Movie(3, "Eli", "United States", " Millenium  Studio", "Netflix", 1);

        //Series theBlacklist = new Series(1, "The Blacklist", "United States", "NBC", "Netflix", 7);
        //Series theFlash = new Series(2, "The Flash", "United States", "The CW", "Warner Bross", 5);
       // Series suits = new Series(3, "Suits", "United States", "USA Network", "Netflix", 9);
        //displayInfomation(inception, theMechanic, eli, theBlacklist, theFlash, suits);
        System.out.println("============== Movies available are ================\n"+ inception +"\n"+ theMechanic +"\n"+ eli +"\n");

        inception.displayGenre(inception.getTitle());
        inception.startFilm(inception.getTitle());
        System.out.println("====================================================");

        theMechanic.displayGenre(theMechanic.getTitle());
        theMechanic.startFilm(theMechanic.getTitle());
        System.out.println("====================================================");

        eli.displayGenre(eli.getTitle());
        eli.startFilm(eli.getTitle());

        System.out.println("\n============== Series available are ================\n"+ theBlacklist +"\n"+ theFlash +"\n"+ suits +"\n");

        theBlacklist.displayGenre(theBlacklist.getTitle());
        theBlacklist.startFilm(theBlacklist.getTitle());
        System.out.println("====================================================");

        theFlash.displayGenre(theFlash.getTitle());
        theFlash.startFilm(theFlash.getTitle());
        System.out.println("====================================================");

        suits.displayGenre(suits.getTitle());
        suits.startFilm(suits.getTitle());
        System.out.println("====================================================");

        List<Film> movieList = new ArrayList<Film>();
        movieList.add(inception);
        movieList.add(theMechanic);
        movieList.add(eli);

        for (Film movie:movieList){
            System.out.println(movie.getTitle()+" Was made in "+movie.getCountry());
        }

        System.out.println("\nBefore update:"+ inception +"\n");
        inception.setDistributedBy("Warner Bros pictures");
        inception.setOwner("Legendary pictures");
        System.out.println("After update:"+ inception);
    }
}
