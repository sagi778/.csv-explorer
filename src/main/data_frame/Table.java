package main.data_frame;

import javafx.geometry.Insets;
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
    private VBox statsPanel;

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

        this.statsPanel = getStatsPanel();

        this.scrollPane.setContent(this.hb);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        this.mainPanel.getChildren().addAll(this.statsPanel, this.scrollPane);
    }

    public VBox getStatsPanel(){

        double MIN_WIDTH = 150;
        double TF_WIDTH = 80;

        VBox vb = new VBox();
        vb.setMinWidth(MIN_WIDTH);

        int items = 0;
        TextField itemsTf = new TextField( items + "");
        itemsTf.setPrefWidth(TF_WIDTH);
        Label itemsLabel = new Label("Items = ");
        HBox itemsView = new HBox();
        itemsView.getChildren().addAll(itemsLabel, itemsTf);
        vb.getChildren().add(itemsView);

        return vb;
    }

    public void addColumn(Column column){

        if( this.columns == null ){ //set first column as selected
            selectColumn(column);
        }
        this.columns.add(column);
        this.hb.getChildren().add(column.getView());

        this.tab.setContent(this.mainPanel);

    }
    public void selectColumn(Column column){
        this.selectedColumn = column;
    }

    public Tab getView(){
        return this.tab;
    }

}
