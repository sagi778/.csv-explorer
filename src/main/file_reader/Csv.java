package main.file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Csv {

    private File file = null;
    private String path = "";
    private int rows = 0;
    private Column[] columns = null;

    public Csv(File file){

        file = file;
        path = file.getPath();
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));

            while( (line = reader.readLine())!= null ){

                if( columns == null ){ //set headers

                    String[] headers = line.split(",");
                    columns = new Column[headers.length];

                    for(int i=0; i<headers.length; i++){
                        columns[i] = new Column();
                        columns[i].setColName( headers[i] );
                    }
                }
                else{ //set data
                    String[] row = line.split(",");
                    rows += 1;

                    for(int i=0; i<row.length; i++){
                        columns[i].addDataRow( row[i] );
                    }
                }

            }
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
        return rows;
    }
}