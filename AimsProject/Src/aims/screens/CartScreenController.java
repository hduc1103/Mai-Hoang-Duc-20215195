package AimsProject.Src.aims.screens;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import AimsProject.Src.aims.Cart.carts;
import AimsProject.Src.aims.Media.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private carts cart;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String>  colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(carts cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(fasle);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue){
                    if(newValue!=null){ 
                        updateButtonBar(newValue);
                    }
                }
            }
        );
    }
    void updateButtonBar(Media media){
        btnRemove.setVisible(true);
        if(media instanceof Playable){
            btnPlay.setVisible(true);
        }
        else{
            btnPlay.setVisible(fasle);
        }
    }
}