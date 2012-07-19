/*
Optimization Algorithm Toolkit (OAT)
http://sourceforge.net/projects/optalgtoolkit
Copyright (C) 2006  Jason Brownlee

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package com.oat.explorer.domains.tsp.gui.panels;

import java.awt.Frame;

import com.oat.Domain;
import com.oat.explorer.domains.tsp.gui.plots.TourPanel;
import com.oat.explorer.gui.panels.ProblemPanel;
import com.oat.explorer.gui.plot.GenericProblemPlot;

/**
 * Type: TSPProblemPanel<br/>
 * Date: 24/11/2006<br/>
 * <br/>
 * Description:
 * <br/>
 * @author Jason Brownlee
 * 
 * <pre>
 * Change History
 * ----------------------------------------------------------------------------
 *                          
 * </pre>
 */
public class TSPProblemPanel extends ProblemPanel
{		
	
    public TSPProblemPanel(Frame parent, Domain domain)
	{
		super(parent, domain);
	}    

    @Override
    protected GenericProblemPlot prepareProblemPlot()
    {
        TourPanel tourPanel = new TourPanel();
        tourPanel.setShowBestTour(true);
        return tourPanel;
    }
    @Override
    protected String getProblemBase()
    {
        return null;
    }
}
