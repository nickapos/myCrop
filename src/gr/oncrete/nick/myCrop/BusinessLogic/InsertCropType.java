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
import gr.oncrete.nick.myCrop.RDBMS.InsertIntoTable;

/**
 *
 * @author nickapos
 *
 * This class is used to insert new field entries into the database
 */
public class InsertCropType {

    /**
     * Constructor insert company without an id
     *
     * @param cName
     * @param afm
     */
    public InsertCropType(String cName, String obs)
    {
        if(cName.length()>0 )
        {
            
            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into croptype (cropname,observations) values ('"+cName+"','"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }

    }

    /**
     * Constructor insert company with a specific id
     * used in restoring the database from csv file format
     *
     * @param id
     * @param cName
     * @param afm
     */
    public InsertCropType(String cid, String cName, String obs)
    {
        if(cid.length()>0 && cName.length()>0 )
        {
            
            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into croptype (cid,cropname,observations) values ("+cid+",'"+cName+"','"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }

    }

}
