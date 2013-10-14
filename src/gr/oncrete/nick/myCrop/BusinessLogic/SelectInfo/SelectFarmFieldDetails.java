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
public class SelectFarmFieldDetails {

    private String fieldname, area, fid, northborder,eastborder,southborder,westborder,observations;
    private boolean exists = false;
    private String sql1 = "select fid,fieldname,area,northborder,eastborder,southborder,westborder,observations from farmfield where";
    private SelectFromTable sel = new SelectFromTable();

    public SelectFarmFieldDetails() {
    }

    public void SelectFarmFieldDetailsWithName(String n) {
        String sql = sql1 + " fieldname='" + n + "';";
        this.splitResults(sql);
    }

    public void SelectFarmFieldDetailsWithID(String id) {
        String sql = sql1 + " fid=" + id + ";";
        this.splitResults(sql);
    }

    private void splitResults(String sql) {
        //System.out.println(sql);
        ArrayList<String> a = sel.executeQuery(sql);
        
        if (a.size() > 0) {
            exists = true;
            fid = a.get(0);
            fieldname = a.get(1);
            area = a.get(2);
            northborder=a.get(3);
            eastborder=a.get(4);
            southborder=a.get(5);
            westborder=a.get(6);
            observations=a.get(7);
            //System.out.println(id+name+afm);
        }
    }

    public String getName() {
        return fieldname;
    }

    public String getID() {
        return fid;
    }

    public String getArea() {
        return area;
    }
    public String getNBorder() {
        return northborder;
    }
    public String getEBorder() {
        return eastborder;
    }
    public String getWBorder() {
        return westborder;
    }
    public String getSBorder() {
        return southborder;
    }
    public String getObservations() {
        return observations;
    }
    public boolean resultsExist()
    {
        return exists;
    }
}
