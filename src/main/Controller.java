package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import main.file_reader.Csv;
import javafx.scene.control.Button;
import java.io.File;

public class Controller {

    private static int DEFAULT_SIZE = 10;

    @FXML
    private Tab viz;

    @FXML
    private Tab df;

    @FXML
    private TextArea log;

    @FXML
    private GridPane grid;

    private TextField[][] tf;
    private Button[] headers;

    @FXML
    void initialize(){


    }

    public void openAct(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open *.CSV File:");

        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            Csv df = new Csv(file);
            String txt = log.getText() + "\r\n";
            log.setText(txt + "> Open File(" + file + ")");

        }
    }

    public void newAct(ActionEvent event) {

        tf = new TextField[DEFAULT_SIZE][DEFAULT_SIZE];
        headers = new Button[tf.length];

        for(int col=0; col<DEFAULT_SIZE; col++){
            for(int row=0; row<DEFAULT_SIZE; row++){

                if( isHeader( row ) ){
                    headers[col] = new Button("Column" + col);
                    headers[col].setPrefSize(90,30);
                    grid.add( headers[col], col,row );
                }
                else {
                    tf[col][row] = new TextField();
                    tf[col][row].setPrefSize(90, 30);
                    tf[col][row].setAlignment(Pos.CENTER);
                    tf[col][row].setFont(Font.font(null, FontWeight.LIGHT, 11));
                    grid.add( tf[col][row], col,row );
                }

            }
        }

        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New File");
    }

    private boolean isHeader(int row){
        if( row == 0 )
            return true;
        return false;
    }


    public void addColumn(ActionEvent event) {
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New Column");
        //TableColumn col = new TableColumn("Column");
        //table.getColumns().addAll(col);
        //table.getItems().addAll(null,null);

    }

    public void saveAct(ActionEvent event) {
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> Save File");
    }
}