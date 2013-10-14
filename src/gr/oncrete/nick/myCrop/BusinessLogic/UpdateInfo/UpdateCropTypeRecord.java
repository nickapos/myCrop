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
public class UpdateCropTypeRecord extends UpdateRecord{
    String sql = "update croptype set cropname='";
    
    public UpdateCropTypeRecord(String cid,String cname, String ob ) {
        String sql1=sql+cname+"', observations='"+ob+"' where cid="+cid;
        //System.out.println(sql1);
        super.runQuery(sql1);
    }

    
}
