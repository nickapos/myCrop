/*
 *   PlotWindow  -- A Swing frame for displaying a plot panel.
 *
 *   Copyright (C) 2000-2002 by Joseph A. Huwaldt <jhuwaldt@knology.net>.
 *   All rights reserved.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 **/
package gr.oncrete.nick.myCrop.UserInterface;

import java.awt.*;
import javax.swing.*;
import jahuwaldt.plot.*;
import gr.oncrete.nick.myCrop.BusinessLogic.PlotDataObject;

/**
 *  <p> A simple Swing frame that can be used to display a plot panel.
 *  </p>
 *
 *  <p>  Modified by:  Joseph A. Huwaldt  </p>
 *
 *  @author  Joseph A. Huwaldt   Date:  September 22, 2000
 *  @version December 12, 2000
 **/
public class PlotWindow extends JFrame {

    public PlotWindow()
    {
        
    }
    //-------------------------------------------------------------------------
    /**
     *  Creates a plot window that displays the specified plot panel.
     *
     *  @param  name   The title to show in the window's title bar.
     *  @param  plot   The plot panel to be displayed in this window.
     *
     **/
    public PlotWindow(String name, PlotPanel plot) {
        super(name);

        getContentPane().add(plot);
    }

    public void plotStringXAxis(PlotDataObject p) {
    }

    public void plotDoubleXAxis(PlotDataObject p) {

        double[] xAx = p.getXdataD();
        double[] yAx = p.getYdata();
        String xLabel = p.getXtitle();
        String yLabel = p.getYtitle();
        String plotLabel = p.getPlottitle();

        Plot2D aPlot = new SimplePlotXY(xAx, yAx, plotLabel, xLabel, yLabel,
                null, null, new CircleSymbol());

        PlotPanel panel = new PlotPanel(aPlot);
        panel.setBackground(Color.white);


        PlotWindow window = new PlotWindow(plotLabel, panel);
        window.setSize(500, 300);
        window.setLocation(50, 50);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.show();

    }
    //-------------------------------------------------------------------------

    /**
     *  A simple method to test this PlotWindow by creating a couple of Plot2D
     *  plots and putting them in windows.
     **/
    public void main(String[] args) {

        //	Create a Simple 2D XY plot window.
        double[] xArr = {1., 2., 10, 20, 30, 40, 50};
        double[] yArr = {0.06, 0.01, -0.01, -0.02, -0.03, -0.05, -0.075};
        double[] yArrAlt = {0.08, 0.03, 0.01, 0.0, -0.01, -0.03, -0.045};

        Plot2D aPlot = new SimplePlotXY(xArr, yArr, "Test SimpleXY Plot", "X Axis", "Y Axis",
                null, null, new CircleSymbol());

        //	Make the horizontal axis a log axis.
        PlotAxis xAxis = aPlot.getHorizontalAxis();
        xAxis.setScale(new Log10AxisScale());

        //	Create a 2nd run and add it to the plot.
        PlotRunList runs = aPlot.getRuns();
        runs.add(new PlotRun(xArr, yArrAlt, true, new SquareSymbol()));

        PlotPanel panel = new PlotPanel(aPlot);
        panel.setBackground(Color.white);


        PlotWindow window = new PlotWindow("SimplePlotXY Plot Window", panel);
        window.setSize(500, 300);
        window.setLocation(50, 50);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.show();




    }
}
