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

public class TXTFieldPanelPopulator {


	static JPanel populateTXTFieldPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("TXTField Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel disabledBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel disabledForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel borderColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("TXTField Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTField Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[38]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("TXTField Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTField Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[39]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionBackGroundColorSettingPanel.add(new JLabel("TXTField Selection Background Color: "), FlowLayout.LEFT);
		selectionBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTField Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[40]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackGroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForeGroundColorSettingPanel.add(new JLabel("TXTField Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTField Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[41]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);

		disabledBackGroundColorSettingPanel.add(new JLabel("TXTField Disabled Background Color: "), FlowLayout.LEFT);
		disabledBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Disabled Background"));
		ColorSelectButton disabledBackGroundColorButton = new ColorSelectButton();
		disabledBackGroundColorButton.setBackground(BetterColors.currentColors[43]);
		disabledBackGroundColorButton.addActionListener(new DisabledBackgroundChanger());
		disabledBackGroundColorSettingPanel.add(disabledBackGroundColorButton);
		
		disabledForeGroundColorSettingPanel.add(new JLabel("TXTField Disabled Foreground Color: "), FlowLayout.LEFT);
		disabledForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("ComboBox Disabled Foreground"));
		ColorSelectButton disabledForeGroundColorButton = new ColorSelectButton();
		disabledForeGroundColorButton.setBackground(BetterColors.currentColors[44]);
		disabledForeGroundColorButton.addActionListener(new DisabledForegroundChanger());
		disabledForeGroundColorSettingPanel.add(disabledForeGroundColorButton);
		
		borderColorSettingPanel.add(new JLabel("TXTField Border Color: "), FlowLayout.LEFT);
		borderColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTField Border"));
		ColorSelectButton borderColorButton = new ColorSelectButton();
		borderColorButton.setBackground(borderColorSettingPanel.getBackground());
		borderColorButton.setBorder(BetterBorders.currentBorders[5]);
		borderColorButton.addActionListener(new BorderChanger());
		borderColorSettingPanel.add(borderColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackGroundColorSettingPanel);
		panel.add(selectionForeGroundColorSettingPanel);
		panel.add(disabledBackGroundColorSettingPanel);
		panel.add(disabledForeGroundColorSettingPanel);
		panel.add(borderColorSettingPanel);
		return panel;
	}
	

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[38] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[39] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[40] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[41] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class DisabledBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Disabled Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[43] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class DisabledForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Disabled Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[44] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class BorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTField Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 2, false);
				button.setBorder(newBorder);
				BetterColors.currentColors[42] = newColor;
				BetterBorders.currentBorders[5] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
