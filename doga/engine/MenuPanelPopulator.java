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
import javax.swing.border.EtchedBorder;

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import doga.betterComponents.LookAndFeelDelegate;

public class MenuPanelPopulator {

	static JPanel populateMenuPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Menu Settings"));
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionBackgroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel selectionForegroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel menuBorderSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("Menu Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[1]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("Menu Foreground Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Foreground"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[2]);
		foregroundColorButton.addActionListener(new ForegroundChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);

		selectionBackgroundColorSettingPanel.add(new JLabel("Menu Selection Background Color: "), FlowLayout.LEFT);
		selectionBackgroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Selection Background"));
		ColorSelectButton selectionBackgroundColorButton = new ColorSelectButton();
		selectionBackgroundColorButton.setBackground(BetterColors.currentColors[3]);
		selectionBackgroundColorButton.addActionListener(new SelectionBackgroundChanger());
		selectionBackgroundColorSettingPanel.add(selectionBackgroundColorButton);

		selectionForegroundColorSettingPanel.add(new JLabel("Menu Selection Foreground Color: "), FlowLayout.LEFT);
		selectionForegroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Selection Foreground"));
		ColorSelectButton selectionForegroundColorButton = new ColorSelectButton();
		selectionForegroundColorButton.setBackground(BetterColors.currentColors[4]);
		selectionForegroundColorButton.addActionListener(new SelectionForegroundChanger());
		selectionForegroundColorSettingPanel.add(selectionForegroundColorButton);

		UIManager.put("Button.border", BetterBorders.MENU_STANDARD_BORDER);

		menuBorderSettingPanel.add(new JLabel("Menu Border: "), FlowLayout.LEFT);
		menuBorderSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Border"));
		BorderSelectButton menuBorderButton = new BorderSelectButton();
		menuBorderButton.setBackground(menuBorderSettingPanel.getBackground());
		menuBorderButton.setBorder(BetterBorders.currentBorders[0]);
		menuBorderButton.addActionListener(new BorderChanger());
		menuBorderSettingPanel.add(menuBorderButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		panel.add(selectionBackgroundColorSettingPanel);
		panel.add(selectionForegroundColorSettingPanel);
		panel.add(menuBorderSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[1] = newColor; //[1] is menu bg color
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[2] = newColor; //[2] is menu fg color
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class SelectionBackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Selection Background Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[3] = newColor; //[3] is menu sel bg color
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class SelectionForegroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Selection Foreground Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[4] = newColor; //[4] is menu sel fg color
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class BorderChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Border Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, newColor, newColor);
				button.setBorder(newBorder);
				BetterColors.currentColors[5] = newColor; //[5] is menu border color
				BetterBorders.currentBorders[0] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
