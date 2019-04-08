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

public class ComboBoxPanelPopulator {

	static JPanel populateComboBoxPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("ComboBox Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel disabledBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel disabledForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("ComboBox Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[27]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("ComboBox Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[28]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionBackGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Selection Background Color: "), FlowLayout.LEFT);
		selectionBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[29]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackGroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForeGroundColorSettingPanel.add(new JLabel("CheckBoxmenuItem Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("CheckBoxmenuItem Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[30]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);
		
		disabledBackGroundColorSettingPanel.add(new JLabel("ComboBox Disabled Background Color: "), FlowLayout.LEFT);
		disabledBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Disabled Background"));
		ColorSelectButton disabledBackGroundColorButton = new ColorSelectButton();
		disabledBackGroundColorButton.setBackground(BetterColors.currentColors[33]);
		disabledBackGroundColorButton.addActionListener(new DisabledBackgroundChanger());
		disabledBackGroundColorSettingPanel.add(disabledBackGroundColorButton);
		
		disabledForeGroundColorSettingPanel.add(new JLabel("ComboBox Disabled Foreground Color: "), FlowLayout.LEFT);
		disabledForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Disabled Foreground"));
		ColorSelectButton disabledForeGroundColorButton = new ColorSelectButton();
		disabledForeGroundColorButton.setBackground(BetterColors.currentColors[34]);
		disabledForeGroundColorButton.addActionListener(new DisabledForegroundChanger());
		disabledForeGroundColorSettingPanel.add(disabledForeGroundColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackGroundColorSettingPanel);
		panel.add(selectionForeGroundColorSettingPanel);
		panel.add(disabledBackGroundColorSettingPanel);
		panel.add(disabledForeGroundColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[27] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[28] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[29] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[30] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class DisabledBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Disabled Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[33] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class DisabledForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for ComboBox Disabled Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[34] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
