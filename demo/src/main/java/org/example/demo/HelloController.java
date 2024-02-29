package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.demo.bdd;

public class HelloController {
    @FXML
    private TextField email;
    @FXML
    private TextField mdp;
    @FXML
    private Button button;

    @FXML
    protected void onHelloButtonClick() {
        String email = this.email.getText();
        String mdp = this.mdp.getText();
        bdd bdd = new bdd(email,mdp);
        bdd.connection();
    }
}