package doga.betterComponents;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * Custom combo-box ui, it changes the combo-box's arrow.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterComboArrow extends BasicComboBoxUI {

	public static BetterComboArrow createUI(JComponent c) {
		return new BetterComboArrow();
	}

	@Override
	protected JButton createArrowButton() {
		return new BasicArrowButton(SwingConstants.SOUTH, BetterColors.currentColors[32], BetterColors.currentColors[35], BetterColors.currentColors[36], BetterColors.currentColors[37]);
	}
}
