package main.data_frame;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Column{

    //constants
    private static int DEFAULT_ROWS = 10;
    private static int COLUMN_COUNTER = 0;

    //data attributes
    private String colName;
    private int rows;
    private ArrayList<String> data = new ArrayList<String>();

    //visuals
    private VBox vb;
    private Button columnTitle;
    private ArrayList<TextField> textFields;

    public Column(){
        this.colName = "Column Name " + (COLUMN_COUNTER+1);
        this.columnTitle = new Button(this.colName);
        COLUMN_COUNTER += 1;
        this.rows = DEFAULT_ROWS;
        textFields = new ArrayList<>();

        for(int i=0; i<rows; i++){
            data.add("");
            String txt = data.get(i);
            TextField cell = new TextField(txt);
            textFields.add(cell);
        }

        this.vb = new VBox();
        this.vb.getChildren().add(columnTitle);
        this.vb.getChildren().addAll(textFields);
    }

    public String getColumnName() {
        return colName;
    }

    public VBox getVisuals() {
        return vb;
    }
}


