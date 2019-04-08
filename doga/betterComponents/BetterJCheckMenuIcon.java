package doga.betterComponents;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.plaf.UIResource;

/**
 * "Invisible JCheckBoxMenu check-box.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterJCheckMenuIcon implements Icon, UIResource, Serializable {

	private static final long serialVersionUID = -4238932945559993085L;

	protected int getControlSize() {
		return 13;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		JCheckBoxMenuItem cb = (JCheckBoxMenuItem) c;
		ButtonModel model = cb.getModel();

		if (model.isSelected()) {
			drawCheck(c, g, x, y);
		}
	}

	protected void drawCheck(Component c, Graphics g, int x, int y) {
		int controlSize = getControlSize();
		g.setColor(BetterColors.currentColors[55]);
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