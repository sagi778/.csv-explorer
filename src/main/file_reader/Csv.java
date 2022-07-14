package main.file_reader;

import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import main.data_frame.Column;
import main.data_frame.Table;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv {

    /** class for reading data from csv file */
    private File file;
    private String path;
    private String fileName;
    private Table table;
    private int numberOfRows = 0;
    private int numberOfColumns = 0;
    private ArrayList<String[]> data;

    public Csv(File file){

        this.file = file;
        this.path = file.getPath();
        this.fileName = path.substring(path.lastIndexOf("\\")+1,path.length()-4);

        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));
            this.data = new ArrayList<String[]>();

            while( (line = reader.readLine())!= null ){

                if(this.numberOfColumns == 0)
                    this.numberOfColumns = (line.split(",")).length;

                this.data.add(line.split(","));
                this.numberOfRows ++;
            }
            System.out.println("> reading file completed");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //creating columns from the data pulled from file
        this.table = new Table(this.fileName);

        for(int col=0; col<this.numberOfColumns; col++){

            ArrayList<String> temp = new ArrayList<String>();

            for(int row=0; row<this.numberOfRows; row++){
                temp.add( this.data.get(row)[col]);
            }

            this.table.addColumn( new Column(temp) );

        }
        this.getTable().addSidePanel();
        System.out.println("csv to Table is completed");
    }

    public Table getTable(){
        return this.table;
    }


}
