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

import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author nickapos
 */
public class SelectAllRecipiesForACropType extends SelectAllIDS {

    String sql1 = "select nutname,quantity from frecipy a,nutrienttype b where a.nutid=b.nutid and a.cid=";

    public SelectAllRecipiesForACropType(String ctid) {
        super.runQuery(sql1 + ctid);
    }

    /**
     * this method will go through the results of the recipy and create a hashmap that will contain the tuples name and quantity of the recipy
     *
     * @return
     */
    public HashMap getRecipyTuples() {
        HashMap<String,String> map = new HashMap();
        if (this.isEmpty()) {
            System.out.println("No recipy records found");
        } else {
            ArrayList<String> a = this.getIds();
            for (int u = 0; u < a.size(); u = u + 2) {
                    map.put(a.get(u), a.get(u+1));
                    //System.out.println("map"+a.get(u)+ a.get(u+1));
                }
        }
        return map;
    }
}
