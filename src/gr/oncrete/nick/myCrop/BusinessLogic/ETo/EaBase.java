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
 *class with functions
to calculate ea from
mean relative humidity and
minimum and maximum measurements.
This formula is not very accurate
but is used when no RHmin and RHmax
are available

 * @author nickapos
 */
public class EaBase {

    public EaBase() {
    }

    /**
     *
     * method that calculates the  vapour pressure from temperature
     *
     * @param t
     * @return
     */
    public double e(double t) {
        double klasma = 17.27 * t / (t + 237.3);
        return 0.6108 * Math.exp(klasma);

    }

    /**
     *
     * A method to be overriden by the iheriting classes ea and eapoor
     * 
     * @return
     */
    protected double calcEa()
    {
        return 0;
    }
}
