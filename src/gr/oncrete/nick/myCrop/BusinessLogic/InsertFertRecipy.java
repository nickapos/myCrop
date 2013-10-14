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
import gr.oncrete.nick.myCrop.RDBMS.InsertIntoTable;
import gr.oncrete.nick.myCrop.UserInterface.PopupMessageFrame;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectCropTypeDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectNutrientTypeDetails;

/**
 *
 * @author nickapos
 *
 * This class is used to insert new type entries into the database
 */
public class InsertFertRecipy {

    /**
     * Constructor insert company without an id
     *
     * @param cName
     * @param afm
     */
    public InsertFertRecipy()
    {
        
    }
    
    /**
     * method that will insert a fertilizer recipy when provided with the croptype id
     * and nutrient type id 
     * 
     * @param cid
     * @param nutid
     * @param quantity
     * @param obs
     */
    public void insertFrecipyWithIDs(String cid, String nutid,String quantity ,String obs)
        {
        if(cid.length()>0 && nutid.length()>0 &&quantity.length()>0 )
        {

            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into frecipy (cid,nutid,quantity,observations) values ("+cid+","+nutid+","+quantity+",'"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }
        else
        {
            this.emptyValuesPopup();
        }

    }

     public void insertFrecipyWithIDs(String frid,String cid, String nutid,String quantity ,String obs)
        {
        if(cid.length()>0 && nutid.length()>0 &&quantity.length()>0 )
        {

            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into frecipy (frid,cid,nutid,quantity,observations) values ("+frid+","+cid+","+nutid+","+quantity+",'"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }
        else
        {
            this.emptyValuesPopup();
        }

    }
    /**
     * this method will take as arguments the recipy types with crop and nutrient names
     * convert the names to ids and feed it to insertFrecipyWithIDs
     * @param ctypeName
     * @param nutTypeID
     * @param quantity
     * @param obs
     */
    public void insertFrecipyWithNames(String ctypeName, String nutTypeName,String quantity ,String obs)
    {
        if(ctypeName.length()>0 && nutTypeName.length()>0 &&quantity.length()>0 )
        {
            SelectCropTypeDetails ct = new SelectCropTypeDetails();
            ct.SelectCropTypeDetailsWithName(ctypeName);
            SelectNutrientTypeDetails nt = new SelectNutrientTypeDetails();
            nt.SelectNutrientTypeDetailsWithName(nutTypeName);
            this.insertFrecipyWithIDs(ct.getID(), nt.getID(), quantity, obs);
            
        }
        else
        {
            this.emptyValuesPopup();
        }

    }


    private void emptyValuesPopup() {
        PopupMessageFrame mes = new PopupMessageFrame();
        mes.setWarning(java.util.ResourceBundle.getBundle("gr/oncrete/nick/myCrop/UserInterface/Bundle").getString("EMPTY-VALUES"));
    }

}
