import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;

import java.awt.*;

import static java.awt.Font.BOLD;

public class CalculatorView {
    private CalculatorModel model;
    private GridPane gridPane;
    private final int columns = 3;
    private final int rows = 5;
    private TextField display;
    private Button[] numbers;
    private Button plus;
    private Button clear;
    private Font font = new Font("SanSerif", BOLD, 25);


    public CalculatorView(CalculatorModel model) {
        this.model = model;
        gridPane = new GridPane();
        addDisplay();
        //addButtons();
        //setGridConstrains();
    }

    private void addDisplay() {
        this.display = new TextField(model.getResult());
        this.display.setEditable(false);
        //this.display.setAlignment(Pos.CENTER_RIGHT);
        //this.display.setFocusTraversable();
    }


}
