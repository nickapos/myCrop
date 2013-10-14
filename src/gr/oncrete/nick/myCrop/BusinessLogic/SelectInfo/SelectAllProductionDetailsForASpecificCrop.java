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
public class SelectAllProductionDetailsForASpecificCrop extends SelectAllIDS {

    protected ArrayList rows = new ArrayList();
    protected String sql = "SELECT id,fieldname,cropname,dateofharvest,quantity,observations FROM production a,cropfields b,farmfield c, croptype d where a.cfid=b.cfid and b.cid=d.cid and b.fid=c.fid";
    protected String sql1="";

    public SelectAllProductionDetailsForASpecificCrop() {
     
    }
    public SelectAllProductionDetailsForASpecificCrop(String cType) {
        sql1=sql+" and d.cropName='"+cType+"'" ;
        
    }

    /**
     *
     * This method will read the bill info from the database and return the whole
     * set in a properly formatted arraylist in order to be displayed in the report
     * jtable of the program
     */
    protected void readDBReport() {

        super.runQuery(sql1);
        ArrayList results = this.getIds();
        if (results.isEmpty()) {
            System.out.println("result set is empty. Dump database operation aborted");
            results= new ArrayList();
            //System.exit(1);

        } else {
            double quantity=0;
            for (int i = 0; i < results.size(); i += 6) {
                //with ids
                quantity=quantity+ Double.parseDouble((String) results.get(i + 4));
                String [] row = { (String)results.get(i),(String) results.get(i + 1),(String) results.get(i + 2),(String) results.get(i + 3),(String) results.get(i + 4),(String) results.get(i + 5) };

                rows.add(row);
                //System.out.println(row);
            }
            String [] a={"","","","-----","-----","",""};
            rows.add(a);
            String [] b={"","","","Total Results:",""+quantity,"",""};
            rows.add(b);
        }
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
