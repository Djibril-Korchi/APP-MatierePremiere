package bdd;

import java.sql.*;

public class Bdd {
    private Connection maConnection;
public Bdd() throws SQLException {
    maConnection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/dki_lestrelin","root","");
    PreparedStatement requetePrepare = null;
}

    public Connection getMaConnection() {
        return maConnection;
    }

    public void connection() throws SQLException {

    }
}
