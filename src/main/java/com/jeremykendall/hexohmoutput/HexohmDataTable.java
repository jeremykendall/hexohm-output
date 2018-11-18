package com.jeremykendall.hexohmoutput;

import com.jeremykendall.electricity.Resistance;
import com.jeremykendall.hexohm.Hexohm;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.SimpleHorizontalAligner;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;

import static org.springframework.shell.table.CellMatchers.at;

class HexohmDataTable {

    private static final int ROW_COUNT = 12;
    private static final int COLUMN_COUNT = 2;

    static Table build(Resistance resistance) {

        String[][] tableData = new String[ROW_COUNT][COLUMN_COUNT];

        addHeaders(tableData);
        generateData(tableData, new Hexohm(resistance));

        TableBuilder tableBuilder = new TableBuilder(new ArrayTableModel(tableData))
                .addFullBorder(BorderStyle.oldschool);

        alignHeaderRow(tableBuilder);
        alignDataRows(tableBuilder);

        return tableBuilder.build();
    }

    private static void addHeaders(String[][] tableData) {
        tableData[0][0] = "Potentiometer";
        tableData[0][1] = "Wattage";
    }

    private static void generateData(String[][] tableData, Hexohm hexohm) {

        int potentiometer = 0;

        for (int i = 1; i < ROW_COUNT; i++) {
            tableData[i][0] = String.valueOf(potentiometer);
            tableData[i][1] = String.valueOf(hexohm.getWattage(potentiometer).getWatts());
            potentiometer += 10;
        }
    }

    private static void alignHeaderRow(TableBuilder tableBuilder) {
        tableBuilder.on(at(0, 1)).addAligner(SimpleHorizontalAligner.center);
        tableBuilder.on(at(0, 2)).addAligner(SimpleHorizontalAligner.center);
    }

    private static void alignDataRows(TableBuilder tableBuilder) {
        for (int i = 1; i < ROW_COUNT; i++) {
            for (int j = 0; j < 2; j++) {
                tableBuilder.on(at(i, j)).addAligner(SimpleHorizontalAligner.right);
            }
        }
    }
}
