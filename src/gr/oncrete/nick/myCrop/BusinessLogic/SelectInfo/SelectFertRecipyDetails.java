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
 * this class will be used as a container for the fill details of a fertiliser recipy record
 */
public class SelectFertRecipyDetails {

    private String cid, frid, nutid, quantity, observations;
    private boolean exists = false;
    private String sql1 = "select frid,cid,nutid,quantity,observations from frecipy where";
    private SelectFromTable sel = new SelectFromTable();

    public SelectFertRecipyDetails() {
    }

    public void SelectNutrientTypeDetailsFRID(String n) {
        String sql = sql1 + " frid=" + n + ";";
        //System.out.println(sql);
        this.splitResults(sql);
    }

    public void SelectNutrientTypeDetailsWithCIDandNUTID(String cid,String nutid) {
        String sql = sql1 + " nutid=" + nutid +" and cid="+cid +";";
        this.splitResults(sql);
    }

    private void splitResults(String sql) {
        //System.out.println(sql);
        ArrayList<String> a = sel.executeQuery(sql);

        if (a.size() > 0) {
            exists = true;
            frid = a.get(0);
            cid = a.get(1);
            nutid = a.get(3);
            quantity = a.get(2);
            observations = a.get(4);
            //System.out.println(id+name+afm);
        }
    }

    public String getFrid() {
        return frid;
    }

    public String getCID() {
        return cid;
    }

    public String getNUTID() {
        return nutid;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getObservations() {
        return observations;
    }

    public boolean resultsExist() {
        return exists;
    }
}
