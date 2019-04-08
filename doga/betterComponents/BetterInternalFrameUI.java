package doga.betterComponents;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import mars.venus.VenusUI;

public class BetterInternalFrameUI extends BasicInternalFrameUI {

	public BetterInternalFrameUI(JInternalFrame b) {
		super(b);
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new BetterInternalFrameUI((JInternalFrame) c);
	}
	
	@Override
	public void installUI(JComponent c) {
        UIManager.put("Button.border", BetterBorders.EMPTY);
        UIManager.put("Button.background", BetterColors.INTERNAL_FRAME_TITLE_BG_COLOR);
		super.installUI(c);
        UIManager.put("Button.border", BetterBorders.BUTTON_STANDARD_BORDER);
        UIManager.put("Button.background", BetterColors.BUTTON_BG_COLOR);
        VenusUI.mainUI.validate();
        VenusUI.mainUI.revalidate();
	}
}