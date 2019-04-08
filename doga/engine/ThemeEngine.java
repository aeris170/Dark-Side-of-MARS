package doga.engine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import doga.betterComponents.CustomLookAndFeel;
import doga.betterComponents.LookAndFeelDelegate;
import mars.venus.GuiAction;
import mars.venus.VenusUI;

public class ThemeEngine extends GuiAction {

	private static final long serialVersionUID = -2019616118163977781L;

	public static JFrame frame;

	public static JTabbedPane pane;

	private static JPanel menuBar, menu, menuItem, separator, checkBoxMenuItem, // PANEL
																				// 1
																				// MENU
																				// SETTINGS
			button, checkBox, comboBox, // PANEL 2 BUTTON SETTINGS
			txtField, txtArea, label, toolTip, optionPane, // PANEL 3 TXT
															// CONTAINER
															// SETTINGS
			viewPort, tabbedPane, tableNTableHeader, // PANEL 4 TABBEDPANE
														// SETTINGS
			scrollPane, splitPane, editorPane, // PANEL 5 S-S-E PANE SETTINGS
			panel, toolBar, list, // PANEL 6 MISC SETTINS
			internalFrame, slider, titledBorder; // PANEL 7 MISC 2 SETTINS

	public ThemeEngine(String name, Icon icon, String descrip, Integer mnemonic, KeyStroke accel, VenusUI gui) {
		super(name, icon, descrip, mnemonic, accel, gui);
		frame = new JFrame("Theme Engine");
		pane = populateAllPanels();
		frame.add(pane);
		frame.setResizable(false);
		frame.setLocation(120, 120);
		frame.addWindowListener(new exitListener());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.validate();
		frame.revalidate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(true);
	}

