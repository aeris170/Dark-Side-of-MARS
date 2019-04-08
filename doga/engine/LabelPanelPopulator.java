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

public class LabelPanelPopulator {

	static JPanel populateLabelPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Label Settings"));
		JPanel backGroundColorSettingPanel = new JPanel();
		backGroundColorSettingPanel.setLayout(new BoxLayout(backGroundColorSettingPanel, BoxLayout.Y_AXIS));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		JPanel innerBackgroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		innerBackgroundColorSettingPanel.add(new JLabel("Label Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Label Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[12]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		innerBackgroundColorSettingPanel.add(backgroundColorButton);
		backGroundColorSettingPanel.add(innerBackgroundColorSettingPanel);
		JPanel innerInfoLabelPanel = new JPanel();
		innerInfoLabelPanel.setLayout(new BoxLayout(innerInfoLabelPanel, BoxLayout.Y_AXIS));
		innerInfoLabelPanel.add(new JLabel("Background Color doesn't work,"));
		innerInfoLabelPanel.add(new JLabel("labels are set to transparent"));
		innerInfoLabelPanel.add(new JLabel("for ease of use."));
		backGroundColorSettingPanel.add(innerInfoLabelPanel);
		
		foreGroundColorSettingPanel.add(new JLabel("Label Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Label Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[13]);
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
			Color newColor = JColorChooser.showDialog(null, "Set Color for Label Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[12] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Label Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[13] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
