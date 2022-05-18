package main.data_frame;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class Table {

    //constants
    private static int DEFAULT_COLS = 10;

    //data attributes
    private String name;
    private int rows;
    private ArrayList<Column> columns;

    //visuals
    private HBox hb;
    private ArrayList<Button> buttons;

    public Table(){
        this.name = "MyTable";
        this.hb = new HBox();
        this.columns = new ArrayList<>();

        for(int i=0; i<DEFAULT_COLS; i++){
            Column column = new Column();
            this.columns.add(i, column);
            this.hb.getChildren().add(this.columns.get(i).getVisuals());
        }
    }

    public HBox getVisuals() {
        return hb;
    }
}
