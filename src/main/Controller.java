package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import main.data_frame.Column;
import main.data_frame.Table;
import main.file_reader.Csv;
import javafx.scene.control.Button;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

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

            textFields = new TextField[ df.getRows() ];

            Table table = df.getDataFrame();
            //table.drawColumnSidePanel(grid);
            table.drawTable(grid);
        }
    }

    public void newAct(ActionEvent event) {

        textFields = new TextField[DEFAULT_SIZE];

        String tableName = JOptionPane.showInputDialog("Please insert Table name:","Untitled");
        //Table table = new Table(tableName, textFields);
        //table.presentColumnView(grid);
        //table.presentTable(grid,textFields);



        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New File");
    }
    public void saveAct(ActionEvent event) {
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> Save File");
    }
}
