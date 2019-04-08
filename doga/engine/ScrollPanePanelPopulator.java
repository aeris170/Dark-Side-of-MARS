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

public class ScrollPanePanelPopulator {

	static JPanel populateScrollPanePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("ScrollPane Settings"));
		
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel thumbColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel trackColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("ScrollPane Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ScrollPane Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[66]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);
		JPanel innerInfoLabelPanel = new JPanel();
		innerInfoLabelPanel.setLayout(new BoxLayout(innerInfoLabelPanel, BoxLayout.Y_AXIS));
		innerInfoLabelPanel.add(new JLabel("Background Color doesn't work,"));
		innerInfoLabelPanel.add(new JLabel("ScrollPanes are getting their"));
		innerInfoLabelPanel.add(new JLabel("colors from ViewPort by default"));
		innerInfoLabelPanel.add(new JLabel("Go to ViewPort settings to modify"));
		backGroundColorSettingPanel.add(innerInfoLabelPanel);

		thumbColorSettingPanel.add(new JLabel("ScrollBar Thumb Color: "), FlowLayout.LEFT);
		thumbColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ScrollBar Thumb"));
		ColorSelectButton thumbColorButton = new ColorSelectButton();
		thumbColorButton.setBackground(BetterColors.currentColors[69]);
		thumbColorButton.addActionListener(new ThumbChanger());
		thumbColorSettingPanel.add(thumbColorButton);

		trackColorSettingPanel.add(new JLabel("ScrollBar Track Color: "), FlowLayout.LEFT);
		trackColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ScrollBar Track"));
		ColorSelectButton trackColorButton = new ColorSelectButton();
		trackColorButton.setBackground(BetterColors.currentColors[68]);
		trackColorButton.addActionListener(new TrackChanger());
		trackColorSettingPanel.add(trackColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(thumbColorSettingPanel);
		panel.add(trackColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ScrollPane Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[66] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class ThumbChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ScrollBar Thumb Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[69] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class TrackChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ScrollBar Track Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[68] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}