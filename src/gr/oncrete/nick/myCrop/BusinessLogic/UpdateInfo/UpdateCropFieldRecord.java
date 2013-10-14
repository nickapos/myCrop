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

import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectCropTypeDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectFarmFieldDetails;

/**
 *
 * @author nickapos
 */
public class UpdateCropFieldRecord extends UpdateRecord {

    String sql = "update cropfields set cid=";

    public UpdateCropFieldRecord(String cfid, String fName, String cName, String cropDetails) {
        SelectCropTypeDetails a = new SelectCropTypeDetails();
        a.SelectCropTypeDetailsWithName(cName);
        String cid = a.getID();
        SelectFarmFieldDetails b = new SelectFarmFieldDetails();
        b.SelectFarmFieldDetailsWithName(fName);
        String fid = b.getID();
        String sql1 = sql + cid + ", fid=" + fid + ", cropDetails='" + cropDetails + "' where cfid=" + cfid;
        //System.out.println(sql1);
        super.runQuery(sql1);
    }
}
