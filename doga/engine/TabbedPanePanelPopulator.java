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

public class TabbedPanePanelPopulator {

	static JPanel populateTabbedPanePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("TabbedPane Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel extraColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("TabbedPane Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TabbedPane Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[72]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("TabbedPane Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TabbedPane Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[73]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionForeGroundColorSettingPanel.add(new JLabel("TabbedPane Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TabbedPane Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[74]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);
		
		extraColorSettingPanel.add(new JLabel("TabbedPane Inner Border Color: "), FlowLayout.LEFT);
		extraColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TabbedPane Inner Border Color"));
		ColorSelectButton extraColorButton = new ColorSelectButton();
		extraColorButton.setBackground(BetterColors.currentColors[77]);
		extraColorButton.addActionListener(new ExtraColorsChanger());
		extraColorSettingPanel.add(extraColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionForeGroundColorSettingPanel);
		panel.add(extraColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TabbedPane Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[72] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TabbedPane Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[73] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TabbedPane Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[74] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class ExtraColorsChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TabbedPane Border Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[77] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
