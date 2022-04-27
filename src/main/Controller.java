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
import main.data_frame.Column;
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

    private TextField[] textFields;
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

        textFields = new TextField[DEFAULT_SIZE];

        for(int cols=0; cols<DEFAULT_SIZE; cols++){

            Column col = new Column(textFields,cols);
            col.addDataColumn(grid);
        }


        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New File");
    }

    private boolean isHeader(int row){
        if( row == 0 )
            return true;
        return false;
    }

    public void saveAct(ActionEvent event) {
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> Save File");
    }
}