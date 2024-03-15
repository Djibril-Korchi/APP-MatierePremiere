package appli;

import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FormulaireAjouterUserController {

    @FXML
    private RadioButton admin;

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private RadioButton professeur;

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
<<<<<<< HEAD
        void onClickValider(ActionEvent event) throws SQLException {
            String nom = this.nom+"";
            String prenom =this.prenom+"";
            String email =this.email+"";
            String mdp = this.mdp+"";
=======
    void onClickValider(ActionEvent event) throws SQLException {
        String nom = this.nom.getText();
        String prenom =this.prenom.getText()+"";
        String email =this.email.getText()+"";
        String mdp = this.mdp.getText()+"";

        int status = 0;
        if(admin.isSelected() ){
            status = 1;
        } else if (professeur.isSelected()) {
            status = 2;
        }
>>>>>>> 2ed14ed91dbb1449e6f5c1f53003eccf1be6b675
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
        requetePrepare.executeUpdate();
        helloApplication.sceneConnexion("Admin");
    }
}
