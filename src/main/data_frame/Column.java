package main.data_frame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Column{

    //data attributes
    private String colName;
    private ArrayList<String> data = new ArrayList<String>();
    private int n;

    //visuals
    private VBox vb;
    private Button header;

    //constants
    private double WIDTH = 80;
    private double MAX_WIDTH = 140;
    private Background DEFAULT_BACKGROUND = new Background(new BackgroundFill(Color.gray(0.92),CornerRadii.EMPTY, Insets.EMPTY));
    private Border DEFAULT_BORDER = new Border(new BorderStroke(Color.gray(0.8),BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));

    public Column(ArrayList<String> data){

        this.vb = new VBox();
        this.vb.setPrefWidth(WIDTH);
        this.vb.setMaxWidth(MAX_WIDTH);

        this.colName = data.get(0);
        this.n = data.size();

        this.header = new Button(colName);
        this.header.setPrefWidth(WIDTH);
        this.header.setMaxWidth(MAX_WIDTH);


        this.vb.getChildren().add(this.header);

        for(int i=1; i<data.size(); i++){
            addEntry( data.get(i) );
        }

        this.header.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DropShadow shadow = new DropShadow();
                shadow.setColor(Color.DODGERBLUE);
                header.getParent().setEffect(shadow);

                //new Stats(col);

                System.out.println("column pressed");
            }
        });
    }

    private void addEntry(String value){

        this.data.add(value);
        TextField tf = new TextField(value);
        tf.setBackground(DEFAULT_BACKGROUND);
        tf.setBorder(DEFAULT_BORDER);

        tf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tf.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY, Insets.EMPTY)));

            }

        });
        tf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf.setBackground(DEFAULT_BACKGROUND);
                //tf.getText() //enter new value to data
                System.out.println("value entered");
            }
        });

        this.vb.getChildren().add(tf);
    }

    public VBox getView(){
        return this.vb;
    }
    public ArrayList<String> getData() {
        return data;
    }
}


