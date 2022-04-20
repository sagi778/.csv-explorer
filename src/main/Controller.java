package main;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import main.file_reader.Csv;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import main.file_reader.data_types.*;

import javax.security.auth.callback.Callback;

public class Controller {

    @FXML
    Tab viz;

    @FXML
    Tab df;

    @FXML
    TextField log;

    @FXML
    TableView table;

    @FXML
    void initialize(){}

    public void openAct(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open *.CSV File:");

        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            Csv df = new Csv(file);
            log.setText("Open File(" + file + ")");

        }
    }

    public void newAct(ActionEvent event) {
        log.setText("New File");
    }

    public void addColumn(ActionEvent event) {
        log.setText("New Column");
        TableColumn col = new TableColumn("Column");
        table.getColumns().addAll(col);

    }
}