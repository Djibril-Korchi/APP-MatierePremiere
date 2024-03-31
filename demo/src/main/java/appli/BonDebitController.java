package appli;

import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;

public class BonDebitController {

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

}
