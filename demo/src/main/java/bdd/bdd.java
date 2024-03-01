package bdd;
import appli.HelloApplication;
import javafx.scene.control.Label;

import java.sql.*;

public class bdd {
    private String mdp;
    private String email;
    private Label button;
public bdd( String email,String mdp){
    this.mdp=mdp;
    this.email=email;
}
    public String getEmail() {
        return email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    public void connection() throws SQLException {
    HelloApplication helloApplication= new HelloApplication();

            Connection maConnection = null;
            maConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dki_lestrelin","root","");
            PreparedStatement requetePrepare = null;
            Statement requeteSimple = maConnection.createStatement();
            requetePrepare = maConnection.prepareStatement(
                    "SELECT * FROM user WHERE email=? and mdp=?"
            );
            requetePrepare.setString(1,getEmail());
            requetePrepare.setString(2,getMdp());
            ResultSet connection = requetePrepare.executeQuery();
            if (connection.next()){
                helloApplication.sceneConnexion("interface");

            }else{
                helloApplication.sceneConnexion("hello-view");
            }


    }
}
