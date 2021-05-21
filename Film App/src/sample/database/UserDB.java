package sample.database;

import java.sql.*;

public class UserDB {

    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connect(String user , String password) throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        String sqlCommand = "CREATE TABLE IF NOT EXISTS user (Id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20), password VARCHAR(20))";
        String insertCommand = "insert into user (username , password) values (? , ?)";

        String username = "root";
        String pass = "yvr8v]7eJW\"!AQ2b";
        String url = "jdbc:mysql://localhost:3306/jdbc_test";
        try(Connection connection = DriverManager.getConnection(url, username, pass);
            Statement statement = connection.createStatement())  {

            statement.executeUpdate(sqlCommand);


            PreparedStatement preparedStatement = connection.prepareStatement(insertCommand);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.execute();


        }catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    public void output() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "yvr8v]7eJW\"!AQ2b");

        Statement st = con.createStatement();
        String sql = ("select * from user");
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            setUser(rs.getString("username"));
            setPassword(rs.getString("password"));

        }

        con.close();
    }
}