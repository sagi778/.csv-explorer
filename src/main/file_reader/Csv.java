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
    private File file = null;
    private String path = "";
    private String fileName = "";
    private int row = 0;
    private Table df;

    public Csv(File file){

        file = file;
        path = file.getPath();
        fileName = path.substring(path.lastIndexOf("\\")+1,path.length()-4);
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));

            this.df = new Table(fileName);
            ArrayList< String[] > data = new ArrayList< String[] >();

            while( (line = reader.readLine())!= null ){

                if( row == 0 ){

                    data.add( row,line.split(",") );

                    String[] headers = data.get(0);
                    for(int i=0; i<headers.length; i++){ //creating new columns
                        this.df.getColumns().add( new Column( headers[i], i) );
                    }
                }
                else {
                    data.add(row, line.split(","));
                    String[] currentRow = data.get(row);
                    for (int i = 0; i < currentRow.length; i++) { //adding current row value to each column
                        Column currentColumn = this.df.getColumns().get(i);
                        currentColumn.addEntry(currentRow[i]);
                    }
                }
                row += 1;
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
    }

    public File getFile() {
        return file;
    }

    public int getRows(){
        return row;
    }

    public Table getDataFrame() {
        return df;
    }
}
