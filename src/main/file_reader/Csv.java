package main.file_reader;

import main.data_frame.Column;
import main.data_frame.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv {

    /** calss for reading data from csv file */
    private File file;
    private String path;
    private String fileName;
    private int row = 0;
    private Table dataFrame;

    public Csv(File file){

        this.file = file;
        this.path = file.getPath();
        this.fileName = path.substring(path.lastIndexOf("\\")+1,path.length()-4);
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));

            this.dataFrame = new Table( this.file);

            while( (line = reader.readLine())!= null ){

                if( row == 0 ){
                    String[] headers = line.split(",");
                    ArrayList<Column> columnList = this.dataFrame.getColumns();
                    for(int i=0; i<headers.length; i++){ //creating new columns
                        columnList.add(new Column(headers[i]));
                    }
                }
                else {
                    String[] currentRow = line.split(",");
                    for (int i = 0; i < currentRow.length; i++) { //adding current row value to each column
                        Column currentColumn = this.dataFrame.getColumns().get(i);
                        currentColumn.addEntry( currentRow[i] );
                    }
                }
                row += 1;
            }
            //this.getDataFrame().setRowNumber(row);
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
    }

    public File getFile() {
        return file;
    }
    public String getFileName() {
        return fileName;
    }
    public int getRows(){
        return row;
    }
    public Table getDataFrame() {
        return dataFrame;
    }
}
