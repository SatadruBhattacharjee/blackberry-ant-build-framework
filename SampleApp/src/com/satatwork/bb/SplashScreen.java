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

import java.util.Timer;
import java.util.TimerTask;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.MainScreen;

/**
 * @author Sat@Work
 *
 */
final public class SplashScreen extends MainScreen {            
	private MainScreen next;         
	private Timer timer = new Timer();         
	private UiApplication application;          
	//This splash screen is an image read from the root folder of the application         
	private static final Bitmap _bitmap = Bitmap.getBitmapResource("splash.png");       
	
	public SplashScreen(UiApplication ui, MainScreen next) {             
		super (Field.USE_ALL_HEIGHT|Field.FIELD_LEFT);             
		this.application = ui;             
		this.next = next;             
		this.add(new BitmapField(_bitmap));              
		/*              
		 * create a listener to allow the user to exit the splash screen              
		 * manually or override the navigation events as done below.              
		 *              
		 * the splash screen listener should implement net.rim.device.api.system.KeyListener.              
		 **/            
		//SplashScreenListener listener = new SplashScreenListener(this);             
		//this.addKeyListener(listener);              
		//create a timer to count down to the splash screens exit             
		timer.schedule(new ExitSplashCountDown(), 5000L);             
		application.pushScreen (this);         
	}          
	/**          
	 * <p>When the splash screen exits three things happen</p>          
	 * <ol>          
	 *     <li>The timer is canceled.</li>          
	 * <li>You pop the splash screen off the stack.</li>          
	 * <li>You push the main screen onto the stack.</li>          
	 * </ol>          */        
	public void dismiss() {             
		timer.cancel();             
		application.popScreen (this);             
		application.pushScreen (next);         
	}               
	
	/**          
	 * *  <p>This {@link TimerTask} is used to make sure the splash screen exits and          
	 * *  <b>does not display forever</b>.</p>          
	 * *          
	 * * @author Sat@Work          
	 * *          
	 */        
	private final class ExitSplashCountDown extends TimerTask 
	{             
		public void run() {                
			ExitSplashThread dThread = new ExitSplashThread();                
			application.invokeLater (dThread);             
		}         
	}                
	
	/**          
	 * * <p>Used by the {@link ExitSplashCountDown} to exit the splash screen.</p>          
	 * *          
	 * * @author Sat@Work          
	 * *          
	 */        
	private final class ExitSplashThread implements Runnable {             
		public void run() {                  
			dismiss();             
         }              
		/*          
		 * * When you click the navigation then the screen should exit and go to your applications main screen          
		 * *          
		 * * (non-Javadoc)          
		 * * @see net.rim.device.api.ui.Screen#navigationClick(int, int)          
		 * */         
		protected boolean navigationClick(int status, int time) {              
			dismiss();              
			return true;         
		}          
		
		/*          
		 * * Make sure nothing happens when the navigation senses movement          
		 * *          
		 * * (non-Javadoc)          
		 * * @see net.rim.device.api.ui.Screen#navigationMovement(int, int, int, int)          
		 */         
		protected boolean navigationMovement(int dx, int dy, int status, int time) {             
			return false;         
		}          
		
		/*          
		 * * Make sure nothing happens when unclick occurs          
		 * *          
		 * * (non-Javadoc)          
		 * @see net.rim.device.api.ui.Screen#navigationUnclick(int, int)          
		 */         
		
		protected boolean navigationUnclick(int status, int time) {            
			return false;         
		}
	}
}
