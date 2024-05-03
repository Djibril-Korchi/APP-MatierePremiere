package entity;

import appli.HelloApplication;

import java.sql.SQLException;

public class User {
    private static int compte;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
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
