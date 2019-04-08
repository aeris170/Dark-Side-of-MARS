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

public class MenuItemPanelPopulator {

	static JPanel populateMenuItemPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("MenuItem Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackgroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForegroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("MenuItem Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("MenuItem Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[6]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("MenuItem Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("MenuItem Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[7]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);

		selectionBackgroundColorSettingPanel.add(new JLabel("MenuItem Selection Background Color: "), FlowLayout.LEFT);
		selectionBackgroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("MenuItem Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[8]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackgroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForegroundColorSettingPanel.add(new JLabel("MenuItem Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForegroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("MenuItem Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[9]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForegroundColorSettingPanel.add(selectionForegroundColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackgroundColorSettingPanel);
		panel.add(selectionForegroundColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for MenuItem Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[6] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for MenuItem Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[7] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for MenuItem Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[8] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for MenuItem Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[9] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
