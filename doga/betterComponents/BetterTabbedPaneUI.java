package doga.betterComponents;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/**
 * UI for TabbedPane, the aim is changing the tabbed-pane's tab's appearence.
 * They are now rectangular instead of a trapezoid. This is not complete, as the
 * selected tab's foreground color must be set to
 * BetterColors.TABBED_PANE_SELECTED_BG_COLOR, yet I couldn't get it to work.
 * UPDATE: I removed BetterColors.TABBED_PANE_SELECTED_BG_COLOR for conveniecny
 * purposes. Please add it back if you want to experiment.
 * 
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterTabbedPaneUI extends BasicTabbedPaneUI {

	public static ComponentUI createUI(JComponent c) {
		return new BetterTabbedPaneUI();
	}

	@Override
	protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
		if (isSelected) {
			g.setColor(BetterColors.currentColors[72]);
		} else {
			g.setColor(BetterColors.currentColors[75]);
		}
		g.fillRect(x, y, width, height);
	}

	@Override
	protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
		return super.calculateTabWidth(tabPlacement, tabIndex, metrics) + 24;
	}

	@Override
	protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
		if (tabPlacement == LEFT || tabPlacement == RIGHT) {
			return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight);
		} else {
			return super.calculateTabHeight(tabPlacement, tabIndex, fontHeight) + 2;
		}
	}

	@Override
	protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int width, int height, boolean isSelected) {
		g.setColor(BetterColors.currentColors[76]);
		g.drawRect(x, y, width, height);
	}
}
