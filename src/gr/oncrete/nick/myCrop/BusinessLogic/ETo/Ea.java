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
package gr.oncrete.nick.myCrop.BusinessLogic.ETo;

/**
 *class with functions to calculate ea from min and max relative humidity values and minimum and maximum measurements.
 * This formula is quite accurate and is used when RHmin and RHmax are available
 *
 * @author nickapos
 */
public class Ea extends EaBase {
    public Ea()
    {
        
    }

    public double calcEa(double tmin,double tmax,double rhmin,double rhmax)
    {
        return (this.e(tmin)*(rhmin/100)+this.e(tmax)*(rhmax/100))/2;
    }
}
