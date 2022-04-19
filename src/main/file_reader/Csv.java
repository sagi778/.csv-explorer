package main.file_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Csv {

    private String file = "";
    private int rows = 0;
    private int columns = 0;

    public Csv(String file){
        file = file;
        BufferedReader reader = null;
        String line = "";

        try{
            reader = new BufferedReader(new FileReader(file));

            while( (line = reader.readLine())!= null ){
                String[] row = line.split(",");

                for(String index : row){
                    System.out.println(index);
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

    public String getFile() {
        return file;
    }

}
