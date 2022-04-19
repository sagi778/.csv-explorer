package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import main.file_reader.Csv;

import java.io.File;

public class Controller {

    @FXML
    Tab viz;

    @FXML
    Tab df;

    @FXML
    TextField log;

    @FXML
    void initialize(){}

    public void openAct(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open *.CSV File:");

        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            new Csv(file);
            log.setText("Open File(" + file + ")");
        }
    }
}