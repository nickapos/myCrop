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

package gr.oncrete.nick.myCrop.BusinessLogic;

/**
 * This class will operate as a container for the spatial data of a field
 * @author nickapos
 */
public class FieldSpatialData {

    private String fieldName;
    private String fieldID;
    private String elevation;
    private String latDegrees;
    private String latMinutes;
    private String longDegrees;
    private String longMinutes;

    public void setFieldName(String f)
    {
        fieldName=f;
    }
    public String getFieldName()
    {
        return fieldName;
    }
    public void setFieldID(String f)
    {
        fieldID=f;
    }
    public String getFieldID()
    {
        return fieldID;
    }
    public void setElevation(String s)
    {
        elevation=s;
    }
    public String getElevation()
    {
        return elevation;
    }
    public void setLatitudeDegrees(String s)
    {
        latDegrees=s;
    }
    public String getLatitudeDegrees()
    {
        return latDegrees;
    }
    public void setLatitudeMinutes(String s)
    {
        latMinutes=s;
    }
    public String getLatitudeMinutes()
    {
        return latMinutes;
    }
    public void setLongitudeDegrees(String s)
    {
        longDegrees=s;
    }
    public String getLongitudeDegrees()
    {
        return longDegrees;
    }
    public void setLongitudeMinutes(String s)
    {
        longMinutes=s;
    }
    public String getLongitudeMinutes()
    {
        return longMinutes;
    }

}
