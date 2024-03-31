package appli;

import appli.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class AdminController {

    @FXML
    private Button ajouter;

    @FXML
    private Button modifier;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @FXML
    void onClickAjouter(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("FormulaireAjouterUser");
    }

    @FXML
    void onClickModifier(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("ModifierFormulaire");
    }

    @FXML
<<<<<<< HEAD
    void onClickRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }

    @FXML
=======
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
    void onClickSuprimer(ActionEvent event) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("SupprimerFormullaire");
    }
<<<<<<< HEAD
=======

    public void onClickRetour(ActionEvent actionEvent) throws SQLException {
        System.out.println(User.getCompte());
        User user = new User();
        user.status();
    }
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
}
