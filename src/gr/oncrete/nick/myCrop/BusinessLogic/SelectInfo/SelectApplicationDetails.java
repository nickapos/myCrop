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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo;

import gr.oncrete.nick.myCrop.RDBMS.SelectFromTable;
import java.util.*;

/**
 *
 * @author nickapos
 * this class will be used to retrieve all the details available for a bill
 */
public class SelectApplicationDetails {

    private String aocfid, cfid, dateofapplication, apid,expenses, quantity, observations;
    private boolean exists = false;
    private String sql1 = "select aocfid,quantity,dateofapplication,expenses,observations,cfid,apid from applicationoncropfield where";
    private SelectFromTable sel = new SelectFromTable();

    public SelectApplicationDetails() {
    }

   
     
    public void SelectApplicationDetailsWithID(String id) {
        String sql = sql1 + " aocfid=" + id + ";";
        this.splitResults(sql);
    }

    private void splitResults(String sql) {
        //System.out.println(sql);
        ArrayList<String> a = sel.executeQuery(sql);
        
        if (a.size() > 0) {
            exists = true;
            aocfid = a.get(0);
            quantity = a.get(1);
            dateofapplication = a.get(2);
            expenses=a.get(3);
            observations = a.get(4);
            cfid = a.get(5);
            apid=a.get(6);  
        }
    }

    public String getCFID() {
        return cfid;
    }

    public String getAPID() {
        return apid;
    }

    public String getAOCFID() {
        return aocfid;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getExpenses() {
        return expenses;
    }
    public String getDateOfApplication() {
        return dateofapplication;
    }
    public String getObservations() {
        return observations;
    }

    public boolean resultsExist() {
        return exists;
    }
}
