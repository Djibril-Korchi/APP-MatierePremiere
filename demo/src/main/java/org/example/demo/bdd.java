package org.example.demo;
import com.example.demo.HelloApplication;
import java.sql.*;

public class bdd {
    private String mdp;
    private String email;
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


    public void connection()  {
    HelloApplication helloApplication= new HelloApplication();
        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
