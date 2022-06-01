package main.data_frame;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.file_reader.Csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Table {

    //constants
    private static int DEFAULT_COLS = 15;

    //data attributes
    private Title title;
    private int rows;
    private ArrayList<Column> columns;

    //visuals
    private VBox vb;
    private HBox hb;
    private ScrollPane scrollPane;
    private ArrayList<Button> buttons;

    public Table(File file){

        this.title = new Title( file.getName() );
        this.columns = new ArrayList<>();
        this.vb = new VBox();
        this.vb.setSpacing(10);
        this.scrollPane = new ScrollPane(); //test
        this.hb = new HBox();


        this.scrollPane.setContent(this.hb); //test
        this.vb.getChildren().addAll(this.title.getVisuals(), this.hb);
    }
    public Table(String tableName){

        this.title = new Title(tableName);
        this.vb = new VBox();
        this.vb.setSpacing(10);
        this.hb = new HBox();
        this.scrollPane = new ScrollPane(); //test
        this.columns = new ArrayList<>();

        for(int i=0; i<DEFAULT_COLS; i++){
            Column column = new Column();
            this.addColumn( column );
        }

        this.getColumnsStats();

        this.scrollPane.setContent(this.hb); //test
        this.vb.getChildren().addAll(this.title.getVisuals(), this.hb);
    }

    public void getColumnsStats(){

        ArrayList<Stats> arr = new ArrayList<Stats>();

        for(Column item: this.getColumns()){
            arr.add( new Stats(item));
        }
        for(Stats item: arr){
            item.start();
        }
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
