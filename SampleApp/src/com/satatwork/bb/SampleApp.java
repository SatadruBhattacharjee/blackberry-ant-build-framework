package com.satatwork.bb;

/*
Copyright (c) 2011 Satadru Bhattacharjee.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    Satadru Bhattacharjee - initial API and implementation
*/

import net.rim.device.api.ui.UiApplication;

/**
 * This class extends the UiApplication class, providing a
 * graphical user interface.
 * 
 * @author Sat@Work
 *
 */
public class SampleApp extends UiApplication
{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args)
    {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        SampleApp theApp = new SampleApp();       
        theApp.enterEventDispatcher();
    }
    

    /**
     * Creates a new SampleApp object
     */
    public SampleApp()
    {        
        // Push a screen onto the UI stack for rendering.
        //pushScreen(new SplashScreen());
        FrontScreen frontScreen = new FrontScreen();
		new SplashScreen(this, frontScreen);
    }    
}
