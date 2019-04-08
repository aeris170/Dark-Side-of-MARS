package doga.betterComponents;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.plaf.UIResource;

/**
 * Red JCheckBox.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterJCheckIcon implements Icon, UIResource, Serializable {

	private static final long serialVersionUID = 2482033063470071020L;

	protected int getControlSize() {
		return 13;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		JCheckBox cb = (JCheckBox) c;
		ButtonModel model = cb.getModel();
		int controlSize = getControlSize();

		if (model.isEnabled()) {
			g.setColor(BetterColors.currentColors[25]);
			g.fillRect(x, y, controlSize - 1, controlSize - 1);
			g.setColor(BetterColors.currentColors[26]);
		}

		if (model.isSelected()) {
			drawCheck(c, g, x, y);
		}
	}

	protected void drawCheck(Component c, Graphics g, int x, int y) {
		int controlSize = getControlSize();
		g.fillRect(x + 3, y + 5, 2, controlSize - 8);
		g.drawLine(x + (controlSize - 4), y + 3, x + 5, y + (controlSize - 6));
		g.drawLine(x + (controlSize - 4), y + 4, x + 5, y + (controlSize - 5));
	}

	public int getIconWidth() {
		return getControlSize();
	}

	public int getIconHeight() {
		return getControlSize();
	}
}