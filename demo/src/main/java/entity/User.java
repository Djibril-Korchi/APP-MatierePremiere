package entity;

import appli.HelloApplication;
import bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private static int compte;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private int status;

    public User(String nom, String prenom, String email, String mdp, int status) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.status = status;
    }

    public User(int status) {
        this.status=status;
        User.compte=status;
    }
    public User()  {

    }
    public void status() throws SQLException {
       HelloApplication helloApplication = new HelloApplication();
        if (User.getCompte()==1){
            helloApplication.sceneConnexion("interfaceAdmin");
        }else {
            helloApplication.sceneConnexion("interface");
        }
    }
    public String Professeur() throws SQLException {
        Bdd bdd = null;

            bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT nom FROM user WHERE id_user = ?");
            requetePrepare.setInt(1,User.getCompte());
            ResultSet resultatsRequetes = requetePrepare.executeQuery();

            if (resultatsRequetes.next()) {
                return resultatsRequetes.getString(1);
            } else {
                return null;
            }

    }

    public static int getCompte() {
        return compte;
    }
}
