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
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectApplicationTypeDetails;
import gr.oncrete.nick.myCrop.RDBMS.InsertIntoTable;
import gr.oncrete.nick.myCrop.UserInterface.PopupMessageFrame;

/**
 *
 * @author nickapos
 *
 * This class is used to insert new bill entries into the database
 */
public class InsertApplication {

    InsertIntoTable in;
    public InsertApplication() {
    }

    /**
     * Constructor insert bill without an id
     *
     * @param cName
     * @param price
     * @param dateOfIssue
     * @param dateOfPayment
     */
    public InsertApplication(String fieldName, String cropTypeName, String appTypeName, String quantity, String expenses, String obs, String dateOfApplication) {
        if (fieldName.length() > 0 && cropTypeName.length() > 0 && appTypeName.length() > 0 && obs.length() > 0 && dateOfApplication.length() > 0) {
            SelectFarmFieldDetails a = new SelectFarmFieldDetails();
            a.SelectFarmFieldDetailsWithName(fieldName);
            String fid = a.getID();
            SelectCropTypeDetails b = new SelectCropTypeDetails();
            b.SelectCropTypeDetailsWithName(cropTypeName);
            String cid = b.getID();
            SelectCropFieldDetails c = new SelectCropFieldDetails();
            c.SelectCropFieldDetailsWithFidCid(fid, cid);
            String cfid = c.getID();
            SelectApplicationTypeDetails appt = new SelectApplicationTypeDetails();
            appt.SelectApplicationTypeDetailsWithName(appTypeName);
            String appTid = appt.getID();
            if (!(expenses.length() > 0)) {
                expenses = "";
            }
            if (!(quantity.length() > 0)) {
                quantity = "";
            }
            if (cfid.length() > 0) {
                String sql = "insert into applicationoncropfield (quantity,dateofapplication,expenses,observations,cfid,apid) values (" + quantity + ",'" + dateOfApplication + "'," + expenses + ",'" + obs + "'," + cfid + "," + appTid + ")";
                InsertIntoTable in = new InsertIntoTable(sql);
                //System.out.println(sql);
            }
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
    public InsertApplication(String aocfid, String fieldName, String cropTypeName, String appTypeName, String quantity, String expenses, String obs, String dateOfApplication) {
        if (aocfid.length() > 0 && fieldName.length() > 0 && cropTypeName.length() > 0 && appTypeName.length() > 0 && obs.length() > 0 && dateOfApplication.length() > 0) {
            SelectFarmFieldDetails a = new SelectFarmFieldDetails();
            a.SelectFarmFieldDetailsWithName(fieldName);
            String fid = a.getID();
            SelectCropTypeDetails b = new SelectCropTypeDetails();
            b.SelectCropTypeDetailsWithName(cropTypeName);
            String cid = b.getID();
            SelectCropFieldDetails c = new SelectCropFieldDetails();
            c.SelectCropFieldDetailsWithFidCid(fid, cid);
            String cfid = c.getID();
            SelectApplicationTypeDetails appt = new SelectApplicationTypeDetails();
            appt.SelectApplicationTypeDetailsWithName(appTypeName);
            String appTid = appt.getID();
            if (!(expenses.length() > 0)) {
                expenses = "";
            }
            if (!(quantity.length() > 0)) {
                quantity = "";
            }
            String sql = "insert into production (aocfid, quantity,dateofapplication,expenses,observations,cfid,apid) values (" + aocfid + "," + quantity + ",'" + dateOfApplication + "'," + expenses + ",'" + obs + "'," + cfid + "," + appTid + ")";
            in = new InsertIntoTable(sql);
            //System.out.println(sql);
        } else {
            this.emptyValuesPopup();
        }

    }

    public void insertApplication(String aocfid, String quantity, String dateOfApplication, String expenses, String obs, String cfid, String apid) {
        if (aocfid.length() > 0 && cfid.length() > 0 && apid.length() > 0 && obs.length() > 0 && dateOfApplication.length() > 0) {
            if (!(expenses.length() > 0)) {
                expenses = "";
            }
            if (!(quantity.length() > 0)) {
                quantity = "";
            }
            String sql = "insert into production (aocfid, quantity,dateofapplication,expenses,observations,cfid,apid) values (" + aocfid + "," + quantity + ",'" + dateOfApplication + "'," + expenses + ",'" + obs + "'," + cfid + "," + apid + ")";
            in = new InsertIntoTable(sql);
            //System.out.println(sql);
        } else {
            this.emptyValuesPopup();
        }
    }

    private void emptyValuesPopup() {
        PopupMessageFrame mes = new PopupMessageFrame();
        mes.setWarning(java.util.ResourceBundle.getBundle("gr/oncrete/nick/myCrop/UserInterface/Bundle").getString("EMPTY-VALUES"));
    }
}
