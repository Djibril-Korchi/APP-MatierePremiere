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
    protected void onHelloButtonClick() throws SQLException {
        String email = this.email.getText();
        String mdp = this.mdp.getText();
        bdd bdd = new bdd(email, mdp);
<<<<<<< HEAD
        bdd.connection();
    }
}
=======
        try {
            bdd.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}
>>>>>>> a1ae05718865038909a2dd6b04eac649aeecb05b
