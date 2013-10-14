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
 * this class will be used to retrieve all the details available for a company
 */
public class SelectApplicationTypeDetails {

    private String name, ob, id;
    private boolean exists = false;
    private String sql1 = "select apid,application,observations from applicationtype where";
    private SelectFromTable sel = new SelectFromTable();

    public SelectApplicationTypeDetails() {
    }

    public void SelectApplicationTypeDetailsWithName(String n) {
        String sql = sql1 + " application='" + n + "';";
        //System.out.println(sql);
        this.splitResults(sql);
    }

  
    public void SelectApplicationTypeDetailsWithID(String id) {
        String sql = sql1 + " apid=" + id + ";";
        this.splitResults(sql);
    }

    private void splitResults(String sql) {
        //System.out.println(sql);
        ArrayList<String> a = sel.executeQuery(sql);
        
        if (a.size() > 0) {
            exists = true;
            id = a.get(0);
            name = a.get(1);
            ob = a.get(2);
            //System.out.println(id+name+afm);
        }
    }

    public String getApplication() {
        return name;
    }

    public String getID() {
        return id;
    }

    public String getObservations() {
        return ob;
    }
    public boolean resultsExist()
    {
        return exists;
    }
}
