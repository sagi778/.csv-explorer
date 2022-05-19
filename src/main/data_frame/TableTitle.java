package main.data_frame;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TableTitle {

    private int DEFAULT_WIDTH = 200;

    private String tableName;
    private Label label;
    private TextField textField;

    private HBox hb;

    public TableTitle(String tableName){

        this.tableName = tableName;
        this.label = new Label("Table Name:  ");
        this.textField = new TextField(tableName);
        this.hb = new HBox();
        this.hb.getChildren().addAll(this.label, this.textField);
    }

    public HBox getVisuals(){
        return hb;
    }
}
