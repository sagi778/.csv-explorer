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

    public void setColName(String colName) {
        this.colName = colName;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }

    public Column(String colName){
        this.colName = colName;
    }
    public Column(String colName, int colNumber){

        this.colName = colName;
        this.colNumber = colNumber;
    }
    public Column(TextField[] textFields, int colNumber) {

        this.colNumber = colNumber;
        this.rows = textFields.length;
        this.textFields = textFields;
        this.header = new Button(colName + colNumber);
    }

    public void addDataColumn(GridPane grid){

        int COLUMN_SHIFT = 3;

        for(int row=0; row<rows; row++){

            if( isHeader( row ) ){
                header = new Button("Column" + colNumber);
                header.setPrefSize(90,30);
                grid.add( header, colNumber+COLUMN_SHIFT,row );
            }
            else {
                textFields[row] = new TextField();
                textFields[row].setPrefSize(90, 30);
                textFields[row].setAlignment(Pos.CENTER);
                textFields[row].setFont(Font.font(null, FontWeight.LIGHT, 11));
                grid.add( textFields[row], colNumber+COLUMN_SHIFT,row );
            }

        }
    }

    private boolean isHeader(int row){
        if( row == 0 )
            return true;
        return false;
    }


    public String getColName() {
        return colName;
    }

    public void addEntry(E entry){
        data.add(entry);
        setRows( getRows()+1 );
        textFields = new TextField[this.getRows() + 1];
        textFields[this.getRows()] = new TextField();
        textFields[this.getRows()].setText((String) entry);


    }
}


