package main.data_frame;

public class Stats extends Thread{ //class for collecting all Column related statistics

    private Column column;
    private double mean;
    private int n;
    private double min;
    private double max;
    private double std;

    public Stats(Column column){
        this.column = column;
        this.n = -1;
        this.mean = -1;
        this.min = -1;
        this.max = -1;
    }

    @Override
    public void run(){

        setN();
        System.out.println("column." + this.column.getColumnName() + " n = " + this.n);
        setMean();
        System.out.println("column." + this.column.getColumnName() + " mean = " + this.mean);
        setStd();
        System.out.println("column." + this.column.getColumnName() + "std = " + this.std);

    }

    private int getN() {

        return n;
    }
    private double getMean() {

        return this.mean;
    }
    public double getStd() {
        return std;
    }

    private void setN(){
        this.n = 0;
        for(String item: column.getData()){
            if(!item.equals(""))
                this.n ++;
        }
    }
    private void setMean(){

        double sum = 0;
        for(String item: column.getData()){
            if(item.equals(""))
                sum += Double.parseDouble(item);
        }
        this.mean = sum/this.getN();
    }
    private void setStd(){

        double dv = 0;
        for(String item: column.getData()){
            if(item.equals(""))
                dv += Math.pow(Double.parseDouble(item) - getMean(),2);
        }
        this.std = Math.pow(dv/this.getN(),0.5);
    }



    private boolean isNumeric(String item){

        if(item.length()==0)
            return false;

        try {
            Double.parseDouble(item);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
}
