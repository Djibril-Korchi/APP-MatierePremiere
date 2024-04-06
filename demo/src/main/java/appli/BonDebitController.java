package appli;

import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
    private ComboBox<?> systeme;

    private ComboBox professeur;

    @FXML
    private Button valider;

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
                this.classe.getItems();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }
}
