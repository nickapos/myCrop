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
 * A father class that will return a list with all the ids contained in our database either company ids of bill ids
 *
 * @author nickapos
 */
public class SelectAllIDS {

    SelectFromTable sel = new SelectFromTable();
    ArrayList idList;

    public SelectAllIDS() {
    }

    /**
     *
     * Returns an ArrayList containing the IDs of the companies or the bills or null
     *
     * @return
     */
    public void runQuery(String sql1) {
        idList = sel.executeQuery(sql1);
    }

    public ArrayList getIds() {
        if (this.isEmpty()) {
            return idList=new ArrayList();
        } else {
            return idList;
        }
    }

    public boolean isEmpty() {
        if (idList != null && idList.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
