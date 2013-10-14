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
public class SelectAllProductionDetailsForASpecificCropAndFieldInPeriod extends SelectAllProductionDetailsForASpecificCrop {

    
    String sql = "SELECT id,fieldname,cropname,dateofharvest,quantity,observations FROM production a,cropfields b,farmfield c, croptype d where a.cfid=b.cfid and b.cid=d.cid and b.fid=c.fid";
    public SelectAllProductionDetailsForASpecificCropAndFieldInPeriod(String cType,String fname,String period) {
        sql1=sql+" and c.fieldname ='"+fname+"' and d.cropName='"+cType+"'"+period ;
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

    /**
     * this method will add all the production records found in the database
     * for this specific crop in this period
     * @return
     */
    public String returnTotalProductionQuantity()
    {
        float totalProduction=0;
        ArrayList a = this.getAllRows();
        for(int o=0;o<a.size()-2;o++)
        {
            String[] rarr=(String[])a.get(o);
            String tprod= rarr[4]; 
            totalProduction+=Double.parseDouble(tprod);
        }
        return ""+totalProduction;
    }
}
