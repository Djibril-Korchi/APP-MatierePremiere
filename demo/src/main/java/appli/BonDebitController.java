package appli;

<<<<<<< HEAD
=======
import appli.user.User;
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
<<<<<<< HEAD
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
=======

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80

public class BonDebitController implements Initializable {

    @FXML
    private Button afficher;

    @FXML
    private ComboBox<?> classe;

    @FXML
    private ComboBox<?> dimension;

    @FXML
    private ComboBox<?> forme;

    @FXML
    private ComboBox<?> piece;

    @FXML
    private ComboBox<?> proffesseur;

    @FXML
    private TextField quantite;

    @FXML
    private Button retour;

    @FXML
<<<<<<< HEAD
    private ComboBox<?> systeme;
=======
    private ComboBox professeur;
    @FXML
    private ComboBox classe;
    @FXML
    private Button valider;
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80

    @FXML
    private Button valider;

    public void setProffesseur() throws SQLException {
        ArrayList<String> professeur = new ArrayList<>();
        Bdd bdd = new Bdd();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "SELECT * FROM user WHERE ref_status=?"
        );
        requetePrepare.setInt(1,2);
        ResultSet connection = requetePrepare.executeQuery();
        for (int i = 1 ; connection.getFetchSize()<i;i++ ){
            professeur.add(connection.getInt(6));
        }
    }

    @FXML
    void onActionRetour(ActionEvent event) {

    }
    @FXML
    void onClickValider(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
        Bdd bdd = new Bdd();
        HelloApplication helloApplication= new HelloApplication();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "SELECT nom FROM user WHERE ref_status =(SELECT id_status FROM status WHERE role = 'professeur')");

        ResultSet resultatsRequetes = requetePrepare.executeQuery();
        while (resultatsRequetes.next()){
            this.professeur.getItems().add(resultatsRequetes.getString(1));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            Bdd bdd = new Bdd();
            HelloApplication helloApplication= new HelloApplication();
            Statement requeteSimple = bdd.getMaConnection().createStatement();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM classe");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()){
                this.classe.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            Bdd bdd = new Bdd();
            HelloApplication helloApplication= new HelloApplication();
            Statement requeteSimple = bdd.getMaConnection().createStatement();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM system");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()){
                this.classe.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
