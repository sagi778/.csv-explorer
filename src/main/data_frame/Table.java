package main.data_frame;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Table {

    //constants
    private static int DEFAULT = 10;

    //data attributes
    private String name = "";
    private ArrayList<Column> columns = new ArrayList<Column>();
    private int rows;

    //visual attributes
    private TextField[] textFields;
    private ArrayList<TextField> columnListView = new ArrayList<TextField>();

    //constructors
    public Table(String name) {

        this.name = name;
        if( columns.size()!=0 ){
            this.rows = columns.get(0).getRows();
        }
        else{
            this.rows = 0;
        }

    }
    public Table(String name, TextField[] textFields) {

        this.textFields = textFields;
        this.name = name;

        for(int i=0; i<DEFAULT; i++){
            this.columns.add( new Column(textFields,i) );/////////////////////////////////////problem when loading csv file!
            //this.textFields[i].setText("sdfsdf" );
        }
        this.rows = columns.get(0).getRows();

    }

    public ArrayList<Column> getColumns() {
        return columns;
    }
    public void addColumn(Column col) {
        this.columns.add( col );
    }

    //methods
    public void presentTable(GridPane grid,TextField[] textFields){

        this.presentColumnView(grid);

        for(Column item: columns){
            item.addDataColumn(grid);
        }
    }
    public void presentColumnView(GridPane grid){

        TextField tableName = new TextField();
        tableName.setText( this.name );

        Label tableTitle = new Label();
        tableTitle.setText("Table: ");
        tableTitle.setMinWidth(40);

        Pane space = new Pane();
        space.setMinWidth(10);

        grid.add( tableTitle ,0,0);
        grid.add( tableName ,1,0);
        grid.add( space ,2,0);
    }
}
