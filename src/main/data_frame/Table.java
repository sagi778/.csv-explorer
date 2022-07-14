package main.data_frame;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Table {

    //data attributes
    private String name;
    private int rows;
    private ArrayList<Column> columns;
    private Column selectedColumn; // for creating stats

    //visuals
    private Tab tab;
    private HBox mainPanel;
    private ScrollPane scrollPane;
    private HBox hb;
    private VBox sidePanel;

    public Table(String name){ //creating empty table - columns added later with addColumn()

        this.name = name;
        this.columns = new ArrayList<Column>();
        this.tab = new Tab(name);
        this.scrollPane = new ScrollPane();
        this.scrollPane.setMinWidth(840);
        this.hb = new HBox();
        this.hb.setSpacing(3);
        this.hb.setPadding(new Insets(5,5,5,5));

        this.mainPanel = new HBox();
        this.mainPanel.setPadding(new Insets(5,5,5,5));

        this.sidePanel = new VBox();

        this.scrollPane.setContent(this.hb);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        //this.mainPanel.getChildren().addAll(this.sidePanel, this.scrollPane);
    }


    public Column getColumn(String colName){

        for(Column item: this.columns){
            if(colName==item.getColName())
                return item;
        }
        return null;
    }
    public void addColumn(Column column){

        if( this.columns == null ){ //set first column as selected
            selectColumn(column);
        }
        this.columns.add(column);
        this.hb.getChildren().add(column.getView());

        this.tab.setContent(this.mainPanel);

    }
    public void addSidePanel(){

        this.sidePanel = new VBox();
        this.sidePanel.setMinWidth(140);
        this.sidePanel.setSpacing(5);
        this.sidePanel.getChildren().add( this.getTableTitle() );
        this.sidePanel.getChildren().add( this.getColumnsSection() );

        this.mainPanel = new HBox();
        this.mainPanel.setSpacing(5);
        this.mainPanel.setPadding(new Insets(5,5,5,5));
        this.mainPanel.getChildren().addAll(this.sidePanel, this.scrollPane);

        this.tab.setContent(this.mainPanel);
    }

    //side panel sections
    private HBox getTableTitle(){

        double TF_WIDTH = 80;
        double TF_HEIGHT = 10;

        String TXT = "Table: ";
        HBox hb = new HBox();

        Label label = new Label(TXT);

        TextField textField = new TextField( this.name + "");
        textField.setPrefWidth(TF_WIDTH);
        textField.setPrefHeight(TF_HEIGHT);
        textField.setAlignment(Pos.CENTER_LEFT);

        hb.getChildren().addAll(label, textField);
        return hb;
    }
    private HBox getColumnsSection(){

        HBox hb = new HBox();
        Label label = new Label("Column: ");
        String[] columnList = {"1","2"};
        ComboBox cb = new ComboBox(FXCollections.observableArrayList(columnList));
        hb.getChildren().addAll(label,cb);
        return hb;
    }

    public void selectColumn(Column column){
        this.selectedColumn = column;
    }

    public Tab getView(){
        return this.tab;
    }

}
