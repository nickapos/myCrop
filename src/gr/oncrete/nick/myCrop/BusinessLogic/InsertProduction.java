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
package gr.oncrete.nick.myCrop.BusinessLogic;

import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectFarmFieldDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectCropTypeDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectCropFieldDetails;
import gr.oncrete.nick.myCrop.RDBMS.InsertIntoTable;
import gr.oncrete.nick.myCrop.UserInterface.PopupMessageFrame;

/**
 *
 * @author nickapos
 *
 * This class is used to insert new bill entries into the database
 */
public class InsertProduction {

    public InsertProduction() {
    }

    /**
     * Constructor insert bill without an id
     *
     * @param cName
     * @param price
     * @param dateOfIssue
     * @param dateOfPayment
     *
     */
    public InsertProduction(String fieldName, String cropTypeName, String obs, String dateOfHarvest, String quantity) {
        if (fieldName.length() > 0 && cropTypeName.length() > 0 && obs.length() > 0 && dateOfHarvest.length() > 0 && quantity.length() > 0) {
            SelectFarmFieldDetails a = new SelectFarmFieldDetails();
            a.SelectFarmFieldDetailsWithName(fieldName);
            String fid = a.getID();
            SelectCropTypeDetails b = new SelectCropTypeDetails();
            b.SelectCropTypeDetailsWithName(cropTypeName);
            String cid = b.getID();
            SelectCropFieldDetails c = new SelectCropFieldDetails();
            c.SelectCropFieldDetailsWithFidCid(fid, cid);
            String cfid = c.getID();
            String sql = "insert into production (cfid,quantity,dateofharvest,observations) values (" + cfid + "," + quantity + ",'" + dateOfHarvest + "','" + obs + "')";
            InsertIntoTable in = new InsertIntoTable(sql);
            //System.out.println(sql);
        } else {
            this.emptyValuesPopup();
        }

    }

    /**
     * /**
     * Constructor insert bill with a specific id
     * used in restoring the database from csv file format
     *
     * @param bid
     * @param cid
     * @param price
     * @param dateOfIssue
     * @param dateOfPayment
     */
    public InsertProduction(String pid, String quantity, String dateOfHarvest, String obs, String fieldName, String cropTypeName) {
        if (pid.length() > 0 && fieldName.length() > 0 && cropTypeName.length() > 0 && obs.length() > 0 && dateOfHarvest.length() > 0 && quantity.length() > 0) {
            SelectFarmFieldDetails a = new SelectFarmFieldDetails();
            a.SelectFarmFieldDetailsWithName(fieldName);
            String fid = a.getID();
            SelectCropTypeDetails b = new SelectCropTypeDetails();
            b.SelectCropTypeDetailsWithName(cropTypeName);
            String cid = b.getID();
            SelectCropFieldDetails c = new SelectCropFieldDetails();
            c.SelectCropFieldDetailsWithFidCid(fid, cid);
            String cfid = c.getID();
            String sql = "insert into production (id, cfid,quantity,dateofharvest,observations) values (" + pid + "," + cfid + "," + quantity + ",'" + dateOfHarvest + "','" + obs + "')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        } else {
            this.emptyValuesPopup();
        }

    }

    public void insertProduction(String pid, String quantity, String dateOfHarvest, String obs, String cfid) {
        if (pid.length() > 0 && cfid.length() > 0 && obs.length() > 0 && dateOfHarvest.length() > 0 && quantity.length() > 0) {

            String sql = "insert into production (id, cfid,quantity,dateofharvest,observations) values (" + pid + "," + cfid + "," + quantity + ",'" + dateOfHarvest + "','" + obs + "')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        } else {
            this.emptyValuesPopup();
        }

    }

    private void emptyValuesPopup() {
        PopupMessageFrame mes = new PopupMessageFrame();
        mes.setWarning(java.util.ResourceBundle.getBundle("gr/oncrete/nick/myCrop/UserInterface/Bundle").getString("EMPTY-VALUES"));
    }
}
