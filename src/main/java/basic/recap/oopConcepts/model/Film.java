package basic.recap.oopConcepts.model;

public abstract class Film implements FilmInterface {
    private String title;
    private String country;
    private String owner;
    private String distributedBy;

    public Film(String title, String country, String owner, String distributedBy) {
        this.title = title;
        this.country = country;
        this.owner = owner;
        this.distributedBy = distributedBy;
    }

    public Film() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDistributedBy() {
        return distributedBy;
    }

    public void setDistributedBy(String distributedBy) {
        this.distributedBy = distributedBy;
    }

    @Override
    public String toString() {
        return  title  + ", " + country + ", " + owner + ", " + distributedBy ;
    }
}
