package appli;

import bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock {
    public Stock() {
    }

    public int longueurdebite(String quantite, String piece) throws SQLException {
        Bdd bdd = new Bdd();
        Statement requeteSimple = bdd.getMaConnection().createStatement();
        PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
                "SELECT longueur FROM piece WHERE libelle = ?");
        requetePrepare.setString(1,piece);
        ResultSet resultatsRequetes = requetePrepare.executeQuery();
        int longueur = resultatsRequetes.getInt(1)*Integer.parseInt(quantite);
        return longueur;
    }
    public int stock(String piece) throws SQLException {
    Bdd bdd = new Bdd();
    Statement requeteSimple = bdd.getMaConnection().createStatement();
    PreparedStatement requetePrepare = bdd.getMaConnection().prepareStatement(
            "SELECT SUM(longueur*quantite) FROM piece WHERE libelle = ? GROUP BY libelle");
    requetePrepare.setString(1,piece);
    ResultSet resultatsRequetes = requetePrepare.executeQuery();
    int stock = resultatsRequetes.getInt(1);
        return stock;
    }
}
