package main.data_frame;

import com.sun.javafx.scene.input.ExtendedInputMethodRequests;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Column{

    //constants
    private static int DEFAULT_ROWS = 10;
    private static int COLUMN_COUNTER = 0;
    private static int DEFAULT_WIDTH = 100;

    //data attributes
    private String colName;
    private int rows;
    private ArrayList<String> data = new ArrayList<String>();

    //visuals
    private VBox vb;
    private Button columnTitle;
    private ArrayList<TextField> textFields;

    public Column(String colName){

        this.vb = new VBox();
        this.colName = colName;
        this.columnTitle = new Button();
        this.setTitleButton(this.columnTitle);
        COLUMN_COUNTER += 1;
        this.rows = 0;
        textFields = new ArrayList<TextField>();

        this.vb.getChildren().add(columnTitle);
        this.vb.getChildren().addAll(textFields);
    }
    public Column(){

        this.vb = new VBox();
        this.colName = "Column " + (COLUMN_COUNTER+1);
        this.columnTitle = new Button(this.colName);
        this.setTitleButton(this.columnTitle);
        COLUMN_COUNTER += 1;
        this.rows = 0;
        textFields = new ArrayList<TextField>();

        for(int i=0; i<DEFAULT_ROWS; i++){
            this.addEmptyEntry();
        }

        this.vb = new VBox();
        this.vb.getChildren().add(columnTitle);
        this.vb.getChildren().addAll(textFields);
    } //new empty column
    private void setTitleButton(Button button){

        button.setPrefWidth(DEFAULT_WIDTH);
        button.setText(button.getText());
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println( getColumnName() + " Pressed");
            }
        });
    }
    private void setDataCellField(TextField cell){

        cell.setPrefWidth(DEFAULT_WIDTH);
        cell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("data added");
            }
        });
    }

    public String getColumnName() {
        return colName;
    }
    public VBox getVisuals() {
        return vb;
    }
    public int getRowNumber(){
        return (this.rows+1);
    }

    public void addEntry(String value){
        data.add(value); //add data value
        textFields.add( new TextField(value)); //add visual text field
        this.vb.getChildren().add(textFields.get(textFields.size()-1)); //add visuals to vbox
        this.rows ++;
    }
    public void addEmptyEntry(){
        addEntry("");
    }

}


