package main.file_reader;

import java.util.ArrayList;

public class Column <E> {

    private String colName;
    private int colNumber = 0;
    private ArrayList<E> data = new ArrayList<E>();

    public void setColName(String colName) {
        this.colName = colName;
    }

    public void addDataRow(E row){
        data.add(row);
    }




}
