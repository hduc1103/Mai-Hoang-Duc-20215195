package GUIProject.hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController extends BorderPane {

    @FXML
    private VBox drawingAreaPane;
    @FXML
    private ToggleGroup tool;
    @FXML
    private RadioButton penButton = new RadioButton();
    @FXML
    private RadioButton eraserButton = new RadioButton();

    private Color color;

    @FXML
    void init() {
        penButton.setSelected(true);
        color = Color.BLACK;

        tool.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle == penButton) {
                color = Color.BLACK;
            } else if (newToggle == eraserButton) {
                color = Color.WHITE;
            }
        });
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
