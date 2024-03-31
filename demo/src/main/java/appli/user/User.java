package appli.user;

import appli.HelloApplication;
import bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
    private static int compte;
    private int status;

    public User(int status) {
        this.status=status;
        User.compte=status;
    }
    public User(){

    }
    public void status() throws SQLException {
       HelloApplication helloApplication = new HelloApplication();
        if (User.getCompte()==1){
            helloApplication.sceneConnexion("interfaceAdmin");
        }else {
            helloApplication.sceneConnexion("interface");
        }
    }

    public static int getCompte() {
        return compte;
    }
}
