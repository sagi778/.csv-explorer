package main.data_frame;


import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SummaryPanel {

    private Column column;
    private VBox vb;

    public SummaryPanel(){
        this.vb = new VBox();

        Label label = new Label("Column Name: ");
        TextField textField = new TextField();

        HBox hb = new HBox();
        hb.getChildren().addAll(label,textField);
        vb.getChildren().addAll(label);
    }
    public SummaryPanel(Column column){
        this.vb = new VBox();
        this.column = column;

        Label label = new Label("Column Name: ");
        TextField textField = new TextField(column.getColumnName());

        HBox hb = new HBox();
        hb.getChildren().addAll(label,textField);
        vb.getChildren().addAll(label);
    }

    public VBox getItem(){
        return vb;
    }
}
