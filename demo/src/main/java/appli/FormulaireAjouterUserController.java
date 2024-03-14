package appli;

import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FormulaireAjouterUserController {

    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton professeur;
    @FXML
    private TextArea email;

    @FXML
    private TextArea mdp;

    @FXML
    private TextArea nom;

    @FXML
    private TextArea prenom;

    @FXML
    private Button retour;

    @FXML
    private Button valider;

    @FXML
    void OnClickRetour(ActionEvent event) {
        HelloApplication application = new HelloApplication();
        application.sceneConnexion("Admin");
    }

    @FXML
    void onClickValider(ActionEvent event) throws SQLException {
        String nom = this.nom+"";
        String prenom =this.prenom+"";
        String email =this.email+"";
        String mdp = this.mdp+"";
        int status = 0;
        if(admin.isSelected()){
            status = 2;
        } else if (professeur.isSelected()) {
            status = 1;
        }
        HelloApplication helloApplication = new HelloApplication();
        Bdd bdd = new Bdd();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "Insert Into user(nom,prenom,email,mdp,ref_status) VALUES (?,?,?,?,?)"
        );
        requetePrepare.setString(1,nom);
        requetePrepare.setString(2,prenom);
        requetePrepare.setString(3,email);
        requetePrepare.setString(4,mdp);
        requetePrepare.setInt(5,status);
        ResultSet connection = requetePrepare.executeQuery();
        helloApplication.sceneConnexion("Admin");
    }
}
