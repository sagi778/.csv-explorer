package main.file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Csv {

    private File file = null;
    private String path = "";
    private int rows = 0;
    private String[] columns = null;

    public Csv(File file){
        file = file;
        path = file.getPath();
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));

            setColumns(reader); 

            while( (line = reader.readLine())!= null ){
                String[] row = line.split(",");
                //rows += 1;

                for(String index : row){
                    System.out.println(index);
                    //columns += 1;
                }
                System.out.println( );
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

    private void setColumns( BufferedReader reader) throws IOException {

        String line = "";

        while( (line = reader.readLine())!= null && this.columns == null ){
            this.columns = line.split(",");
        }
    }

    public String[] getColumns(){
        return this.columns;
    }

    public File getFile() {
        return file;
    }

    public int getRows(){
        return rows;
    }
}