	private static JTabbedPane populateAllPanels() {
		JTabbedPane pane = new JTabbedPane();

		JPanel menuRelatedSettings = new JPanel();
		menuRelatedSettings.setLayout(new BoxLayout(menuRelatedSettings, BoxLayout.Y_AXIS));
		JPanel boxNButtonRelatedSettings = new JPanel();
		boxNButtonRelatedSettings.setLayout(new BoxLayout(boxNButtonRelatedSettings, BoxLayout.Y_AXIS));
		JPanel textContainerRelatedSettings = new JPanel();
		textContainerRelatedSettings.setLayout(new BoxLayout(textContainerRelatedSettings, BoxLayout.Y_AXIS));
		JPanel tabbedPaneNTableRelatedSettings = new JPanel();
		tabbedPaneNTableRelatedSettings.setLayout(new BoxLayout(tabbedPaneNTableRelatedSettings, BoxLayout.Y_AXIS));
		JPanel panesRelatedSettings = new JPanel();
		panesRelatedSettings.setLayout(new BoxLayout(panesRelatedSettings, BoxLayout.Y_AXIS));
		JPanel miscSettings = new JPanel();
		miscSettings.setLayout(new BoxLayout(miscSettings, BoxLayout.Y_AXIS));
		JPanel misc2Settings = new JPanel();
		misc2Settings.setLayout(new BoxLayout(misc2Settings, BoxLayout.Y_AXIS));
		JPanel saveLoadExit = new JPanel();
		saveLoadExit.setLayout(new GridLayout(12, 4));

		JPanel innerMenuPanel = new JPanel(new GridLayout(2, 1));
		menuBar = MenuBarPanelPopulator.populateMenuBarPanel();
		innerMenuPanel.add(menuBar);
		menu = MenuPanelPopulator.populateMenuPanel();
		innerMenuPanel.add(menu);
		menuItem = MenuItemPanelPopulator.populateMenuItemPanel();
		innerMenuPanel.add(menuItem);
		separator = SeparatorPanelPopulator.populateSeparatorPanel();
		innerMenuPanel.add(separator);
		checkBoxMenuItem = CheckBoxMenuItemPanelPopulator.populateCheckBoxMenuItemPanel();
		innerMenuPanel.add(checkBoxMenuItem);
		innerMenuPanel.add(ExamleComponentProvider.provideCompleteMenu());
		menuRelatedSettings.add(innerMenuPanel);
		menuRelatedSettings.add(createWarningLabel());

		JPanel innerBoxNButtonPanel = new JPanel(new GridLayout(2, 1));
		button = ButtonPanelPopulator.populateButtonPanel();
		innerBoxNButtonPanel.add(button);
		checkBox = CheckBoxPanelPopulator.populateCheckBoxPanel();
		innerBoxNButtonPanel.add(checkBox);
		comboBox = ComboBoxPanelPopulator.populateComboBoxPanel();
		innerBoxNButtonPanel.add(comboBox);
		innerBoxNButtonPanel.add(ExamleComponentProvider.provideCompleteBoxNButton());
		boxNButtonRelatedSettings.add(innerBoxNButtonPanel);
		boxNButtonRelatedSettings.add(createWarningLabel());

		JPanel innerTXTContainerPanel = new JPanel(new GridLayout(2, 1));
		txtArea = TXTAreaPanelPopulator.populateTXTAreaPanel();
		innerTXTContainerPanel.add(txtArea);
		txtField = TXTFieldPanelPopulator.populateTXTFieldPanel();
		innerTXTContainerPanel.add(txtField);
		label = LabelPanelPopulator.populateLabelPanel();
		innerTXTContainerPanel.add(label);
		toolTip = ToolTipPanelPopulator.populateToolTipPanel();
		innerTXTContainerPanel.add(toolTip);
		optionPane = OptionPanePanelPopulator.populateOptionPanePanel();
		innerTXTContainerPanel.add(optionPane);
		innerTXTContainerPanel.add(ExamleComponentProvider.provideCompleteTXTContainer());
		textContainerRelatedSettings.add(innerTXTContainerPanel);
		textContainerRelatedSettings.add(createWarningLabel());

		JPanel inneTabbedPaneNTablePanel = new JPanel(new GridLayout(2, 1));
		viewPort = ViewPortPanelPopulator.populateViewPortPanel();
		inneTabbedPaneNTablePanel.add(viewPort);
		tabbedPane = TabbedPanePanelPopulator.populateTabbedPanePanel();
		inneTabbedPaneNTablePanel.add(tabbedPane);
		tableNTableHeader = TablePanelPopulator.populateTablePanel();
		inneTabbedPaneNTablePanel.add(tableNTableHeader);
		inneTabbedPaneNTablePanel.add(ExamleComponentProvider.provideCompleteTabbedPaneWithTable());
		tabbedPaneNTableRelatedSettings.add(inneTabbedPaneNTablePanel);
		tabbedPaneNTableRelatedSettings.add(createWarningLabel());

		JPanel innerPanesPanel = new JPanel(new GridLayout(2, 1));
		scrollPane = ScrollPanePanelPopulator.populateScrollPanePanel();
		innerPanesPanel.add(scrollPane);
		splitPane = SplitPanePanelPopulator.populateSplitPanePanel();
		innerPanesPanel.add(splitPane);
		editorPane = EditorPanePanelPopulator.populateEditorPanePanel();
		innerPanesPanel.add(editorPane);
		innerPanesPanel.add(ExamleComponentProvider.provideCompleteAllPanes());
		panesRelatedSettings.add(innerPanesPanel);
		panesRelatedSettings.add(createWarningLabel());

		JPanel innerMiscPanel = new JPanel(new GridLayout(2, 1));
		panel = PanelPanelPopulator.populatePanelPanel();
		innerMiscPanel.add(panel);
		toolBar = ToolBarPanelPopulator.populateToolBarPanel();
		innerMiscPanel.add(toolBar);
		list = ListPanelPopulator.populateListPanel();
		innerMiscPanel.add(list);
		innerMiscPanel.add(ExamleComponentProvider.provideCompleteMisc());
		miscSettings.add(innerMiscPanel);
		miscSettings.add(createWarningLabel());

		JPanel innerMisc2Panel = new JPanel(new GridLayout(2, 1));
		internalFrame = InternalFramePanelPopulator.populateInternalFramePanel();
		innerMisc2Panel.add(internalFrame);
		slider = SliderPanelPopulator.populateSliderPanel();
		innerMisc2Panel.add(slider);
		titledBorder = TitledBorderPanelPopulator.populateTitledBorderPanel();
		innerMisc2Panel.add(titledBorder);
		innerMisc2Panel.add(ExamleComponentProvider.provideCompleteMisc2());
		misc2Settings.add(innerMisc2Panel);
		misc2Settings.add(createWarningLabel());

		JPanel innerPanel1 = new JPanel();
		JPanel innerPanel2 = new JPanel();
		JPanel innerPanel3 = new JPanel();
		JPanel innerPanel4 = new JPanel();
		JButton saveSettings = new JButton("Save Settings and Exit");
		saveSettings.addActionListener(new SaveTheme());
		innerPanel1.add(saveSettings);
		JButton loadDEFA = new JButton("Load Default MARS");
		loadDEFA.addActionListener(new LoadLightTheme());
		innerPanel2.add(loadDEFA);
		JButton loadDSOM = new JButton("Load Dark Side of MARS");
		loadDSOM.addActionListener(new LoadDarkTheme());
		innerPanel3.add(loadDSOM);
		JButton exitWithoutSaving = new JButton("Exit without saving");
		exitWithoutSaving.addActionListener(new ExitWithoutSaving());
		innerPanel4.add(exitWithoutSaving);
		for (int i = 0; i < 24; i++) {
			saveLoadExit.add(new JLabel());
		}
		saveLoadExit.add(innerPanel1);
		saveLoadExit.add(innerPanel2);
		saveLoadExit.add(innerPanel3);
		saveLoadExit.add(innerPanel4);
		for (int i = 0; i < 20; i++) {
			saveLoadExit.add(new JLabel());
		}

		pane.add("Menu Settings", menuRelatedSettings);
		pane.add("Text Container Settings", textContainerRelatedSettings);
		pane.add("Box And Button Settings", boxNButtonRelatedSettings);
		pane.add("Tabbed Pane and Table Settings", tabbedPaneNTableRelatedSettings);
		pane.add("S-S-E Pane Settings", panesRelatedSettings);
		pane.add("Misc Settings", miscSettings);
		pane.add("Misc Settings 2", misc2Settings);
		pane.add("Save/Load/Exit", saveLoadExit);
		return pane;
	}

