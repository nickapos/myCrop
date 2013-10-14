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
 *his class provides the methods to calculate the penman monteith ETo as it is 
 * described in the FAO paper Irrigation and drainage paper number 56 and displayed in box 11 and example table 17
 *
 *
 * @author nickapos
 */
public class PenmanMonteith {

    double Tmax; //megisti mesi miniaia thermokrasia
    double Tmin; //mesi elaxisti miniaia thermokrasia
    double Ea; //mesi miniaia imerisia piesi ydratmwn
    double U; // mesi miniaia imerisia taxytita anemou
    int Day;// i mera tou mina gia tin opoia prosdiorizoume tin ETo. xrisimopoieitai sa mesi mera tou mina
    int Month;//minas gia to opoio prosdiorizoume tin ETo
    int Latitude_Moires; //gewgrafiko platos se moires
    int Latitude_Lepta; //dekadiko meros tou gewgrafikou plarous se lepta
    double Tmonth_i;// #mesi miniaia thermokrasia kata to mina Month
    double Tmonth_i_1; //mesi miniaia thermokrasia kata to mina Month-1
    double altitude; //yposometro perioxis
    double n; // meses wres iliofaneias hours/day

    public PenmanMonteith(double tma, double tmin, double ea, double u, int day, int month, int lat_moir, int lat_dek, double t_month, double t_month_1, double alt, double iliof) {
        Tmax = tma;
        Tmin = tmin;
        Ea = ea;
        U = u;
        Day = day;
        Month = month;
        Latitude_Moires = lat_moir;
        Latitude_Lepta = lat_dek;
        Tmonth_i = t_month;
        Tmonth_i_1 = t_month_1;
        altitude = alt;
        n = iliof;

    }

    /**
     * function that calculates gamma based on mean temperature returns gamma
     * 
     * @param T
     * @return
     */
    public double delta(double T) {
        double arith = 4098 * (0.6108 * Math.exp(17.27 * T / (T + 237.3)));
        double paranom = Math.pow((T + 237.3), 2);
        return arith / paranom;
    }

    /**
     * function that calculates pressure based on altitude returns pressure
     *
     * @param z
     * @return
     */
    public double pressure(double z) {
        double klasma = (293 - 0.0065 * z) / 293;
        double dynami = Math.pow(klasma, 5.26);
        return 101.3 * dynami;

    }

    /**
     *  function that calculated gamma based on pressure returns gamma
     * @param P
     * @return
     */
    public double gamma(double P) {
        return 0.665 * 0.001 * P;
    }

    /**
     * function that calculates saturation vapour pressure based on temperature returns saturation vapour presure'''
     *
     * @param T
     * @return
     */
    public double e_svp(double T) {
        double klasma = 17.27 * T / (T + 237.3);
        double dynami = Math.exp(klasma);
        return 0.6108 * dynami;
    }

    /**
     *  function that calculates which day of the year is the one in d day of m month returns day of the year
     *
     * @param d
     * @param m
     * @return
     */
    public int day_of_year(int d, int m) {

        boolean leapYear = false;
        int arMeras = ((275 * m / 9) - 30 + d) - 2;
        if (m < 3) {
            arMeras = arMeras + 2;
        }
        if (leapYear = true && m > 2) {
            arMeras = arMeras + 1;
        }
        return arMeras;
    }

    /**
     * function that calculates   which day of the year is  the middle day of m month  returns day of the year
     *
     * @param m
     * @return
     */
    public int day_of_year_monthly(int m) {

        return (int) 30.4 * m - 15;
    }

    /**
     * function that calculates the inverse relative distance of earth-sun depending on the day of the year J returns the distance dr
     * @param J
     * @return
     */
    public double inv_rel_dist(double J) {

        return 1 + 0.033 * Math.cos(2 * Math.PI * J / 365);
    }

    /**
     *calculates the latidude in rads from degrees returns rads phi
     *
     *
     * @param L
     * @return
     */
    public double lat_in_rad(double L) {
        return Math.PI * L / 180;
    }

