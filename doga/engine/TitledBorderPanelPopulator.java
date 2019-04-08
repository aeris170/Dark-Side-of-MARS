package doga.engine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import doga.betterComponents.LookAndFeelDelegate;

public class TitledBorderPanelPopulator {

	static JPanel populateTitledBorderPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("TitledBorder Settings"));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel borderSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		foreGroundColorSettingPanel.add(new JLabel("TitledBorder Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TitledBorder Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[82]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);

		UIManager.put("Button.border", BetterBorders.MENU_STANDARD_BORDER);

		borderSettingPanel.add(new JLabel("TitledBorder Border Color:"), FlowLayout.LEFT);
		borderSettingPanel.setBorder(BorderFactory.createTitledBorder("TitledBorder Border"));
		BorderSelectButton menuBorderButton = new BorderSelectButton();
		menuBorderButton.setBackground(borderSettingPanel.getBackground());
		menuBorderButton.setBorder(BetterBorders.currentBorders[8]);
		menuBorderButton.addActionListener(new BorderChanger());
		borderSettingPanel.add(menuBorderButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(foreGroundColorSettingPanel);
		panel.add(borderSettingPanel);
		return panel;
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TitledBorder Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[82] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class BorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TitledBorder Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 2, false);
				button.setBorder(newBorder);
				BetterColors.currentColors[83] = newColor;
				BetterBorders.currentBorders[8] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
