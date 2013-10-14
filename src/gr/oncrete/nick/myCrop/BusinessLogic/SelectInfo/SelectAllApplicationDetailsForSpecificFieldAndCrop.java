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
 * this class will retrieve the applications on a specific field and crop
 * it will work for the all applications on this specific field and crop
 * and for the applications done in a specific period
 */

package gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo;
import java.util.*;
/**
 *
 * @author nickapos
 */
public class SelectAllApplicationDetailsForSpecificFieldAndCrop extends SelectAllApplicationDetails {

    
    protected String sql = "SELECT aocfid,fieldname, cropname, application, quantity,dateofapplication,expenses,observations FROM applicationoncropfield a,applicationtype b,farmfield c, croptype d,cropfields e where a.cfid=e.cfid and a.apid=b.apid and c.fid=e.fid and  d.cid=e.cid";
    
    double expenses=0;//these variables will hold the total expences of the applications
    public SelectAllApplicationDetailsForSpecificFieldAndCrop(String fieldname, String croptype) {
        sql1=sql+" and cropname='"+croptype+"' and fieldname='"+fieldname+"'";
    }
    public SelectAllApplicationDetailsForSpecificFieldAndCrop(String fieldname, String croptype,String period) {
        sql1=sql+" and cropname='"+croptype+"' and fieldname='"+fieldname+"'"+period;
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
