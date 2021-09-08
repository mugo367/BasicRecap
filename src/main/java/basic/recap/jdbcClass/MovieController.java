package basic.recap.jdbcClass;

import basic.recap.oopConcepts.model.Movie;
import basic.recap.oopConcepts.model.Series;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieController extends DbUtil implements   FilmControllerI<Movie> {


    @Override
    public void add(Movie movie) {
        writeData(movie.createUpdateSql());
    }

    @Override
    public void edit(Movie movie) {
        if (movie == null || movie.getId() == 0 )
            return;

        writeData(movie.createUpdateSql());
    }

    @Override
    public List<Movie> list() throws Exception {
        List<Movie> movieList = new ArrayList<Movie>();
        try {
            ResultSet result = readData("select * from movies");
            while (result.next()) {
                Movie movie = new Movie();
                movie.setId(result.getInt(1));
                movie.setTitle(result.getString(2));
                movie.setCountry(result.getString(3));
                movie.setOwner(result.getString(4));
                movie.setDistributedBy(result.getString(5));
                movie.setDuration(result.getInt(5));
                movieList.add(movie);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return movieList;
    }

    @Override
    public void delete(int id) {
        writeData("delete from movie where id=" + id);
    }
}
