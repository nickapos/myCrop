/*
 *  Copyright (C) 2010 nickapos
 *  myCrop, crop managment program
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
import java.util.ArrayList;


/**
 *This class is intendet to hold the data of a report for its graphical representation
 * @author nickapos 26 Ιουλ 2010
 */
public class PlotDataObject {
    private ArrayList xAxis,yAxis;
    private String xAxisTitle,yAxisTitle,plotTitle;
    private int maxY,maxX;
    public PlotDataObject(String xTitle, String yTitle, String pTitle){
        xAxis = new ArrayList();
        yAxis = new ArrayList();
        xAxisTitle=xTitle;
        yAxisTitle=yTitle;
        plotTitle=pTitle;
        maxY=0;
        maxX=0;
    }

    /**
     *
     * set the maximum value of axis Y
     *
     * @param a
     */
    public void setMaxY(int a)
    {
        maxY=a;
    }

    /**
     *
     * set the maximum value of axis X
     *
     * @param a
     */

    public void setMaxX(int a)
    {
        maxX=a;
    }

    /*
     *
     * return the maximum value of Y axis
     */
    public int getMaxY()
    {
        return maxY;
    }
    /**
     * * return the maximum value of X axis
     *
     * @return
     */
    public int getMaxX()
    {
        return maxX;
    }
    public String getXtitle()
    {
        return xAxisTitle;
    }

    public String getYtitle()
    {
        return yAxisTitle;
    }

    public String getPlottitle()
    {
        return plotTitle;
    }

    /**
     *
     * get the x axis data as double numbers if possible
     *
     * @return
     */
    public double[] getXdataD()
    {
        double[] a=new double [xAxis.size()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=(Double)xAxis.get(i);
        }
        return a;

    }

    /**
     *
     * get the x axis data as double numbers if possible
     *
     * @return
     */
    public String[] getXdataS()
    {
        String[] a=new String [xAxis.size()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=(String)xAxis.get(i);
        }
        return a;

    }

    /**
     *
     * get the y axis data as double numbers if possible
     *
     * @return
     */
     public double[] getYdata()
    {
        double[] a=new double [yAxis.size()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=(Double)yAxis.get(i);
        }
        return a;

    }
    /**
     * Add plot data in pairs
     *
     * @param x
     * @param y
     */
    public void addElementPairs(String x, String y)
    {
        this.addXaxisElement(x);
        this.addYaxisElement(y);
    }
    /**
     *
     * Add elements to Xaxis
     * @param el
     */
    public void addXaxisElement(String el)
    {
        xAxis.add(Double.valueOf(el));
    }
    /**
     *
     * Add elements to Xaxis x is double
     * @param el
     */
    public void addXaxisElementD(double el)
    {
        xAxis.add(el);
    }
    
    /**
     * 
     * * Add elements to Yaxis
     * @param el
     */
    public void addYaxisElement(String el)
    {
        yAxis.add(Double.valueOf(el));
    }

    /**
     *
     * * Add elements to Yaxis
     * @param el
     */
    public void addYaxisElementD(double el)
    {
        yAxis.add(el);
    }

}
