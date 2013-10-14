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
 *
 * @author nickapos
 */
public class SelectAllCropFieldsDetails extends SelectAllIDS {

    protected ArrayList rows = new ArrayList();
    protected String sql1 = "select cfid,cropname,fieldname,cropdetails from cropfields a,croptype b, farmfield c where a.cid=b.cid and a.fid=c.fid ";

    public SelectAllCropFieldsDetails() {
        
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

            for (int i = 0; i < results.size(); i += 4) {
                //with ids
                String [] row = { (String)results.get(i),(String) results.get(i + 1),(String) results.get(i + 2),(String) results.get(i + 3) };

                rows.add(row);
                //System.out.println(row);
            }
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
