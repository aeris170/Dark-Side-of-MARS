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

public class CheckBoxMenuItemPanelPopulator {

	static JPanel populateCheckBoxMenuItemPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel iconColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[51]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[52]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionBackGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Selection Background Color: "), FlowLayout.LEFT);
		selectionBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[53]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackGroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForeGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[54]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);
		
		iconColorSettingPanel.add(new JLabel("CheckBoxmenuItem Tick Color: "), FlowLayout.LEFT);
		iconColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Tick"));
		ColorSelectButton iconColorButton = new ColorSelectButton();
		iconColorButton.setBackground(BetterColors.currentColors[55]);
		iconColorButton.addActionListener(new IconChanger());
		iconColorSettingPanel.add(iconColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		
		panel.add(iconColorSettingPanel);
		return panel;
	}


	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for CheckBoxmenuItem Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[51] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for CheckBoxmenuItem Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[52] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for CheckBoxmenuItem Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[53] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for CheckBoxmenuItem Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[54] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class IconChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for CheckBoxmenuItem Tick Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[55] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}