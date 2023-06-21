package AimsProject.Src.aims.screens;

import javax.swing.*;
import AimsProject.Src.aims.Cart.carts;
import AimsProject.Src.aims.Media.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class CartScreen extends JFrame {
    private carts cart;

    public CartScreen (carts cart) {
        super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Screen/fxml/Cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        carts a = new carts();
        a.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        a.addMedia(new CompactDisc(1, "Star Wars", "Science Fiction", 24.95f, "George Lucas", "Harry Maguire"));
        a.addMedia(new Book(1, "jungle", "Adventure", 15f));

        CartScreen cs = new CartScreen(a);
    }
}