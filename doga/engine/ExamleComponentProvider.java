package doga.engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import doga.betterComponents.BetterBorders;
import doga.betterComponents.BetterColors;
import mars.Globals;
import mars.settings.Settings;
import mars.venus.MonoRightCellRenderer;

public class ExamleComponentProvider {

	public static JPanel provideCompleteMenu() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(12, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("I am a Menu");
		JMenuItem menuItem = new JMenuItem("I am a MenuItem");
		JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("I am a CheckBoxMenuItem");
		file.add(menuItem);
		file.addSeparator();
		file.add(checkBoxMenuItem);
		menuBar.add(file);
		menuBar.add(new JLabel("                                                                    I am a MenuBar"));
		panel.add(menuBar);
		panel.add(new JLabel("For Border around the MenuItems, go to ToolTip Border."));
		panel.add(new JLabel("They are equal because of Java's implementation"));
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(new JLabel());
		return panel;
	}

	public static JPanel provideCompleteBoxNButton() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));
		JPanel buttonPanel = new JPanel();
		JPanel checkBoxPanel = new JPanel();
		JPanel comboBoxPanel = new JPanel();
		JPanel disabledComboBoxPanel = new JPanel();
		JButton button = new JButton("I am a Button");
		JCheckBox checkBox = new JCheckBox("<-- I am a CheckBox");
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addItem("I am a ComboBox");
		comboBox.addItem("ComboBox Item");
		comboBox.addItem("Anoter Item");
		JComboBox<String> disabledComboBox = new JComboBox<String>();
		disabledComboBox.addItem("This is a disabled comboBox");
		disabledComboBox.setEnabled(false);
		buttonPanel.add(button);
		checkBoxPanel.add(checkBox);
		comboBoxPanel.add(comboBox);
		disabledComboBoxPanel.add(disabledComboBox);
		panel.add(buttonPanel);
		panel.add(checkBoxPanel);
		panel.add(comboBoxPanel);
		panel.add(disabledComboBoxPanel);
		return panel;
	}

	public static JPanel provideCompleteTXTContainer() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));
		JPanel txtAreaPanel = new JPanel();
		JPanel txtFieldPanel = new JPanel();
		JPanel disabledTXTFieldPanel = new JPanel();
		JPanel labelPanel = new JPanel();
		JPanel toolTipPanel = new JPanel();
		JPanel optionPanePanel = new JPanel();
		txtAreaPanel.add(new JTextArea("I am a TXTArea"));
		txtFieldPanel.add(new JTextField("I am a TXTField"));
		JTextField disabledTXTField = new JTextField("I am a disabled TXTField");
		disabledTXTField.setEnabled(false);
		disabledTXTFieldPanel.add(disabledTXTField);
		labelPanel.add(new JLabel("I am a Label"));
		JButton toolTipButton = new JButton("Hover over for a ToolTip!");
		toolTipButton.setToolTipText("I am a ToolTip!");
		toolTipPanel.add(toolTipButton);
		JButton optionPaneButton = new JButton("Click me for an OptionPane!");
		optionPaneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(optionPaneButton, "I am an OptionPane", "Hi!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		optionPanePanel.add(optionPaneButton);
		panel.add(txtAreaPanel);
		panel.add(txtFieldPanel);
		panel.add(disabledTXTFieldPanel);
		panel.add(labelPanel);
		panel.add(toolTipPanel);
		panel.add(optionPanePanel);
		return panel;
	}

	public static JPanel provideCompleteTabbedPaneWithTable() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));
		JTabbedPane pane = new JTabbedPane();
		String[] columnNames = {"I", "am", "a", "Table", "Header"};
		Object[][] data = {{"I'm", "a", "Non-Highlighted", "Table", "Cell"}, {"I'm", "a", "Hightlighted", "Table", "Cell"}, {"I", "can", "hold", "any", "data"}, {"0", "1", "2", "3", "4"},};
		JTable table1 = new JTable(data, columnNames);
		table1.getColumnModel().getColumn(0).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.LEFT));
		table1.getColumnModel().getColumn(1).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table1.getColumnModel().getColumn(2).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table1.getColumnModel().getColumn(3).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table1.getColumnModel().getColumn(4).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		JTable table2 = new JTable(data, columnNames);
		table2.getColumnModel().getColumn(0).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.LEFT));
		table2.getColumnModel().getColumn(1).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table2.getColumnModel().getColumn(2).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table2.getColumnModel().getColumn(3).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table2.getColumnModel().getColumn(4).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		JTable table3 = new JTable(data, columnNames);
		table3.getColumnModel().getColumn(0).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.LEFT));
		table3.getColumnModel().getColumn(1).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table3.getColumnModel().getColumn(2).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table3.getColumnModel().getColumn(3).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table3.getColumnModel().getColumn(4).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		JTable table4 = new JTable(data, columnNames);
		table4.getColumnModel().getColumn(0).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.LEFT));
		table4.getColumnModel().getColumn(1).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table4.getColumnModel().getColumn(2).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table4.getColumnModel().getColumn(3).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table4.getColumnModel().getColumn(4).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		JTable table5 = new JTable(data, columnNames);
		table5.getColumnModel().getColumn(0).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.LEFT));
		table5.getColumnModel().getColumn(1).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table5.getColumnModel().getColumn(2).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table5.getColumnModel().getColumn(3).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		table5.getColumnModel().getColumn(4).setCellRenderer(new RegisterCellRenderer(MonoRightCellRenderer.MONOSPACED_PLAIN_12POINT, SwingConstants.RIGHT));
		Dimension d = table1.getPreferredSize();
		JScrollPane pane1 = new JScrollPane(table1);
		JScrollPane pane2 = new JScrollPane(table2);
		JScrollPane pane3 = new JScrollPane(table3);
		JScrollPane pane4 = new JScrollPane(table4);
		JScrollPane pane5 = new JScrollPane(table5);
		pane1.setPreferredSize(new Dimension(d.width, table1.getRowHeight() * 5));
		pane2.setPreferredSize(new Dimension(d.width, table1.getRowHeight() * 5));
		pane3.setPreferredSize(new Dimension(d.width, table1.getRowHeight() * 5));
		pane4.setPreferredSize(new Dimension(d.width, table1.getRowHeight() * 5));
		pane5.setPreferredSize(new Dimension(d.width, table1.getRowHeight() * 5));
		pane.add("I", pane1);
		pane.add("am", pane2);
		pane.add("a", pane3);
		pane.add("Tabbed", pane4);
		pane.add("Pane", pane5);
		panel.add(pane);
		return panel;
	}

	public static JPanel provideCompleteAllPanes() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(20, 20));
		p1.setOpaque(false);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 5; j++) {
				p1.add(new JButton("I"));
				p1.add(new JButton("am"));
				p1.add(new JButton("a"));
				p1.add(new JButton("ScrollPane"));
			}
		}
		JScrollPane scrollPane = new JScrollPane(p1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(20, 20));
		for (int i = 0; i < p1.getComponentCount(); i++) {
			if (p1.getComponent(i) instanceof JButton) {
				((JButton) p1.getComponent(i)).setOpaque(false);
				((JButton) p1.getComponent(i)).setContentAreaFilled(false);
				((JButton) p1.getComponent(i)).setBorderPainted(false);
			}
		}

		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JButton b1 = new JButton("I'm a SplitPane but with I have a catch");
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		JButton b2 = new JButton("Because of space problems, the buttons are not visible. :(");
		b2.setOpaque(false);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		p2.add(b1);
		p3.add(b2);
		p2.setBackground(BetterColors.PANEL_BG_COLOR.darker());
		p3.setBackground(BetterColors.PANEL_BG_COLOR.darker());
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p2, p3);

		JEditorPane editorPane;
		String text = "I am an EditorPane";
		editorPane = new JEditorPane("text/html", text.toString());
		editorPane.setEditable(false);
		editorPane.setCaretPosition(0);

		panel.add(scrollPane);
		panel.add(splitPane);
		panel.add(editorPane);

		return panel;
	}

	public static JPanel provideCompleteMisc() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));

		WriteablePanel panelPanel = new WriteablePanel();
		panelPanel.writeText("I am a Panel, I hold every compoenent.", 1);
		panelPanel.writeText("Normally, the text on me are supplied by", 2);
		panelPanel.writeText("transparent Labels(They have no background.", 3);
		panelPanel.writeText("So go change Label Foreground for Text Color.", 4);
		panelPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 1, false));
		
		JPanel toolBarPanel = new JPanel();
		JToolBar toolBar = setUpToolBar();
		
		toolBarPanel.add(toolBar);

		JPanel fileOpenerPanel = new JPanel();
		JButton fileOpenerButton = new JButton("Click me for a FileChooser");
		fileOpenerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showDialog(fileOpenerButton, "Done");
			}
		});
		fileOpenerPanel.add(fileOpenerButton);

		panel.add(panelPanel);
		panel.add(fileOpenerPanel);
		panel.add(toolBarPanel);
		return panel;
	}
	
	public static JPanel provideCompleteMisc2() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		panel.setBorder(BorderFactory.createTitledBorder("Example Component"));
		panel.add(new JLabel("This is how it will look like after the changes are saved:"));

		JPanel internalFramePanel = new JPanel();
		JButton button = new JButton("Click me for an InternalFrame!");
		button.addActionListener((ActionEvent e) -> {
		    final JFrame jf = new JFrame("JIFrameDemo Main Window");

		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		    screenSize.width -= screenSize.width * 3 / 4;
		    screenSize.height -= screenSize.height / 2;
		    jf.setSize(screenSize);
		    jf.setLocation(250, 250);

		    JMenuBar mb = new JMenuBar();
		    jf.setJMenuBar(mb);
		    JMenu fm = new JMenu("File");
		    mb.add(fm);
		    JMenuItem mi;
		    fm.add(mi = new JMenuItem("Exit"));
		    mi.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		      }
		    });

		    JDesktopPane dtp = new JDesktopPane();
		    //dtp.setBackground(Color.GREEN);
		    jf.setContentPane(dtp);
		    
		    JInternalFrame compFrame = new JInternalFrame("I am a InternalFrame");
		    compFrame.setSize((screenSize.width / 2) - 1, (screenSize.height / 2) - 1);
		    compFrame.setLocation(1, 1);
		    compFrame.setVisible(true);
		    dtp.add(compFrame);

		    JInternalFrame listFrame = new JInternalFrame("I am another InternalFrame");
		    listFrame.setSize((screenSize.width / 2) - 1, (screenSize.height / 2) - 1);
		    listFrame.setLocation((screenSize.width / 2) + 1, 1);
		    listFrame.setVisible(true);
		    dtp.add(listFrame);

		    JInternalFrame mboxFrame = new JInternalFrame("I am yet another InternalFrame");
		    mboxFrame.setSize(screenSize.width - 1, (screenSize.height / 2) - 1);
		    mboxFrame.setLocation(1, (screenSize.height / 2) + 1);
		    mboxFrame.setVisible(true);
		    dtp.add(mboxFrame);

		    screenSize.width += 50;
		    screenSize.height += 75;
		    jf.setSize(screenSize);
		    
		    jf.setVisible(true);
		    jf.addWindowListener(new WindowAdapter() {
		      public void windowClosing(WindowEvent e) {
		        jf.setVisible(false);
		        jf.dispose();
		      }
		    });
		});
		internalFramePanel.add(button);
		
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.X_AXIS));;
		sliderPanel.add(new JSlider());
		sliderPanel.add(new JLabel("<-- I am a Slider"));
		
		JPanel titledBorderPanel = new JPanel();
		titledBorderPanel.setBorder(BorderFactory.createTitledBorder("I am a TitledBorder"));
		
		panel.add(internalFramePanel);
		panel.add(sliderPanel);
		panel.add(titledBorderPanel);
		
		return panel;
	}

	private static class RegisterCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = -7917654851275691539L;
		
		private Font font;
		private int alignment;

		public RegisterCellRenderer(Font font, int alignment) {
			super();
			this.font = font;
			this.alignment = alignment;
		}

		@SuppressWarnings("deprecation")
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			cell.setFont(font);
			cell.setHorizontalAlignment(alignment);
			if (Globals.getSettings().getRegistersHighlighting() && row == 1) {
				cell.setBackground(BetterColors.currentColors[115]);
				cell.setForeground(BetterColors.currentColors[116]);
				cell.setFont(Globals.getSettings().getFontByPosition(Settings.REGISTER_HIGHLIGHT_FONT));
			} else if (row % 2 == 0) {
				cell.setBackground(BetterColors.currentColors[117]);
				cell.setForeground(BetterColors.currentColors[118]);
				cell.setFont(Globals.getSettings().getFontByPosition(Settings.EVEN_ROW_FONT));
			} else {
				cell.setBackground(BetterColors.currentColors[119]);
				cell.setForeground(BetterColors.currentColors[120]);
				cell.setFont(Globals.getSettings().getFontByPosition(Settings.ODD_ROW_FONT));
			}
			return cell;
		}
	}

	private static class WriteablePanel extends JPanel {

		private static final long serialVersionUID = -1898477565959648932L;
		
		private String text1;
		private String text2;
		private String text3;
		private String text4;

		public void writeText(String s, int i) {
			switch (i) {
			case 1:	
				text1 =  s;
				break;
			case 2:	
				text2 =  s;
				break;
			case 3:	
				text3 =  s;
				break;
			case 4:	
				text4 =  s;
				break;
			}
			repaint();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString(text1, (super.getWidth() / 2) - 80, (super.getHeight() / 2) - 21);
			g.drawString(text2, (super.getWidth() / 2) - 80, (super.getHeight() / 2) - 7);
			g.drawString(text3, (super.getWidth() / 2) - 80, (super.getHeight() / 2) + 7);
			g.drawString(text4, (super.getWidth() / 2) - 80, (super.getHeight() / 2) + 21);
		}
	}
	
	 static JToolBar setUpToolBar() {
         JToolBar toolBar = new JToolBar();
         UIManager.put("Button.border", BetterBorders.TOOLBAR_BUTTON_STANDARD_BORDER);

         toolBar.add(new JButton("I"));
         toolBar.add(new JToolBar.Separator());
         toolBar.add(new JButton("a"));
         toolBar.add(new JButton("m"));
         toolBar.add(new JToolBar.Separator());
         toolBar.add(new JButton("a"));
         toolBar.add(new JToolBar.Separator());
         toolBar.add(new JButton("T"));
         toolBar.add(new JButton("o"));
         toolBar.add(new JButton("o"));
         toolBar.add(new JButton("l"));
         toolBar.add(new JButton("B"));
         toolBar.add(new JButton("a"));
         toolBar.add(new JButton("r"));
         
         UIManager.put("Button.border", BetterBorders.BUTTON_STANDARD_BORDER);
         return toolBar;
      }
}
