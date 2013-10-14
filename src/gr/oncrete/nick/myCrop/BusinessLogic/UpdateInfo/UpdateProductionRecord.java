/*
        myBill, bills tracking program
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


/**
 *
 * @author nickapos
 */
public class UpdateProductionRecord extends UpdateRecord{

    String sql = "update production set cfid=";
    //update bills set cid=7, price=456, dateofissue='2010-04-25', dayofpayment='2010-12-05' where bid=7

    public UpdateProductionRecord(String id,String quant, String dofh,String obs,String cfid) {
        
        String sql1=sql+cfid+", quantity="+quant+", dateofharvest='"+dofh+"', observations='"+obs+"' where id="+id;
        //System.out.println(sql1);
        super.runQuery(sql1);
        
    }

  
}
