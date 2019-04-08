   package mars.venus;
   import mars.*;

import javax.imageio.ImageIO;
import javax.swing.*;
   import javax.swing.event.*;

import doga.betterComponents.BetterSliderUI;

import java.awt.*;
   import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
	
	/*
Copyright (c) 2003-2006,  Pete Sanderson and Kenneth Vollmar

Developed by Pete Sanderson (psanderson@otterbein.edu)
and Kenneth Vollmar (kenvollmar@missouristate.edu)

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
"Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject 
to the following conditions:

The above copyright notice and this permission notice shall be 
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

(MIT license, http://www.opensource.org/licenses/mit-license.html)
 */
	
	/**
	 * Class for the Run speed slider control.  One is created and can be obtained using
	 * getInstance().
	 *
	 * @author Pete Sanderson
	 * @version August 2005
	 */
	 
    public class RunSpeedPanel extends JPanel {
	 /** Constant that represents unlimited run speed.  Compare with return value of
	  *  getRunSpeed() to determine if set to unlimited.  At the unlimited setting, the GUI
	  *  will not attempt to update register and memory contents as each instruction
	  *  is executed.  This is the only possible value for command-line use of Mars. */
      public final static double UNLIMITED_SPEED = 40;
		
      private final static int SPEED_INDEX_MIN = 0;
      private final static int SPEED_INDEX_MAX = 40;
      private final static int SPEED_INDEX_INIT = 40;
      private static final int SPEED_INDEX_INTERACTION_LIMIT = 35;		
      private double[] speedTable = { 
               .05, .1, .2, .3, .4, .5,  1,  2,  3,  4,  5,      // 0-10
                     6,  7,  8,  9, 10, 11, 12, 13, 14, 15,      // 11-20
                    16, 17, 18, 19, 20, 21, 22, 23, 24, 25,      // 21-30
                    26, 27, 28, 29, 30, UNLIMITED_SPEED,UNLIMITED_SPEED, // 31-37
         			  UNLIMITED_SPEED,UNLIMITED_SPEED,UNLIMITED_SPEED // 38-40
         		};	 													 													 
      private JLabel sliderLabel=null;
      private JSlider runSpeedSlider=null;
      private JPanel gaugePanel = null;
      private static RunSpeedPanel runSpeedPanel=null;
      private volatile int runSpeedIndex = SPEED_INDEX_MAX;
      
   	/**
   	 * Retrieve the run speed panel object
   	 *
   	 * @return the run speed panel
   	 */
   		 
       public static RunSpeedPanel getInstance() {
         if (runSpeedPanel==null) {
            runSpeedPanel = new RunSpeedPanel();
				Globals.runSpeedPanelExists = true; // DPS 24 July 2008 (needed for standalone tools)
         }
         return runSpeedPanel;
      }
   	
   	/*
   	 * private constructor (this is a singleton class)
   	 */
       private RunSpeedPanel() {
         super();
         this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
         runSpeedSlider = new JSlider(JSlider.HORIZONTAL, SPEED_INDEX_MIN,SPEED_INDEX_MAX,SPEED_INDEX_INIT);/*
         runSpeedSlider.setSize(new Dimension(100,(int)runSpeedSlider.getSize().getHeight()));
         runSpeedSlider.setMaximumSize(runSpeedSlider.getSize());
         runSpeedSlider.setMajorTickSpacing(5); 
         runSpeedSlider.setPaintTicks(true); //Create the label table */
         runSpeedSlider.addChangeListener(new RunSpeedListener());
         sliderLabel = new JLabel(setLabel(runSpeedIndex));
         sliderLabel.setHorizontalAlignment(JLabel.CENTER);
         sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         gaugePanel = new JPanel(){
             @Override
             public void paintComponent(Graphics g) {
          	   super.paintComponent(g);
          	   if(runSpeedSlider.getValue() > 35) {
          		   try {
      				g.drawImage(ImageIO.read(getClass().getResource("/images/volumeSliderThumbOLD.png")), 0, 0, null);
      			} catch (IOException e) {
      				e.printStackTrace();
      			}
          	   }
             }
         };
         this.add(runSpeedSlider);
         this.add(sliderLabel);
         this.add(gaugePanel);
			this.setToolTipText("Simulation speed for \"Go\".  At "+
			       ((int)speedTable[SPEED_INDEX_INTERACTION_LIMIT])+" inst/sec or less, tables updated "+
					 "after each instruction.");
      }
   	
   	/**
   	 * returns current run speed setting, in instructions/second.  Unlimited speed
   	 * setting is equal to RunSpeedPanel.UNLIMITED_SPEED
   	 * 
   	 * @return run speed setting in instructions/second.  
   	 */
   	 
       public double getRunSpeed() {
         return speedTable[runSpeedIndex]; 
      }
   	
   	/*
   	 * set label wording depending on current speed setting
   	 */
       private String setLabel(int index) {
         String result = "Run speed ";; 
         if (index <= SPEED_INDEX_INTERACTION_LIMIT) {
            if (speedTable[index] < 1) {
               result +=  speedTable[index];
            } 
            else {
               result += ((int)speedTable[index]);
            }
            result += " inst/sec  ";
         } 
         else {
            result += ("∞ (may crash)  ");		 
         }
         return result;
      }
   	
   	
   	/*
   	 *  Both revises label as user slides and updates current index when sliding stops.
   	 */
   	 
       private class RunSpeedListener implements ChangeListener {
          public void stateChanged(ChangeEvent e) { 
            JSlider source = (JSlider)e.getSource(); 
            if (!source.getValueIsAdjusting()) { 
               runSpeedIndex = (int)source.getValue();
            } 
            else {
               sliderLabel.setText(setLabel(source.getValue()));
            }
         } 
      }
   }