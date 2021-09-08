package basic.recap.jdbcClass;

import java.util.List;

public interface FilmControllerI <T>{
    void add(T t);

    void edit(T t);

    List<T> list() throws Exception;

    void delete(int id);
}
