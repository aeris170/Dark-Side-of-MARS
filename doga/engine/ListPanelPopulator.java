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

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import doga.betterComponents.LookAndFeelDelegate;

public class ListPanelPopulator {

	static JPanel populateListPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("List Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("List Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("List Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[98]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("List Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("List Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[99]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		return panel;
	}
	
	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for List Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[98] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for List Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[99] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
