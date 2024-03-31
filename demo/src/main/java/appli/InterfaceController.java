package appli;

import appli.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.SQLException;

public class InterfaceController {

    @FXML
    private Button bon;

    @FXML
<<<<<<< HEAD
    void onClickRetour(ActionEvent event) throws SQLException {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("interface");
    }

    public void onClickMaj(ActionEvent actionEvent) {
    }

    public void onClickBon(ActionEvent actionEvent) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("bonDebit");
    }

    public void onClickBdc(ActionEvent actionEvent) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sceneConnexion("bonCommande");
    }

    public void onClickEds(ActionEvent actionEvent) {
=======
    void onClicRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
>>>>>>> ebd0572aef5a7b88592a409922d0dc11d751bd80
    }

    public void onClickMaj(ActionEvent actionEvent) {
    }

    public void onClickBon(ActionEvent actionEvent) {
    }

    public void onClickBdc(ActionEvent actionEvent) {
    }

    public void onClickEds(ActionEvent actionEvent) {
    }
}
