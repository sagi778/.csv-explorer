package main.data_frame;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class Column <E>{

    //constants
    private static int DEFAULT_ROWS = 10;

    //data attributes
    private String colName = "Column";
    private int colNumber = 0;
    private int rows = DEFAULT_ROWS;
    private ArrayList<E> data = new ArrayList<E>();

    //visual attributes
    private TextField[] textFields;
    private Button header;

    public Column(TextField[] textFields,int colNumber) {

        this.colNumber = colNumber;
        this.rows = textFields.length;
        this.textFields = textFields;
        this.header = new Button(colName + colNumber);
    }

    public void addDataColumn(GridPane grid){

        for(int row=0; row<rows; row++){

            if( isHeader( row ) ){
                header = new Button("Column" + colNumber);
                header.setPrefSize(90,30);
                grid.add( header, colNumber,row );
            }
            else {
                textFields[row] = new TextField();
                textFields[row].setPrefSize(90, 30);
                textFields[row].setAlignment(Pos.CENTER);
                textFields[row].setFont(Font.font(null, FontWeight.LIGHT, 11));
                grid.add( textFields[row], colNumber,row );
            }

        }
    }

    private boolean isHeader(int row){
        if( row == 0 )
            return true;
        return false;
    }

    }


