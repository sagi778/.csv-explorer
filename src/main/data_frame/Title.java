package main.data_frame;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Title {

    private int DEFAULT_WIDTH = 200;

    private String tableName;
    private Label label;
    private TextField textField;

    //visuals
    private HBox hb;

    public Title(String tableName){

        this.tableName = tableName;
        this.label = new Label("Table Name:  ");
        this.textField = new TextField(tableName);
        this.hb = new HBox();
        this.hb.getChildren().addAll(this.label, this.textField);
    }

    public HBox getItem(){
        return hb;
    }

}
