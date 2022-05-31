package main.data_frame;

public class Stats extends Thread{ //class for collecting all Column related statistics

    private Column column;
    private boolean isCalculating = false;
    private double mean;

    public Stats(Column column){
        this.column = column;
        this.isCalculating = false;
        this.mean = 0.0;
    }

    @Override
    public void run(){

        isCalculating = true;
        this.mean = getMean();
        isCalculating = false;
    }

    private double getMean(){

        double mean = 0;
        for(String item: column.getData()){
            if( isNumeric(item)){
                mean += Double.parseDouble(item);
            }
        }
        System.out.println( "Column[" + column.getColumnName() + "].getMean() = " + mean);
        return mean;
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
