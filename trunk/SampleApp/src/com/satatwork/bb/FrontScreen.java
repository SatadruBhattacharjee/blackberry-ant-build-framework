//#preprocess

/*
  Copyright (c) 2011 Satadru Bhattacharjee.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
      Satadru Bhattacharjee - initial API and implementation
*/

package com.satatwork.bb;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.MainScreen;

/**
 * @author Sat@Work
 *
 */
public final class FrontScreen extends MainScreen {

	public FrontScreen() {
		super();
		
		TextField text = new TextField(Field.EDITABLE);
		
		//#ifdef RIM_4.5.0
		text.setText("It's 4.5.0");
		//#endif
		//#ifdef RIM_6.0.0
		text.setText("It's 6.0.0");		
		//#endif
		add(text);
	}
	
}
