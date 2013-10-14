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
package gr.oncrete.nick.myCrop.BusinessLogic.UpdateInfo;



/**
 *
 * @author nickapos
 */
public class UpdateNutrientTypeRecord extends UpdateRecord{
    String sql = "update nutrienttype set nutname='";
    
    public UpdateNutrientTypeRecord(String nutid,String nutname,String aweight,String nutsymbol, String ob ) {
        String sql1=sql+nutname+"', aweight="+aweight+", nutsymbol='"+nutsymbol+"', observations='"+ob+"' where nutid="+nutid;
        //System.out.println(sql1);
        super.runQuery(sql1);
    }
    public UpdateNutrientTypeRecord(String nutname,String aweight,String nutsymbol, String ob ) {
        String sql1=sql+nutname+"', aweight="+aweight+", nutsymbol='"+nutsymbol+"', observations='"+ob+"' where nutname='"+nutname+"'";
        System.out.println(sql1);
        super.runQuery(sql1);
    }

    
}
