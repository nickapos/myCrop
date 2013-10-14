/*
 *  Copyright (C) 2011 nickapos
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gr.oncrete.nick.myBill.BusinessLogic;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * this class will return in a string the date of today properly formated for the database
 * @author nickapos
 */
public class Today {

    public Today() {
    }

    public String getToday() {
        String today="";
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {

            //System.out.println("Today: " + dateFormat.format(calendar.getTime()));
            //today=dateFormat.format(calendar.getTime());
            today=dateFormat.format(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }
}
