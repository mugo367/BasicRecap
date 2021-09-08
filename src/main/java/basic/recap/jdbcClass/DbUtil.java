package basic.recap.jdbcClass;

import java.sql.*;

public class DbUtil {
    private PreparedStatement statement;

    //Database connection details
    final String url = "jdbc:mysql://localhost:3306/learning";
    final String user= "mugo367";
    final String password = "mweiga_123";

    //To initialize connection to the database
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //To close the connection to the database
    @Override
    protected void finalize() throws Throwable {
        this.closeConnection();
    }
    //To read data from the database
    /** Example
     * -> SELECT * || [column_names] FROM table_name
     * -> SELECT * || [column_names] FROM table_name WHERE [Condition (And||Or||Not)]
     * -> SELECT  * || [column_names] FROM table_name ORDER BY [column_names] ASC||DESC
     * */
    public ResultSet readData(String query){
        if  (query == null || query.trim().equals(""))
            return null;
        try {
            PreparedStatement statement = getConnection().prepareStatement(query);
            return statement.executeQuery();

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }

        return null;

    }
    //To write data to the database
    //To delete data from the database
    //To update date in the database
    /** Example
     * -> INSERT INTO table_name ([column_names]) VALUES ([values])
     * -> UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition
     * -> DELETE FROM table_name WHERE condition
     * */

    public void writeData(String query) {
        if  (query == null || query.trim().equals(""))
            return;

        try {
            statement = getConnection().prepareStatement(query);
            statement.executeUpdate();

        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }
    //To close the connection
    private void closeConnection() throws SQLException {
        statement.close();
        getConnection().close();
    }
}
