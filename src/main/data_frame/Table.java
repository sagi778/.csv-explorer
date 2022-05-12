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

    public ArrayList<Column> getColumns() {
        return columns;
    }
    public void addColumn(Column col) {
        this.columns.add( col );
    }

    //methods
    public void drawTable(GridPane grid){

        this.drawColumnSidePanel(grid);
        int SIDE_PANEL_SHIFT = 3; //

        for(Column column: this.columns){
            column.drawColumn(grid, column.getColNumber() + SIDE_PANEL_SHIFT);
        }
    }
    public void drawColumnSidePanel(GridPane grid){

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
