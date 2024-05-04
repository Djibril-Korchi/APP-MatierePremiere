
package appli;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.*;
import bdd.Bdd;
import entity.System;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Dimension2D;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BonDebitController implements Initializable {

    @FXML
    private Button calcul;

    @FXML
    private ComboBox<Classe> classe;

    @FXML
    private RadioButton cprp;

    @FXML
    private ComboBox<String> dimension;

    @FXML
    private ComboBox<Forme> forme;

    @FXML
    private TextField initial;

    @FXML
    private ComboBox<Piece> piece;

    @FXML
    private ImageView pieceImage;

    @FXML
    private TextField professeur;

    @FXML
    private TextField quantite;

    @FXML
    private Button retour;

    @FXML
    private TextField stock;

    @FXML
    private ImageView system;

    @FXML
    private ComboBox<System> systeme;

    @FXML
    private TextField total;

    @FXML
    private Button valider;
    public TextField getQuantite() {
        return quantite;
    }

    public ComboBox<System> getSysteme() {
        return systeme;
    }

    public ImageView getPieceImage() {
        return pieceImage;
    }

    public ComboBox<Forme> getForme() {
        return forme;
    }

    public ComboBox<Piece> getPiece() {
        return piece;
    }

    public BonDebitController() throws SQLException {
        User user = new User();
        //this.professeur.setText(user.Professeur()); ;
    }

    @FXML
    void onActionRetour(ActionEvent event) throws SQLException {
        User user = new User();
        user.status();
    }
    @FXML
    void onClickAfficherSystem(ActionEvent event) {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void onClickAfficherPiece(ActionEvent event) {
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT image FROM piece WHERE libelle = ?");
            requetePrepare.setString(1,getPieceImage()+"");
            ResultSet resultatsRequetes = requetePrepare.executeQuery();
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
        int stock2 = stock1.stock(getPiece().getItems()+"")-stock1.longueurdebite(getQuantite().getText(),getPiece().getItems()+"");

        total.setText(stock1.longueurdebite(getQuantite().getText(),getPiece().getItems()+"")+"");
        initial.setText(stock1.stock(getPiece().getItems()+"")+"");
        stock.setText(stock2+"");
    }
    @FXML
    void onClickValider(ActionEvent event) throws SQLException {
        Bdd bdd = new Bdd();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "INSERT INTO debit(date,quantite,ref_matiere,ref_classe,ref_user)VALUES (?,?,?=(SELECT id_matiere FROM  matiere where ref))");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT * FROM classe");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.classe.getItems().add(new Classe(resultatsRequetes.getInt(1),resultatsRequetes.getString(2),resultatsRequetes.getInt(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT * FROM `system`");

            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.systeme.getItems().add(new System(resultatsRequetes.getInt(1),resultatsRequetes.getString(2)));//);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Bdd bdd = new Bdd();
            PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                    "SELECT * FROM `piece` WHERE ref_system= (SELECT id_system FROM system WHERE libelle = ?)");
            requetePrepare.setString(1,getSysteme().getItems()+"");
            ResultSet resultatsRequetes = requetePrepare.executeQuery();
            while (resultatsRequetes.next()) {
                this.piece.getItems().add(new Piece(resultatsRequetes.getInt(1),resultatsRequetes.getString(2),resultatsRequetes.getInt(4),resultatsRequetes.getInt(5),resultatsRequetes.getInt(6)));
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
                this.forme.getItems().add(new Forme(resultatsRequetes.getInt(1),resultatsRequetes.getString(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // try {
            //    Bdd bdd = new Bdd();
            //    PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(

                    //             "SELECT d.dimension FROM `dimension` as d INNER JOIN decrit as de ON d.id_dimension =  de.ref_dimension INNER JOIN forme as f ON de.ref_forme = f.forme WHERE f.forme = ? ");
                    //     String ref = getForme().getItems()+"";
            //    requetePrepare.setString(1,ref);
            //    ResultSet resultatsRequetes = requetePrepare.executeQuery();
            //    while (resultatsRequetes.next()) {
                //        this.dimension.getItems();
                //    }
            //} catch (SQLException e) {
            //    throw new RuntimeException(e);
        //}
    }

}
