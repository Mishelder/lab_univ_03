package bsu.rfe.java.group9.lab3.Skorohodov.varC12;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();
    private String needle = null;
    private String needleTwo = null;
    private DecimalFormat formatter =
            (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(5);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble =
                formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        String formattedDouble = formatter.format(value);
        double d1 = Double.parseDouble(formatter.format(table.getValueAt(row,0)));
        double d2 = (Double) table.getValueAt(row,1);
        label.setText(formattedDouble);
        if ((col+row)%2 == 0){
            panel.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        }else {
            panel.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
        }
        if(col == 1) {
            if (needle != null && needle.equals(formattedDouble)) {
                panel.setBackground(Color.RED);
            } else if (needleTwo != null) {
                String[] needles = needleTwo.split(" ");
                double from = Double.parseDouble(needles[0]);
                double to = Double.parseDouble(needles[1]);
                if ((from <= to) && (to >= Double.parseDouble(formattedDouble) && (from <= Double.parseDouble(formattedDouble))))
                    panel.setBackground(Color.GREEN);
            }
        }
        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    public void setNeedleTwo(String needle) {
        this.needleTwo= needle;
    }
}