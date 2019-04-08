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

public class PanelPanelPopulator {

	static JPanel populatePanelPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Panel Settings"));
		JPanel backGroundColorSettingPanel = new JPanel();
		backGroundColorSettingPanel.setLayout(new BoxLayout(backGroundColorSettingPanel, BoxLayout.Y_AXIS));
		JPanel foreGroundColorSettingPanel = new JPanel();
		foreGroundColorSettingPanel.setLayout(new BoxLayout(foreGroundColorSettingPanel, BoxLayout.Y_AXIS));
		
		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		JPanel innerBackgroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		innerBackgroundColorSettingPanel.add(new JLabel("Panel Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Panel Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[64]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		innerBackgroundColorSettingPanel.add(backgroundColorButton);
		backGroundColorSettingPanel.add(innerBackgroundColorSettingPanel);

		JPanel innerForegroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		innerForegroundColorSettingPanel.add(new JLabel("Panel Foreground Color: "), FlowLayout.LEFT);
		innerForegroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Panel Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[65]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		innerForegroundColorSettingPanel.add(foregroundColorButton);
		backGroundColorSettingPanel.add(innerForegroundColorSettingPanel);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Panel Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[64] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Panel Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[65] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}