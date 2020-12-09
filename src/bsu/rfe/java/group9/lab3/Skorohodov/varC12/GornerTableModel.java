package bsu.rfe.java.group9.lab3.Skorohodov.varC12;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")

public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 4 ;
    }

    public int getRowCount() {
        return new Double(Math.ceil((to - from) / step)).intValue() + 1;
    }

    public Object getValueAt(int row, int col) {
        double result = 0.0;
        double x = from + step * row;

        if(col==3){
            result = Math.abs((Double)getValueAt(row,1)-(Double)getValueAt(row,2));
        }else if(col==2){
            for (int i = 0; i < coefficients.length; i++)
                result += Math.pow(x, coefficients.length - 1 - i) * coefficients[coefficients.length - 1 - i];
        }
        else if (col == 1) {
            for (int i = 0; i < coefficients.length; i++)
            result += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
        } else {
            return x;
        }
        return result;
    }

    public String getColumnName(int col) {
       if (col == 3)
            return "Разница между первым и вторым столбцом";
        else if (col == 2)
            return "Значение X в обратном порядке";
        else if (col == 1)
            return "Значение многочлена";
        else
            return "Значение X";
    }

    public Class<?> getColumnClass(int col) {
        return Double.class;
    }
}

