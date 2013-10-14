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
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectCropTypeDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectFarmFieldDetails;
import gr.oncrete.nick.myCrop.RDBMS.InsertIntoTable;

/**
 *
 * @author nickapos
 *
 * This class is used to insert new income entries into the database
 */
public class InsertCropField {

    /**
     * Constructor insert bill without an id
     *
     * @param cName
     * @param amount
     * @param dateOfPayment
     */
    public InsertCropField(String cName, String fName, String cropDetails)
    {
        if(cName.length()>0 && fName.length()>0  && cropDetails.length()>0)
        {
            SelectCropTypeDetails a = new SelectCropTypeDetails();
            a.SelectCropTypeDetailsWithName(cName);
            String cid = a.getID();
            SelectFarmFieldDetails b = new SelectFarmFieldDetails();
            b.SelectFarmFieldDetailsWithName(fName);
            String fid= b.getID();
            String sql = "insert into cropfields (cropdetails,cid,fid) values ('"+cropDetails+"',"+cid+","+fid+")";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }

    }
    /**
     * /**
     * Constructor insert income with a specific id
     * used in restoring the database from csv file format
     *
     * @param bid
     * @param cid
     * @param amount
     * @param dateOfPayment
     */
    public InsertCropField(String cfid, String cName, String fName, String cropDetails)
    {
        if(cfid.length()>0&& cName.length()>0 && fName.length()>0  && cropDetails.length()>0)
        {

            SelectCropTypeDetails a = new SelectCropTypeDetails();
            a.SelectCropTypeDetailsWithName(cName);
            String cid = a.getID();
            SelectFarmFieldDetails b = new SelectFarmFieldDetails();
            b.SelectFarmFieldDetailsWithName(fName);
            String fid= b.getID();
            String sql = "insert into income (cfid,cropdetails,cid,fid) values ("+cfid+",'"+cropDetails+"',"+cid+","+fid+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }

    }

}
