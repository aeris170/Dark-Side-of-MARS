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

public class TXTAreaPanelPopulator {

	static JPanel populateTXTAreaPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("TXTArea Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel inactiveBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel inactiveForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel borderColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("TXTArea Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[45]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("TXTArea Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[46]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionBackGroundColorSettingPanel.add(new JLabel("TXTArea Selection Background Color: "), FlowLayout.LEFT);
		selectionBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[47]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackGroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForeGroundColorSettingPanel.add(new JLabel("TXTArea Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[48]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);
		
		inactiveForeGroundColorSettingPanel.add(new JLabel("TXTArea Inactive Foreground Color: "), FlowLayout.LEFT);
		inactiveForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Inactive Foreground"));
		ColorSelectButton inactiveForeGroundColorButton = new ColorSelectButton();
		inactiveForeGroundColorButton.setBackground(BetterColors.currentColors[50]);
		inactiveForeGroundColorButton.addActionListener(new InactiveForegroundChanger());
		inactiveForeGroundColorSettingPanel.add(inactiveForeGroundColorButton);
		
		borderColorSettingPanel.add(new JLabel("TXTArea Border Color: "), FlowLayout.LEFT);
		borderColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TXTArea Border"));
		ColorSelectButton borderColorButton = new ColorSelectButton();
		borderColorButton.setBackground(borderColorSettingPanel.getBackground());
		borderColorButton.setBorder(BetterBorders.currentBorders[6]);
		borderColorButton.addActionListener(new BorderChanger());
		borderColorSettingPanel.add(borderColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackGroundColorSettingPanel);
		panel.add(selectionForeGroundColorSettingPanel);
		panel.add(inactiveBackGroundColorSettingPanel);
		panel.add(inactiveForeGroundColorSettingPanel);
		panel.add(borderColorSettingPanel);
		return panel;
	}
	

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[45] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[46] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[47] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[48] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class InactiveForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Inactive Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[50] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class BorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TXTArea Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 2, false);
				button.setBorder(newBorder);
				BetterColors.currentColors[49] = newColor;
				BetterBorders.currentBorders[6] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
