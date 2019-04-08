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
import mars.venus.SettingsHighlightingAction;
import mars.venus.VenusUI;

public class TablePanelPopulator {
	
	static JPanel populateTablePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Table Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel tableBackgroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel gridColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel headerBorderColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel cellBorderColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("TableHeader Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TableHeader Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[86]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("TableHeader Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TableHeader Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[87]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		gridColorSettingPanel.add(new JLabel("Table Grid Color: "), FlowLayout.LEFT);
		gridColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Table Grid"));
		ColorSelectButton gridColorButton = new ColorSelectButton();
		gridColorButton.setBackground(BetterColors.currentColors[84]);
		gridColorButton.addActionListener(new GridColorChanger());
		gridColorSettingPanel.add(gridColorButton);
		
		headerBorderColorSettingPanel.add(new JLabel("TableHeader Border Color: "), FlowLayout.LEFT);
		headerBorderColorSettingPanel.setBorder(BorderFactory.createTitledBorder("TableHeader Border"));
		ColorSelectButton headerBorderColorButton = new ColorSelectButton();
		headerBorderColorButton.setBackground(headerBorderColorSettingPanel.getBackground());
		headerBorderColorButton.setBorder(BetterBorders.currentBorders[10]);
		headerBorderColorButton.addActionListener(new HeaderBorderChanger());
		headerBorderColorSettingPanel.add(headerBorderColorButton);
		
		cellBorderColorSettingPanel.add(new JLabel("Table FocusCell Border Color: "), FlowLayout.LEFT);
		cellBorderColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Table FocusCell Border"));
		ColorSelectButton cellBorderColorButton = new ColorSelectButton();
		cellBorderColorButton.setBackground(cellBorderColorSettingPanel.getBackground());
		cellBorderColorButton.setBorder(BetterBorders.currentBorders[9]);
		cellBorderColorButton.addActionListener(new CellBorderChanger());
		cellBorderColorSettingPanel.add(cellBorderColorButton);
		
		tableBackgroundColorSettingPanel.add(new JLabel("Table Cell Background/Foreground Color: "), FlowLayout.LEFT);
		tableBackgroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Table Cell Colors"));
		JButton tableBackgroundColorButton = new JButton("Color Picker");
		tableBackgroundColorButton.addActionListener(new SettingsHighlightingAction("Highlighting...", null, "View and modify Execute Tab highlighting colors", null,null, VenusUI.mainUI));
		tableBackgroundColorSettingPanel.add(tableBackgroundColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);
		
		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(gridColorSettingPanel);
		panel.add(headerBorderColorSettingPanel);
		panel.add(cellBorderColorSettingPanel);
		panel.add(tableBackgroundColorSettingPanel);
		
		return panel;
	}
	
	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TableHeader Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[86] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TableHeader Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[87] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class GridColorChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Table Grid Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[84] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class HeaderBorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for TableHeader Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 1, true);
				button.setBorder(newBorder);
				BetterColors.currentColors[88] = newColor;
				BetterBorders.currentBorders[10] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class CellBorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Table FocusCell Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 2, true);
				button.setBorder(newBorder);
				BetterColors.currentColors[85] = newColor;
				BetterBorders.currentBorders[9] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}