package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;

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
        log.setText("Open File(");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File:");
        fileChooser.showOpenDialog(null);
    }
}
