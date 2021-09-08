package basic.recap.jdbcClass;

import basic.recap.oopConcepts.model.Series;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeriesController extends DbUtil implements FilmControllerI<Series> {


    @Override
    public void add(Series series) {
        writeData(series.createUpdateSql());
    }

    @Override
    public void edit(Series series) {
        if (series == null || series.getId() == 0 )
            return;

        writeData(series.createUpdateSql());
    }

    @Override
    public List<Series> list() throws Exception {
        List<Series> seriesList = new ArrayList<Series>();
        try {
            ResultSet result = readData("select * from series");
            while (result.next()) {
                Series series = new Series();
                series.setId(result.getInt(1));
                series.setTitle(result.getString(2));
                series.setCountry(result.getString(3));
                series.setOwner(result.getString(4));
                series.setDistributedBy(result.getString(5));
                series.setNoOfSeasons(result.getInt(5));
                seriesList.add(series);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return seriesList;
    }

    @Override
    public void delete(int id) {
        writeData("delete from series where id=" + id);
    }
}
