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

public class EditorPanePanelPopulator {

	public static JPanel populateEditorPanePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("EditorPane Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForeGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("EditorPane Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("EditorPane Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[91]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("EditorPane Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("EditorPane Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[92]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);
		
		selectionBackGroundColorSettingPanel.add(new JLabel("EditorPane Selection Background Color: "), FlowLayout.LEFT);
		selectionBackGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("EditorPane Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[93]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackGroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForeGroundColorSettingPanel.add(new JLabel("EditorPane Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForeGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("EditorPane Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[94]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForeGroundColorSettingPanel.add(selectionForegroundColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackGroundColorSettingPanel);
		panel.add(selectionForeGroundColorSettingPanel);
		return panel;
	}
	

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for EditorPane Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[91] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for EditorPane Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[92] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for EditorPane Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[93] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
	
	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for EditorPane Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[94] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
