package doga.engine;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import doga.betterComponents.LookAndFeelDelegate;

public class MenuBarPanelPopulator {

	static JPanel populateMenuBarPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Menu Bar Settings"));

		UIManager.put("Button.border", ColorSelectButton.ColorSelectButtonEnabledBorder);
		
		JPanel backGroundColorSettingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		backGroundColorSettingPanel.setBorder(BorderFactory.createTitledBorder("Menu Bar Background"));
		backGroundColorSettingPanel.add(new JLabel("Menu Bar Background Color: "), FlowLayout.LEFT);
		ColorSelectButton backgroundColorButton = new ColorSelectButton();
		backgroundColorButton.setBackground(BetterColors.currentColors[0]);
		backgroundColorButton.addActionListener(new BackgroundChanger());
		backGroundColorSettingPanel.add(backgroundColorButton);
		
		UIManager.put("Button.border", BetterBorders.currentBorders[1]);
		
		panel.add(backGroundColorSettingPanel);
		return panel;
	}
	
    private static class BackgroundChanger implements ActionListener {
    	
        public void actionPerformed(ActionEvent e) {
          JButton button = (JButton) e.getSource();
          Color newColor = JColorChooser.showDialog(null, "Set Color for Menu Bar Background Color", button.getBackground());
          if (newColor != null) {
             button.setBackground(newColor);
             BetterColors.currentColors[0] = newColor; //[0] is menu bar bg color
             LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
          }
       }
    }
}
