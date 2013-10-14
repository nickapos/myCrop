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
import java.util.*;
/**
 * this class will provide the all the production details for a specific crop
 *
 * @author nickapos
 */
public class SelectProductionDetailsForASpecificCropAndField extends SelectAllProductionDetailsForASpecificCrop {

    
    String sql = "SELECT id,fieldname,cropname,dateofharvest,quantity,observations FROM production a,cropfields b,farmfield c, croptype d where a.cfid=b.cfid and b.cid=d.cid and b.fid=c.fid";
    
    public SelectProductionDetailsForASpecificCropAndField(String cType, String fname) {
        sql1=sql+" and d.cropName='"+cType+"' and fieldname='"+fname+"'" ;
        //System.out.println(sql1);
    }

    

    /**
     *
     *
     * @return all the bill (or row) entries found in the db
     */
    public ArrayList getAllRows() {
        this.readDBReport();
        return rows;

    }
}
