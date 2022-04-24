package main;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;
import main.file_reader.Csv;
import main.file_reader.Person;

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
    TableView table = new TableView<Person>();


    @FXML
    void initialize(){

        TableColumn firstNameColumn = new TableColumn< Person,String >("firstName");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameColumn.setCellFactory( TextFieldTableCell.forTableColumn() );
        firstNameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                Person p = event.getRowValue();
                p.setFirstName(event.getNewValue());
            }
        });

        TableColumn ageColumn = new TableColumn< Person,String >("age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));
        ageColumn.setCellFactory( TextFieldTableCell.forTableColumn(new IntegerStringConverter()) );
        ageColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event) {
                Person p = event.getRowValue();
                p.setAge(event.getNewValue());
            }
        });

        table.getColumns().add(firstNameColumn);
        table.getColumns().add(ageColumn);

        //add rows
        table.getItems().add(new Person("moshe", "cohen", 12));
        table.getItems().add(new Person("moshe", "cohen", 12));
        table.getItems().add( new Person("sdfsdf","sdfsd",234));

        //table settings
        table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);
        table.setTableMenuButtonVisible(true);
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