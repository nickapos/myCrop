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

/**
 *
 * @author nickapos
 *
 * This class is used to insert new type entries into the database
 */
public class InsertNutrientType {

    /**
     * Constructor insert company without an id
     *
     * @param cName
     * @param afm
     */
    public InsertNutrientType(String nName, String nSymbol,String aWeight ,String obs)
    {
        if(nName.length()>0 && nSymbol.length()>0 )
        {
            
            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into nutrienttype (nutname,nutsymbol,aweight,observations) values ('"+nName+"','"+nSymbol+"',"+aWeight+",'"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
        }
        else
        {
            this.emptyValuesPopup();
        }

    }
     public InsertNutrientType(String nutid,String nName, String nSymbol,String aWeight ,String obs)
    {
        if(nName.length()>0 && nSymbol.length()>0 )
        {

            if (!(obs.length()>0))
            obs = "";
            String sql = "insert into nutrienttype (nutid,nutname,nutsymbol,aweight,observations) values ("+nutid+",'"+nName+"','"+nSymbol+"',"+aWeight+",'"+obs+"')";
            InsertIntoTable in = new InsertIntoTable(sql);
            System.out.println(sql);
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
