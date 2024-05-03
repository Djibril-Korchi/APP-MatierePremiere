package appli;

import appli.user.User;
import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BonDebitController implements Initializable {

    @FXML
    private Button retour;

    @FXML
    private ComboBox professeur;
    @FXML
    private ComboBox classe;
    @FXML
    private ComboBox piece;
    private ComboBox system;
    @FXML
    private ComboBox forme;
    @FXML
    private Button valider;


    @FXML
    void onClickRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
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
                this.system.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            Bdd bdd = new Bdd();
            HelloApplication helloApplication= new HelloApplication();
            Statement requeteSimple = bdd.getMaConnection().createStatement();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM piece");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()){
                this.piece.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            Bdd bdd = new Bdd();
            HelloApplication helloApplication= new HelloApplication();
            Statement requeteSimple = bdd.getMaConnection().createStatement();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT forme FROM forme");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()){
                this.forme.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            Bdd bdd = new Bdd();
            HelloApplication helloApplication= new HelloApplication();
            Statement requeteSimple = bdd.getMaConnection().createStatement();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM piece");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()){
                this.piece.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
