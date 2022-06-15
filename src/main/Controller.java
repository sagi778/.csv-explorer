package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import main.data_frame.Table;
import main.file_reader.Csv;

import javax.swing.*;
import java.io.File;

public class Controller {

    private static int DEFAULT_SIZE = 10;

    @FXML
    private Tab df,viz;

    @FXML
    private TabPane tables;

    @FXML
    private TextArea log;


    @FXML
    void initialize(){
        tables.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE,CornerRadii.EMPTY, Insets.EMPTY)));
        df.setClosable(true);

    }

    public void openAct(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open *.CSV File:");

        File file = fileChooser.showOpenDialog(null);

        if(file != null){
            Csv csvFile = new Csv(file);
            String txt = log.getText() + "\r\n";
            log.setText(txt + "> Open File(" + file + ")");
            Table df = csvFile.getDataFrame();

            //dfHbox.getChildren().add( df.getItem() );
        }
    }
    public void newAct(ActionEvent event) {

        String tableName = JOptionPane.showInputDialog("Please insert Table name:","Untitled");
        Table df = new Table(tableName);
        tables.getTabs().add(df.getItem()); //adding table tab

        String txt = log.getText() + "\r\n";
        log.setText(txt + "> New File");
    }
    public void saveAct(ActionEvent event) {
        String txt = log.getText() + "\r\n";
        log.setText(txt + "> Save File");
    }
}
