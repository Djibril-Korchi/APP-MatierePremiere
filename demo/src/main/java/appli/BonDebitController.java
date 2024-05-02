
package appli;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import appli.user.User;
import bdd.Bdd;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class BonDebitController implements Initializable {

    @FXML
    private Button afficher;

    @FXML
    private TextField apres;

    @FXML
    private TextField avant;

    @FXML
    private Button calcul;

    @FXML
    private ComboBox<String> classe;

    @FXML
    private RadioButton cprp;

    @FXML
    private RadioButton cqpm;

    @FXML
    private ComboBox<String> dimension;

    @FXML
    private ComboBox<String> forme;

    @FXML
    private RadioButton fs;

    @FXML
    private ComboBox<String> piece;

    @FXML
    private ImageView pieceImage;

    @FXML
    private ComboBox<String> professeur;

    @FXML
    private TextField quantite;

    @FXML
    private Button retour;

    @FXML
    private TextField stock;

    @FXML
    private ImageView system;

    @FXML
    private ComboBox<String> systeme;

    @FXML
    private TextField total;

    @FXML
    private RadioButton tu;

    @FXML
    private Button valider;

    public TextField getQuantite() {
        return quantite;
    }

    public ComboBox<String> getSysteme() {
        return systeme;
    }

    public ImageView getPieceImage() {
        return pieceImage;
    }

    public ComboBox<String> getForme() {
        return forme;
    }

    public ComboBox<String> getPiece() {
        return piece;
    }

    @FXML
    void onActionRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }
    @FXML
    void onClickAfficher(ActionEvent event) {
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT image FROM system WHERE libelle = ?");
            requetePrepare.setString(1,getSysteme()+"");
            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            if (resultatsRequetes.next()) {
                Image image = new Image(resultatsRequetes.getString(1));
                this.system.setImage(image);
            }
            requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT image FROM piece WHERE libelle = ?");
            requetePrepare.setString(1,getPieceImage()+"");
            resultatsRequetes = requetePrepare.executeQuery();
            if (resultatsRequetes.next()) {
                Image image = new Image(resultatsRequetes.getString(1));
                this.pieceImage.setImage(image);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onClickCalcul(ActionEvent event) throws SQLException {
        Stock stock1 = new Stock();
        total.setText(stock1.longueurdebite(getQuantite().getText(),getPiece().getItems()+"")+"");

    }
    @FXML
    void onClickValider(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM classe");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.classe.getItems().add(resultatsRequetes.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT libelle FROM `system`");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.systeme.getItems().add(resultatsRequetes.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT s.libelle,p.libelle FROM `system` as s INNER JOIN piece as p ON s.id_system =  p.ref_system");


            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.piece.getItems().add(resultatsRequetes.getString(1)+" / "+resultatsRequetes.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT forme FROM `forme`");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.forme.getItems().add(resultatsRequetes.getString(1)+" / "+resultatsRequetes.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT d.dimension FROM `dimension` as d INNER JOIN decrit as de ON d.id_dimension =  de.ref_dimension INNER JOIN forme as f ON de.ref_forme = f.forme WHERE f.forme = ? ");
            String ref = getForme().getItems()+"";
            requetePrepare.setString(1,ref);
            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.dimension.getItems().add(resultatsRequetes.getString(1)+" / "+resultatsRequetes.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
