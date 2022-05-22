package main.data_frame;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.file_reader.Csv;

import java.io.File;
import java.util.ArrayList;

public class Table {

    //constants
    private static int DEFAULT_COLS = 10;

    //data attributes
    private Title title;
    private int rows;
    private ArrayList<Column> columns;

    //visuals
    private VBox vb;
    private HBox hb;
    private ArrayList<Button> buttons;

    public Table(File file){

        this.title = new Title( file.getName() );
        this.columns = new ArrayList<>();
        this.vb = new VBox();
        this.vb.setSpacing(10);
        this.hb = new HBox();

        this.vb.getChildren().addAll(this.title.getVisuals(), this.hb);
    }
    public Table(String tableName){

        this.title = new Title(tableName);
        this.vb = new VBox();
        this.vb.setSpacing(10);
        this.hb = new HBox();
        this.columns = new ArrayList<>();

        for(int i=0; i<DEFAULT_COLS; i++){
            Column column = new Column();
            this.addColumn( column );
        }

        this.vb.getChildren().addAll(this.title.getVisuals(), this.hb);
    }

    public VBox getVisuals() {
        return vb;
    }
    public ArrayList<Column> getColumns() {
        return columns;
    }
    public Column getColumn(int colNumber){
        return this.columns.get(colNumber);
    }

    public void addColumn(Column newColumn){
        columns.add( newColumn );
        hb.getChildren().add( newColumn.getVisuals() );
    }
    public void setRowNumber(int rows){
        this.rows = rows;
    }

}
