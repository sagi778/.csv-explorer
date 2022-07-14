package main.data_frame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.ArrayList;


public class Column{

    //data attributes
    private String colName;
    private ArrayList<String> data = new ArrayList<String>();
    private boolean isSelected; //for creating stats
    private String type;
    private int n;

    //visuals
    private VBox vb;
    private Button header;
    private VBox statsVB;

    @FXML
    private TextArea edaText; ///////////////////////test - causing error!!!

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
        this.isSelected = false;
        this.type = "Numerical";

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
                ////////////////////////////////////////////////////////////////////////////////////////////

                Column selectedColumn = getColumn(header.getText());

                if( selectedColumn.isSelected ){
                    setUnSelected();
                    System.out.println( selectedColumn.getColName() + " un-selected" );
                    header.getParent().setEffect(null);
                }
                else{
                    selectedColumn.setSelected();
                    System.out.println( selectedColumn.getColName() + " selected" );
                    DropShadow shadow = new DropShadow();
                    shadow.setColor(Color.DODGERBLUE);
                    header.getParent().setEffect(shadow);

                    System.out.println( "Items: " + selectedColumn.getN());
                    System.out.println( "Mean: " + selectedColumn.getMean());
                    edaText.setText(selectedColumn.getColName());

                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                System.out.println("column pressed");
            }
        });
    }

    public void setSelected(){
        this.isSelected = true;
    }
    public void setUnSelected(){
        this.isSelected = false;
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

    public Column getColumn(String colName){
        if(colName==this.getColName())
            return this;
        else return null;
    }
    public VBox getView(){
        return this.vb;
    }
    public ArrayList<String> getData() {
        return data;
    }
    public String getColName() {
        return colName;
    }


    public int getN() {
        return data.size();
    }
    public double getMean(){
        double sum = 0;
        for(String item: data){
            sum += Double.parseDouble(item);
        }
        return (sum/getN());

    }
}


