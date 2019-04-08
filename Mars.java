import static doga.betterComponents.LookAndFeelDelegate.setUIConstants;

import mars.venus.VenusUI;

/* This program is edited last by Doga Oruc 31/03/2018 08:20:26 See below for
 * full credits. Copyright (c) 2003-2006, Pete Sanderson and Kenneth Vollmar
 * Developed by Pete Sanderson (psanderson@otterbein.edu) and Kenneth Vollmar
 * (kenvollmar@missouristate.edu) Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following
 * conditions: The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software. THE SOFTWARE
 * IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
 * IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * (MIT license, http://www.opensource.org/licenses/mit-license.html) */

/**
 * Portal to Mars
 * 
 * @author Pete Sanderson
 * @version March 2006
 **/

public class Mars {

	public static void main(String[] args) throws InterruptedException {
		setUIConstants(); // <--- See LookAndFeelDelegate.java
		new mars.MarsLaunch(args);
		Thread.sleep(5000);
		Runnable validatorTask = () -> {
			while (true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				VenusUI.mainUI.revalidate();
				VenusUI.mainUI.repaint();
				// System.out.println("hey, don't shit the bed, i'm here to fix things.\ni'm the
				// validator task!");
			}
		};
		new Thread(validatorTask).start();
	}
}