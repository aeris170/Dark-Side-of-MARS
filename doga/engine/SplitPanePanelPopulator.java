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

public class SplitPanePanelPopulator {

	static JPanel populateSplitPanePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("ScrollPane Settings"));

		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel foreGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);

		backGroundColorSettingPanel.add(new JLabel("SplitPane Background Color: "), FlowLayout.LEFT);
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("SplitPane Background"));
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[78]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);

		foreGroundColorSettingPanel.add(new JLabel("SplitPane Button Color: "), FlowLayout.LEFT);
		foreGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("SplitPane Button"));
		ColorSelectButton foregroundColorButton = new ColorSelectButton();
		foregroundColorButton.setBackground(BetterColors.currentColors[79]);
		foregroundColorButton.addActionListener(new ButtonColorChanger());
		foreGroundColorSettingPanel.add(foregroundColorButton);

		UIManager.put("Button.border", BetterBorders.currentBorders[1]);

		panel.add(backGroundColorSettingPanel);
		panel.add(foreGroundColorSettingPanel);
		return panel;
	}

	private static class BackgroundChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for SplitPane Global Color", button.getBackground());
			if (newColor != null) {
				Border newBorder = BorderFactory.createLineBorder(newColor, 2, false);
				button.setBackground(newColor);
				BetterColors.currentColors[78] = newColor;
				BetterBorders.currentBorders[7] = newBorder;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}

	private static class ButtonColorChanger implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Color newColor = JColorChooser.showDialog(null, "Set Color for SplitPane Button Color", button.getBackground());
			if (newColor != null) {
				button.setBackground(newColor);
				BetterColors.currentColors[79] = newColor;
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
			}
		}
	}
}
