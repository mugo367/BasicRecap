package basic.recap.oopConcepts.model;

import java.util.Random;

public class Series extends Film{
    private int id;
    private int noOfSeasons;

    public Series(int id, String title, String country, String owner, String distributedBy, int noOfSeasons) {
        super(title, country, owner, distributedBy);
        this.id = id;
        this.noOfSeasons = noOfSeasons;
    }
    
    public Series() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfSeasons() {
        return noOfSeasons;
    }

    public void setNoOfSeasons(int noOfSeasons) {
        this.noOfSeasons = noOfSeasons;
    }

    public void displayGenre(String title) {
        if(title == null)
            System.out.println("No series was provided");
        else if(title == "Suits")
            System.out.println(title +" is a Drama");
        else if(title == "The Blacklist")
            System.out.println(title +" is a Thriller");
        else if(title == "The Flash")
            System.out.println(title +" is a Superhero");

    }

    public void startFilm(String title) {
        System.out.println(title+" is about to begin. Enjoy the series");
    }



    @Override
    public String toString() {
        return super.toString()+", "+ noOfSeasons + " seasons";
    }
    
    public String createUpdateSql(){

        String query;

        if (getId() == 0) {
            query = "insert into series(id,title,country,owner,distributedBy,noOfSeasons) values(";

            query += getId() + ",";
            query += "'" + getTitle() + "',";
            query += "'" + getCountry() + "',";
            query += "'" + getOwner() + "',";
            query += "'" + getDistributedBy() + "',";
            query += getNoOfSeasons()+")";

        } else {
            query = "update movies set ";

            String setCol = "";

            if (getTitle() != null && !getTitle().trim().equals(""))
                setCol += "title='" + getTitle();

            if (!setCol.equals("") && getCountry() != null && !getCountry().trim().equals(""))
                setCol += ",country='" + getCountry() + "',";
            
            if (!setCol.equals("") && getOwner() != null && !getOwner().trim().equals(""))
                setCol += ",owner='" + getOwner() + "',";

            if (!setCol.equals("") && getDistributedBy() != null && !getDistributedBy().trim().equals(""))
                setCol += ",distributedBy='" + getDistributedBy() + "',";
            if (!setCol.equals("") && getNoOfSeasons() > 0)
                setCol += ",noOfSeasons=" + getNoOfSeasons() + ",";

            query += setCol;

            query += " where id=" + getId();

        }

        System.out.println("Executing sql: " + query);

        return query;
        
    }
    
}
