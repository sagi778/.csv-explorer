package main;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import main.file_reader.Csv;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


import javax.security.auth.callback.Callback;

public class Controller {

    private static int SIZE = 10;

    @FXML
    Tab viz;

    @FXML
    Tab df;

    @FXML
    TextArea log;

    @FXML
    TableView table;



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
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New File");
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