    /**
     * calulates the solar declination in rads using the day of the year J  returns solar declination delta
     *
     * @param J
     * @return
     */
    public double solar_declination(double J) {
        double angle = (2 * Math.PI / 365) * J - 1.39;
        return 0.409 * Math.sin(angle);
    }

    /**
     *  function that calculates the sunset hour angle from input the latitude in rad and the solar declination returns the sunset hour angle ws
     *
     */
    public double sun_hour_angle(double J, double L) {

        double phi = this.lat_in_rad(L);
        double delt = this.solar_declination(J);
        return Math.acos(-Math.tan(phi) * Math.tan(delt));
    }

    /**
     * function that calculates the daylength by using the  sunset hour angle ws returns daylength
     * 
     * @param ws
     * @return
     */
    public double daylength(double ws) {
        return 24 * ws / Math.PI;
    }

    /**
     * function that calculates the radiation from the sun taking under consideration the angle of the  position of the field and the leng of the day returns Ra
     * 
     */
    public double clear_short_radiation(double J, double L) {
        double Gsc = 0.0820; //solar constant
        double phi = this.lat_in_rad(L);
        double delta = this.solar_declination(J);
        double ws = this.sun_hour_angle(J, L);
        double dr = this.inv_rel_dist(J);
        double expression = 24 * 60 * Gsc * dr * (ws * Math.sin(phi) * Math.sin(delta) + Math.cos(phi) * Math.cos(delta) * Math.sin(ws));
        return expression / Math.PI;
    }

    /**
     *  a function that calculates the product of the stefan boltzman with the temperature returns the product
     *
     *
     */
    public double stef_boltz_temp_prod(double T) {

        double sigma = 4.903 * Math.pow(10, -9);
        double tk = T + 273.16;
        return sigma * Math.pow(tk, 4);
    }

    /**
     * function used to calculate the ETo returns ETo
     * 
     * @return
     */
    public double calculate() {

        double Tmean = (Tmax + Tmin) / 2;
        double Press = this.pressure(this.altitude);
        double G = this.gamma(Press);
        double temp1 = 1 + 0.34 * U;
        double delt = this.delta(Tmean);
        double temp2 = delt / (delt + G * temp1);
        double temp3 = G / (delt + G * temp1);
        double temp4 = 900 * U / (Tmean + 273);
        double emax = this.e_svp(Tmax);
        double emin = this.e_svp(Tmin);
        double eav = (emax + emin) / 2;
        double deltaEs = eav - Ea;
        double J = this.day_of_year(Day, Month);
        float latFloat = Latitude_Lepta / 60;
        double L = Latitude_Moires + latFloat;
        double Ra = this.clear_short_radiation(J, L);
        double ws = this.sun_hour_angle(J, L);
        double N = this.daylength(ws);
        double nN = n / N;
        double Rs = (0.25 + 0.5 * nN) * Ra;
        double Rso = (0.75 + 2 * altitude / 100000) * Ra;
        double logos1 = Rs / Rso;
        double Rns = 0.77 * Rs;
        double sigma_t_max = this.stef_boltz_temp_prod(Tmax);
        double sigma_t_min = this.stef_boltz_temp_prod(Tmin);
        double temp5 = 0.34 - 0.14 * Math.sqrt(Ea);
        double temp6 = 1.35 * logos1 - 0.35;
        double Rnl = ((sigma_t_max + sigma_t_min) / 2) * temp5 * temp6;
        double Rn = Rns - Rnl;
        double Gday = 0;
        double Gmonth = 0.14 * (Tmonth_i - Tmonth_i_1);
        double temp7 = Rn - Gmonth;
        double temp8 = 0.408 * (Rn - G);
        double fin1 = temp8 * temp2;
        double fin2 = temp4 * deltaEs * temp3;
        double ETo = fin1 + fin2;
        return ETo;
    }
}
