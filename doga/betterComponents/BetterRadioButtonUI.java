package doga.betterComponents;

import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicButtonUI;


/**
 * Red RadioButtons.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterRadioButtonUI extends BasicButtonUI {

	public static Icon selected = ColorUtils.bufferedImage2ImageIcon(ColorUtils.rotateColors(ColorUtils.imageIcon2BufferedImage(new ImageIcon(BetterSliderUI.class.getResource("/images/RadioButtonSelected.png"))), BetterColors.RADIO_BUTTON_BUTTON_BG_COLOR));
	public static Icon notSelected = ColorUtils.bufferedImage2ImageIcon(ColorUtils.rotateColors(ColorUtils.imageIcon2BufferedImage(new ImageIcon(BetterSliderUI.class.getResource("/images/RadioButtonNotSelected.png"))), BetterColors.RADIO_BUTTON_BUTTON_FG_COLOR));

	public static BetterRadioButtonUI createUI(JComponent c) {
		((JRadioButton) c).setIcon(notSelected);
		((JRadioButton) c).setSelectedIcon(selected);
		return new BetterRadioButtonUI();
	}
}
