package main.data_frame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class Table {

    //constants
    private static int DEFAULT_COLS = 10;

    //data attributes
    private Title title;
    private int rows;
    private ArrayList<Column> columns;
    private SummaryPanel summaryPanel;

    //visuals
    private Tab tab;
    private HBox hb;

    public Table(File file){

        this.title = new Title( file.getName() );
        this.columns = new ArrayList<>();
        VBox vb = new VBox();
        vb.setSpacing(10);

        HBox hb = new HBox();
        this.summaryPanel = new SummaryPanel();
        hb.getChildren().add(summaryPanel.getItem());
        vb.getChildren().addAll(this.title.getItem(),hb);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(vb);

        this.tab.setContent(scrollPane);
    }
    public Table(String tableName){

        this.title = new Title(tableName);
        this.tab = new Tab(tableName);

        VBox vb = new VBox();
        vb.setFillWidth(true);
        vb.setSpacing(5);
        vb.setMargin(this.title.getItem(), new Insets(5,5,5,5));

        this.hb = new HBox();
        vb.setMargin(hb, new Insets(0,5,5,5));

        this.columns = new ArrayList<>();
        this.summaryPanel = new SummaryPanel();
        hb.getChildren().add(summaryPanel.getItem());

        for(int i=0; i<DEFAULT_COLS; i++){
            Column column = new Column();
            this.addColumn( column );
        }

        //this.getColumnsStats();

        vb.getChildren().addAll(this.title.getItem(),hb);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(vb);

        this.tab.setContent(scrollPane);
        this.tab.setText(tableName);

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

    public Tab getItem() {
        return tab;
    }
    public ArrayList<Column> getColumns() {
        return columns;
    }
    public Column getColumn(int colNumber){
        return this.columns.get(colNumber);
    }

    public void addColumn(Column newColumn){
        columns.add( newColumn );
        this.hb.getChildren().add( newColumn.getItem() );
    }
    public void setRowNumber(int rows){
        this.rows = rows;
    }

}