	private static JPanel createWarningLabel() {
		JPanel panel = new JPanel();
		JLabel warningLabel = new JLabel("Disclaimer: JAVA's Swing and PLAF has some validation issues, please save your theme before going back to work, otherwise the GUI will not be stable, and indeed will crash.");
		JButton saveButton = new JButton("Save & Exit");
		saveButton.addActionListener(new SaveTheme());
		panel.add(warningLabel);
		panel.add(saveButton);
		return panel;
	}

	private static void refreshAllPanels() {
		frame.remove(pane);
		pane = populateAllPanels();
		frame.add(pane);
		frame.pack();
		frame.validate();
		frame.revalidate();
	}

	private static class SaveTheme implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			CustomLookAndFeel.saveUserTheme();
			LookAndFeelDelegate.setUIConstants();
			frame.setVisible(false);
		}
	}

	private static class LoadLightTheme implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure want to Load Default MARS? Beware, your current theme will be replaced!", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				CustomLookAndFeel.loadDefaultTheme();
				refreshAllPanels();
				LookAndFeelDelegate.setUIConstants();
				frame.setVisible(false);
			}
		}
	}

	private static class LoadDarkTheme implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure want to Load Dark Side of MARS? Beware, your current theme will be replaced!", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == 0) {
				CustomLookAndFeel.loadDefaultDarkTheme();
				refreshAllPanels();
				LookAndFeelDelegate.setUIConstants();
				frame.setVisible(false);
			}
		}
	}

	private static class ExitWithoutSaving implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Exit without saving?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == JOptionPane.YES_OPTION) {
				BetterColors.revertColorChanges();
				BetterBorders.revertBorderChanges();
				BetterBorders.updateBorders();
				CustomLookAndFeel.saveUserTheme();
				refreshAllPanels();
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
				frame.setVisible(false);
			} else {
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setVisible(true);
			}
		}
	}

	private static class exitListener extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Exit without saving?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (confirm == JOptionPane.YES_OPTION) {				
				BetterColors.revertColorChanges();
				BetterBorders.revertBorderChanges();
				BetterBorders.updateBorders();
				CustomLookAndFeel.saveUserTheme();
				refreshAllPanels();
				LookAndFeelDelegate.setUIConstantsOnlyForThemeEngine();
				frame.setVisible(false);
			} else {
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frame.setVisible(true);
			}
		}
	};
}
