package appli;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import bdd.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        PreparedStatement requetePrepare = bdd.connection().prepareStatement(
                "SELECT * FROM user WHERE email=? and mdp=?"
        );
        requetePrepare.setString(1,getEmail());
        requetePrepare.setString(2,getMdp());
        ResultSet connection = requetePrepare.executeQuery();
        if (connection.next()){
            if (connection.getInt(6)==1){
                helloApplication.sceneConnexion("interface");
            }else {
                helloApplication.sceneConnexion("interfaceAdmin");
            }
        }else{
            helloApplication.sceneConnexion("connexion");
        }
    }
    }
}

