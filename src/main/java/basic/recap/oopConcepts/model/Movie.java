package basic.recap.oopConcepts.model;

public class Movie extends Film {
    private int id;
    private int duration;

    public Movie(int id, String title, String country, String owner, String distributedBy, int duration) {
        super(title, country, owner, distributedBy);
        this.id = id;

        this.duration = duration;
    }

    public Movie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void displayGenre(String title) {
        if(title == null)
            System.out.println("No movie was provided");
        else if(title == "Eli")
            System.out.println(title +" is a Horror");
        else if(title == "Inception")
            System.out.println(title+" is a Thriller");
        else if(title == "The Mechanic")
            System.out.println(title+ " is a Action");
    }

    public void startFilm(String title) {
        System.out.println(title+" is starting now. Enjoy your Movie");
    }

    @Override
    public String toString() {
        return super.toString()+", "+ duration+ " hours";
    }

    public String createUpdateSql(){

        String query;

        if (getId() == 0) {
            query = "insert into movies(id,title,country,owner,distributedBy,duration) values(";

            query += getId() + ",";
            query += "'" + getTitle() + "',";
            query += "'" + getCountry() + "',";
            query += "'" + getOwner() + "',";
            query += "'" + getDistributedBy() + "',";
            query += getDuration()+")";

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

            if (!setCol.equals("") && getDuration() > 0)
                setCol += ",duration=" + getDuration() + ",";

            query += setCol;

            query += " where id=" + getId();

        }

        System.out.println("Executing sql: " + query);

        return query;

    }

}
