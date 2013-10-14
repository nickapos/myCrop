/*
myCrop, crop managment program
Copyright (C) 2010  Nick Apostolakis

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * DumpDatabase.java
 *
 * Created on 21 Ιούλιος 2005, 9:39 πμ
 */
package gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo;

import java.util.ArrayList;
import java.util.Iterator;
import gr.oncrete.nick.myCrop.RDBMS.SelectFromTable;

/**
 *This class implements the dump database
 *operation.
 *
 * @author nickapos
 */
public class DumpDatabase {

    
    String queryA = "SELECT * FROM cropfields";
    String queryB = "SELECT * FROM croptype";
    String queryC = "SELECT * FROM farmfield";
    String queryD = "SELECT * FROM production";
    String queryE = "SELECT * FROM applicationtype";
    String queryF = "SELECT * FROM applicationoncropfield";
    String queryG = "SELECT * FROM frecipy";
    String queryH = "SELECT * FROM nutrienttype";
    String queryI="select fid,fieldname,longitude,latitude,elevation from farmfield";

    /** Creates a new instance of DumpDatabase */
    public DumpDatabase() {
        //this.readCompaniesTable();
        //this.readDBEforia();
    }

    /**
     * his method will call the apropriate method in order to form the
     * right query to export the the cropfield table
     */
    public ArrayList getCropFieldsCsv() {
        return this.readTable(queryA, 4);
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the the croptype table
     */
    public ArrayList getCropTypeCsv() {
        return this.readTable(queryB, 3);
        
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the the farmfield table
     */
    public ArrayList getFarmFieldCsv() {
        return this.readTable(queryC, 11);
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the production
     */
    public ArrayList getProductionCsv() {
        return  this.readTable(queryD, 5);
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the application type
     */
    public ArrayList getApplicationTypeCsv() {
        return this.readTable(queryE, 3);
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the application on cropfield
     */
    public ArrayList getApplicationOnCropFieldCsv() {
        return this.readTable(queryF, 7);
    }


    /**
     * This method will call the apropriate method in order to form the
     * right query to export the fert retipie table
     */
    public ArrayList getFrecipiedCsv() {
        return this.readTable(queryG, 5);
    }

    /**
     * This method will call the apropriate method in order to form the
     * right query to export the nutrient type table
     */
    public ArrayList getNutrientTypeCsv() {
        return this.readTable(queryH, 5);
    }
  
public ArrayList getSurveyorDataCsv() {
        return this.readTable(queryI, 5);
    }


    /**
     * a private method used as a template from the others to parse each table separately
     *
     * @param sqlQuery
     * @param offset
     * @param tablename
     */
    private ArrayList readTable(String sqlQuery, int offset) {
        SelectFromTable select = new SelectFromTable();
        ArrayList <String> tablename = new ArrayList();
        ArrayList results = select.executeQuery(sqlQuery);

        if (results.isEmpty()) {
            System.out.println("companies result is empty. Dump database operation aborted");
            System.exit(1);
        } else {

            
            for (int i = 0; i < results.size(); i += offset) {
                String row = "";
                for (int e = i; e < i+offset&& e<results.size(); e++) {
                    row = row+ results.get(e) + ";";
                }
                //String row = "" + results.get(i) + ";" + results.get(i + 1) + ";" + results.get(i + 2) + ";"+results.get(i + 3)+";";
                tablename.add(row);
                // System.out.println(row);
            }

        }
        return tablename;
    }
}
