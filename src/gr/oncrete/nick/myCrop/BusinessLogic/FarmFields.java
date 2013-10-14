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

import gr.oncrete.nick.myCrop.RDBMS.SelectFromTable;
import java.util.*;

/**
 * This class creates a sorted list of the companies for the dropdown menu in insert bill tab
 * @author nickapos
 */
public class FarmFields {

    protected String sql;
    protected HashMap map;

    public FarmFields() {
        sql="select fid, fieldName from farmfield";
        map = new HashMap();
        this.prepareHash(sql);
    }

    /**
     * Fill the hash table with the id and name
     *
     */
    protected void prepareHash(String sql) {
        SelectFromTable sel = new SelectFromTable();
        ArrayList a = sel.executeQuery(sql);
        //System.out.println("results are " + a.size());
        /*Iterator i = a.iterator();
        while(i.hasNext())
        {

        System.out.println(i.next());
        }*/

        for (int o = 0; o < a.size(); o += 2) {
            map.put(a.get(o), a.get(o + 1));
        }

        /* Debug for the hash map
        Set set = companies.keySet();
        Iterator e = set.iterator();
        while(e.hasNext())
        {
        String r = (String) e.next();
        System.out.println("key " +r+ " value "+companies.get(r));
        }
         */

    }

    public String[] names() {
        ArrayList<String> cNamesArrayList = new ArrayList<String>();
        Set<String> set = map.keySet();
        Iterator<String> e = set.iterator();
        while (e.hasNext()) {
            String r = e.next();
            cNamesArrayList.add((String)map.get(r));
        }
        Collections.sort(cNamesArrayList);
        String[] cNameStr = cNamesArrayList.toArray(new String[cNamesArrayList.size()]);
        return cNameStr;

    }
}
