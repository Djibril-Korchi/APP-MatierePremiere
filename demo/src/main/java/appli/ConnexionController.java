package appli;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import bdd.bdd;

import java.sql.SQLException;

public class ConnexionController {
    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
    @FXML
    private Button button;
    private Button bon;

    @FXML
    protected void onHelloButtonClick() {
        String email = this.email.getText();
        String mdp = this.mdp.getText();
        bdd bdd = new bdd(email, mdp);
        try {
            bdd.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
<<<<<<< HEAD
=======
   
>>>>>>> d66f1fa35760ff7e549a531d2f5e27af6d562946
