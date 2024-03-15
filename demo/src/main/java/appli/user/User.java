package appli.user;

import appli.HelloApplication;
import bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private String email;
    private String mdp;

    public User(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }
    public void status() throws SQLException {
        Bdd bdd = new Bdd();
        HelloApplication helloApplication= new HelloApplication();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "SELECT * FROM user WHERE email=? and mdp=?"
        );
        requetePrepare.setString(1,email);
        requetePrepare.setString(2,mdp);
        ResultSet connection = requetePrepare.executeQuery();
        if (connection.getInt(6)==1){
            helloApplication.sceneConnexion("interfaceAdmin");
        }else {
            helloApplication.sceneConnexion("interface");
        }
    }
}
