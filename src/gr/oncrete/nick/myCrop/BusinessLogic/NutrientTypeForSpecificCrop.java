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

import java.util.*;
import gr.oncrete.nick.myCrop.UserInterface.PopupMessageFrame;

/**
 * This class creates a sorted list of the nutrient types for the dropdown menu for a specific crop type, fert recipy
 * @author nickapos
 */
public class NutrientTypeForSpecificCrop extends FarmFields {

    public NutrientTypeForSpecificCrop(String ctid) {
        map = new HashMap();
        sql = "select nutid,nutname from nutrienttype a,frecipy b where a.nutid=b.nutid and b.cid=";
        if (ctid.length() > 0) {
            System.out.println(sql+ctid);
            this.prepareHash(sql + ctid);
        } else {
            this.emptyValuesPopup();
        }
    }

    private void emptyValuesPopup() {
        PopupMessageFrame mes = new PopupMessageFrame();
        mes.setWarning(java.util.ResourceBundle.getBundle("gr/oncrete/nick/myCrop/UserInterface/Bundle").getString("EMPTY-VALUES"));
    }
}
