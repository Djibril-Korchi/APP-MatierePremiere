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
<<<<<<< HEAD
}
=======
}
>>>>>>> 4785bc8b865579c63714dd92ee819cee9e07a538
