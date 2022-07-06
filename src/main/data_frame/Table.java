package main.data_frame;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Table {

    //data attributes
    private String name;
    private ArrayList<Column> columns;

    //visuals
    private Tab tab;
    private HBox mainPanel;
    private ScrollPane scrollPane;
    private HBox hb;
    private VBox statsPanel;

    public Table(String name){

        this.name = name;
        this.columns = new ArrayList<Column>();
        this.tab = new Tab(name);
        this.scrollPane = new ScrollPane();
        this.scrollPane.setMinWidth(900);
        this.hb = new HBox();
        this.hb.setSpacing(3);
        this.hb.setPadding(new Insets(5,5,5,5));

        this.mainPanel = new HBox();
        this.mainPanel.setPadding(new Insets(5,5,5,5));

        this.statsPanel = new VBox();
        this.statsPanel.getChildren().add(new Label("Statistics:             "));

        this.scrollPane.setContent(this.hb);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        this.mainPanel.getChildren().addAll(this.statsPanel,this.scrollPane);
    }

    public void addColumn(Column column){

        this.columns.add(column);
        this.hb.getChildren().add(column.getView());
        //this.tab.setContent(this.scrollPane);

        //test 1
        this.tab.setContent(this.mainPanel);

    }

    public Tab getView(){
        return this.tab;
    }
}
