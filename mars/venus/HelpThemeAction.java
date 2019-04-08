package mars.venus;
import mars.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
	/*
Copyright (c) 2018,  Doða Oruç
	
 /**
 * Action  for the Help -> About menu item
 */   			
 public class HelpThemeAction extends GuiAction {
    public  HelpThemeAction(String name, Icon icon, String descrip,
                          Integer mnemonic, KeyStroke accel, VenusUI gui) {
      super(name, icon, descrip, mnemonic, accel, gui);
   }
		  
    public void actionPerformed(ActionEvent e){
       JOptionPane.showMessageDialog(mainUI,
			              "MARS "+Globals.version+"    Copyright "+Globals.themeCopyrightYears+"\n"+
							  Globals.themeCopyrightHolder+"\n"+
							  "DSOM is the Dark Side of MARS\n\n"+
							  "Slider Thumb Icon from:\n" +
							  "  *  Forums of RCTgo (https://forums.rctgo.com/thread-6027.html),\n"+
							  "Red Exclamation Mark Icon from:\n" +
							  "  *  Icon Finder, User: Aha-Soft\n" + 
							  "(https://www.iconfinder.com/aha-soft)",
							  "About Theme",
							  JOptionPane.INFORMATION_MESSAGE,
							  new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Globals.imagesPath+"RedMars50.gif"))));
   }
}
