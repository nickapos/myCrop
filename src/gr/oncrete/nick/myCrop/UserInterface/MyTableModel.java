/*
 *  Copyright (C) 2011 nickapos
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gr.oncrete.nick.myCrop.UserInterface;

/**
 *
 * @author nickapos 30 Ιαν 2011
 */
/**
 * table model class used for reports
 *
 *
 */
public class MyTableModel extends javax.swing.table.AbstractTableModel {

    private String[] columnNames;
    private Object[][] data;

    /*
     * Constructor of the class that will allow me to
     * insert the header line of the report to the arraylist
     */
    public MyTableModel(String[][] d, String[] cName) {
        data = d;
        columnNames = cName;
    }

    public MyTableModel(Object[][] d, String[] cName) {
        data = d;
        columnNames = cName;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
