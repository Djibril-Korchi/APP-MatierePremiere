package appli;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import bdd.*;

import java.sql.*;

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
        Bdd bdd = new Bdd();
        HelloApplication helloApplication= new HelloApplication();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "SELECT * FROM user WHERE email=? and mdp=?"
        );
        requetePrepare.setString(1,email);
        requetePrepare.setString(2,mdp);
        ResultSet connection = requetePrepare.executeQuery();
        if (connection.next()){
            if (connection.getInt(6)==1){
                helloApplication.sceneConnexion("interfaceAdmin");
            }else {
                helloApplication.sceneConnexion("interface");
            }
        }else{
            helloApplication.sceneConnexion("connexion");
        }
    }
}

