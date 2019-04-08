package doga.betterComponents;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.ImageIcon;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import doga.utils.PreferencesUtils;
import mars.Globals;

public class CustomLookAndFeel extends MetalLookAndFeel {

	private static final long serialVersionUID = -1635579546382441115L;
	private static final String[] colorSettingsKeys = { "menu_bar_bg_color", "menu_bg_color", "menu_fg_color", "menu_selection_bg_color", "menu_selection_fg_color",
	        "menu_border_color", "menu_item_bg_color", "menu_item_fg_color", "menu_item_selection_bg_color", "menu_item_selection_fg_color", "separator_bg_color",
	        "separator_fg_color", "label_bg_color", "label_fg_color", "button_bg_color", "button_fg_color", "button_select_color", "button_focus_color",
	        "button_border_color", "tooltip_bg_color", "tooltip_fg_color", "tooltip_border_color", "checkbox_bg_color", "checkbox_fg_color", "checkbox_focus_color",
	        "checkbox_box_color", "checkbox_icon_color", "combobox_bg_color", "combobox_fg_color", "combobox_selection_bg_color", "combobox_selection_fg_color",
	        "combobox_border_color", "combobox_button_bg_color", "combobox_disabled_bg_color", "combobox_disabled_fg_color", "combobox_button_shadow_color",
	        "combobox_button_dark_shadow_color", "combobox_button_highlight_color", "txtfield_bg_color", "txtfield_fg_color", "txtfield_selection_bg_color",
	        "txtfield_selection_fg_color", "txtfield_border_color", "txtfield_disabled_bg_color", "txtfield_disabled_fg_color", "txtarea_bg_color", "txtarea_fg_color",
	        "txtarea_selection_bg_color", "txtarea_selection_fg_color", "txtarea_border_color", "txtarea_inactive_fg_color", "checkbox_menu_item_bg_color",
	        "checkbox_menu_item_fg_color", "checkbox_menu_item_selection_bg_color", "checkbox_menu_item_selection_fg_color", "checkbox_menu_item_icon_color",
	        "slider_bg_color", "slider_track_bg_color", "slider_track_fg_color", "slider_minor_tick_color", "slider_major_tick_color", "popup_menu_bg_color",
	        "popup_menu_fg_color", "popup_menu_border_color", "panel_bg_color", "panel_fg_color", "scroll_pane_bg_color", "scroll_pane_fg_color",
	        "scroll_bar_track_color", "scroll_bar_thumb_color", "viewport_bg_color", "viewport_fg_color", "tabbed_pane_bg_color", "tabbed_pane_fg_color",
	        "tabbed_pane_selected_fg_color", "tabbed_pane_tab_area_bg_color", "tabbed_pane_border_color", "tabbed_pane_inner_border_color",
	        "split_pane_divider_global_color", "split_pane_divider_arrow_color", "toolbar_bg_color", "toolbar_border_color", "titled_border_font_color",
	        "titled_border_border_color", "table_grid_color", "table_selection_border_color", "table_header_bg_color", "table_header_fg_color",
	        "table_header_border_color", "option_pane_bg_color", "option_pane_fg_color", "editor_pane_bg_color", "editor_pane_fg_color", "editor_pane_selection_bg_color",
	        "editor_pane_selection_fg_color", "internal_frame_title_bg_color", "internal_frame_title_fg_color", "internal_frame_border_color", "list_bg_color",
	        "list_fg_color", "txt_bg_color", "txt_fg_color", "txt_singular_sel_bg_color", "txt_multiple_sel_bg_color", "txt_caret_color", "help_label_bg_color",
	        "help_label_fg_color", "help_label_selection_bg_color", "help_label_selection_fg_color", "txt_segment_highlight_bg_color", "txt_segment_highlight_fg_color",
	        "txt_segment_delay_slot_highlight_bg_color", "txt_segment_delay_slot_highlight_fg_color", "data_segment_highlight_bg_color",
	        "data_segment_highlight_fg_color", "register_highlight_bg_color", "register_highlight_fg_color", "table_even_row_bg", "table_even_row_fg", "table_odd_row_bg",
	        "table_odd_row_fg", "address_bg_color", "address_fg_color", "messages_pane_error_text_bg_color", "messages_pane_error_text_fg_color" };

	private static Preferences preferences = PreferencesUtils.importThemePreferences(Preferences.userNodeForPackage(CustomLookAndFeel.class));
	private static String[] colorSettingsValues = initializeColorSettings();

	public CustomLookAndFeel() {
		setCurrentTheme(new DefaultMetalTheme());
		init();
	}

	public void init() {
		initClassDefaults(UIManager.getDefaults());
		initComponentDefaults(UIManager.getDefaults());
	}

	@Override
	protected void initClassDefaults(UIDefaults table) {
		super.initClassDefaults(table);

		table.put("ComboBoxUI", BetterComboArrow.class.getName());
		table.put("SliderUI", BetterSliderUI.class.getName());
		table.put("ScrollBarUI", BetterScrollBarUI.class.getName());
		table.put("TabbedPaneUI", BetterTabbedPaneUI.class.getName());
		table.put("SplitPaneUI", BetterSplitPaneUI.class.getName());
		table.put("RadioButtonUI", BetterRadioButtonUI.class.getName());
		table.put("InternalFrameUI", javax.swing.plaf.basic.BasicInternalFrameUI.class.getName());// doga.betterComponents.BetterInternalFrameUI.class.getName());
	}

	@Override
	protected void initComponentDefaults(UIDefaults table) {
		super.initComponentDefaults(table);

		// IMPLEMENTED
		table.put("MenuBar.background", new ColorUIResource(BetterColors.currentColors[0]));

		// IMPLEMENTED
		table.put("Menu.background", new ColorUIResource(BetterColors.currentColors[1]));
		table.put("Menu.foreground", new ColorUIResource(BetterColors.currentColors[2]));
		table.put("Menu.selectionBackground", new ColorUIResource(BetterColors.currentColors[3]));
		table.put("Menu.selectionForeground", new ColorUIResource(BetterColors.currentColors[4]));
		table.put("Menu.border", new BorderUIResource(BetterBorders.currentBorders[0]));

		// IMPLEMENTED
		table.put("MenuItem.background", new ColorUIResource(BetterColors.currentColors[6]));
		table.put("MenuItem.foreground", new ColorUIResource(BetterColors.currentColors[7]));
		table.put("MenuItem.selectionBackground", new ColorUIResource(BetterColors.currentColors[8]));
		table.put("MenuItem.selectionForeground", new ColorUIResource(BetterColors.currentColors[9]));
		table.put("MenuItem.borderPainted", false);

		// IMPLEMENTED
		table.put("Separator.background", new ColorUIResource(BetterColors.currentColors[10]));
		table.put("Separator.foreground", new ColorUIResource(BetterColors.currentColors[11]));

		// IMPLEMENTED
		table.put("Label.background", new ColorUIResource(BetterColors.currentColors[12]));
		table.put("Label.foreground", new ColorUIResource(BetterColors.currentColors[13]));

		// IMPLEMENTED
		table.put("Button.background", new ColorUIResource(BetterColors.currentColors[14]));
		table.put("Button.foreground", new ColorUIResource(BetterColors.currentColors[15]));
		table.put("Button.select", new ColorUIResource(BetterColors.currentColors[16]));
		table.put("Button.focus", new ColorUIResource(BetterColors.currentColors[17]));
		table.put("Button.border", new BorderUIResource(BetterBorders.currentBorders[1]));
		table.put("Button.rollover", false);

		// IMPLEMENTED
		table.put("ToolTip.background", new ColorUIResource(BetterColors.currentColors[19]));
		table.put("ToolTip.foreground", new ColorUIResource(BetterColors.currentColors[20]));
		table.put("ToolTip.border", new BorderUIResource(BetterBorders.currentBorders[3]));// 21

		// IMPLEMENTED
		table.put("CheckBox.background", new ColorUIResource(BetterColors.currentColors[22]));
		table.put("CheckBox.foreground", new ColorUIResource(BetterColors.currentColors[23]));
		table.put("CheckBox.focus", new ColorUIResource(BetterColors.currentColors[24]));
		table.put("CheckBox.rollover", false);
		table.put("CheckBox.icon", new BetterJCheckIcon());

		// IMPLEMENTED
		table.put("ComboBox.background", new ColorUIResource(BetterColors.currentColors[27]));
		table.put("ComboBox.foreground", new ColorUIResource(BetterColors.currentColors[28]));
		table.put("ComboBox.selectionBackground", new ColorUIResource(BetterColors.currentColors[29]));
		table.put("ComboBox.selectionForeground", new ColorUIResource(BetterColors.currentColors[30]));
		table.put("ComboBox.border", new BorderUIResource(BetterBorders.currentBorders[4]));// 31
		table.put("ComboBox.disabledBackground", new ColorUIResource(BetterColors.currentColors[33]));
		table.put("ComboBox.disabledForeground", new ColorUIResource(BetterColors.currentColors[34]));

		// IMPLEMENTED
		table.put("TextField.background", new ColorUIResource(BetterColors.currentColors[38]));
		table.put("TextField.foreground", new ColorUIResource(BetterColors.currentColors[39]));
		table.put("TextField.selectionBackground", new ColorUIResource(BetterColors.currentColors[40]));
		table.put("TextField.selectionForeground", new ColorUIResource(BetterColors.currentColors[41]));
		table.put("TextField.border", new BorderUIResource(BetterBorders.currentBorders[5]));
		table.put("TextField.disabledBackground", new ColorUIResource(BetterColors.currentColors[43]));
		table.put("TextField.disabledForeground", new ColorUIResource(BetterColors.currentColors[44]));

		// IMPLEMENTED
		table.put("TextArea.background", new ColorUIResource(BetterColors.currentColors[45]));
		table.put("TextArea.foreground", new ColorUIResource(BetterColors.currentColors[46]));
		table.put("TextArea.selectionBackground", new ColorUIResource(BetterColors.currentColors[47]));
		table.put("TextArea.selectionForeground", new ColorUIResource(BetterColors.currentColors[48]));
		table.put("TextArea.border", new BorderUIResource(BetterBorders.currentBorders[6]));
		table.put("TextArea.inactiveForeground", new ColorUIResource(BetterColors.currentColors[50]));

		// IMPLEMENTED
		table.put("CheckBoxMenuItem.background", new ColorUIResource(BetterColors.currentColors[51]));
		table.put("CheckBoxMenuItem.foreground", new ColorUIResource(BetterColors.currentColors[52]));
		table.put("CheckBoxMenuItem.selectionBackground", new ColorUIResource(BetterColors.currentColors[53]));
		table.put("CheckBoxMenuItem.selectionForeground", new ColorUIResource(BetterColors.currentColors[54]));
		table.put("CheckBoxMenuItem.checkIcon", new BetterJCheckMenuIcon());
		table.put("CheckBoxMenuItem.borderPainted", false);

		// IMPLEMENTED

		// LEFT AS NOT IMPLEMENTED
		table.put("PopupMenu.background", new ColorUIResource(BetterColors.currentColors[61]));
		table.put("PopupMenu.foreground", new ColorUIResource(BetterColors.currentColors[62]));
		table.put("PopupMenu.border", new BorderUIResource(BetterBorders.currentBorders[3]));

		// IMPLEMENTED
		table.put("Panel.background", new ColorUIResource(BetterColors.currentColors[64]));
		table.put("Panel.foreground", new ColorUIResource(BetterColors.currentColors[65]));

		// IMPLEMENTED
		table.put("ScrollPane.background", new ColorUIResource(BetterColors.currentColors[66]));
		table.put("ScrollPane.foreground", new ColorUIResource(BetterColors.currentColors[67]));

		// IMPLEMENTED
		table.put("ScrollBar.width", 12);

		// IMPLEMENTED
		table.put("Viewport.background", new ColorUIResource(BetterColors.currentColors[70]));
		table.put("Viewport.foreground", new ColorUIResource(BetterColors.currentColors[71]));

		// IMPLEMENTED
		table.put("TabbedPane.background", new ColorUIResource(BetterColors.currentColors[72]));
		table.put("TabbedPane.foreground", new ColorUIResource(BetterColors.currentColors[73]));
		table.put("TabbedPane.selectedForeground", new ColorUIResource(BetterColors.currentColors[74]));
		table.put("TabbedPane.tabAreaBackground", new ColorUIResource(BetterColors.currentColors[75]));
		table.put("TabbedPane.focus", new ColorUIResource(BetterColors.NO_COLOR));
		table.put("TabbedPane.highlight", new ColorUIResource(BetterColors.currentColors[77]));
		table.put("TabbedPane.shadow", new ColorUIResource(BetterColors.currentColors[77]));
		table.put("TabbedPane.darkShadow", new ColorUIResource(BetterColors.currentColors[77]));
		table.put("TabbedPane.contentBorderInsets", BetterBorders.TABBED_PANE_INSETS);
		table.put("TabbedPane.tabsOpaque", true);
		table.put("TabbedPane.opaque", true);

		// IMPLEMENTED
		table.put("SplitPaneDivider.border", new BorderUIResource(BetterBorders.currentBorders[7]));

		// IMPLEMENTED
		table.put("ToolBar.background", new ColorUIResource(BetterColors.currentColors[80]));
		table.put("ToolBar.dockingBackground", new ColorUIResource(BetterColors.currentColors[80]));
		table.put("ToolBar.floatingBackground", new ColorUIResource(BetterColors.currentColors[80]));
		table.put("ToolBar.border", new BorderUIResource(BetterBorders.currentBorders[2]));

		// IMPLEMENTED
		table.put("TitledBorder.titleColor", new ColorUIResource(BetterColors.currentColors[82]));
		table.put("TitledBorder.border", new BorderUIResource(BetterBorders.currentBorders[8]));

		// LEFT AS NOT IMPLEMENTED

		// IMPLEMENTED
		table.put("Table.gridColor", new ColorUIResource(BetterColors.currentColors[84]));
		table.put("Table.focusCellHighlightBorder", new BorderUIResource(BetterBorders.currentBorders[9]));

		// IMPLEMENTED
		table.put("TableHeader.background", new ColorUIResource(BetterColors.currentColors[86]));
		table.put("TableHeader.foreground", new ColorUIResource(BetterColors.currentColors[87]));
		table.put("TableHeader.cellBorder", new BorderUIResource(BetterBorders.currentBorders[10]));

		// IMPLEMENTED
		table.put("OptionPane.background", new ColorUIResource(BetterColors.currentColors[89]));
		table.put("OptionPane.messageForeground", new ColorUIResource(BetterColors.currentColors[90]));

		// IMPLEMENTED
		table.put("EditorPane.background", new ColorUIResource(BetterColors.currentColors[91]));
		StyleSheet sheet = new HTMLEditorKit().getStyleSheet();
		sheet.addRule("body {color: rgb(" + BetterColors.currentColors[92].getRed() + ", " + BetterColors.currentColors[92].getGreen() + ","
		        + BetterColors.currentColors[92].getBlue() + ");}");
		table.put("EditorPane.selectionBackground", new ColorUIResource(BetterColors.currentColors[93]));
		table.put("EditorPane.selectionForeground", new ColorUIResource(BetterColors.currentColors[94]));

		// IMPLEMENTED
		table.put("InternalFrame.activeTitleBackground", new ColorUIResource(BetterColors.currentColors[95]));
		table.put("InternalFrame.inactiveTitleBackground", new ColorUIResource(BetterColors.currentColors[95]));
		table.put("InternalFrame.activeTitleForeground", new ColorUIResource(BetterColors.currentColors[96]));
		table.put("InternalFrame.inactiveTitleForeground", new ColorUIResource(BetterColors.currentColors[96]));
		table.put("InternalFrame.border", new BorderUIResource(BetterBorders.currentBorders[11]));
		table.put("InternalFrame.icon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(Toolkit.class.getResource(Globals.imagesPath + "Assemble16.png"))));
		table.put("InternalFrame.closeIcon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(Toolkit.class.getResource(Globals.imagesPath + "Cl.png"))));
		table.put("InternalFrame.maximizeIcon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(Toolkit.class.getResource(Globals.imagesPath + "Max.png"))));
		table.put("InternalFrame.minimizeIcon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(Toolkit.class.getResource(Globals.imagesPath + "Min.png"))));
		table.put("InternalFrame.iconifyIcon", new ImageIcon(Toolkit.getDefaultToolkit().getImage(Toolkit.class.getResource(Globals.imagesPath + "Iconify.png"))));

		// IMPLEMENTED
		table.put("List.background", new ColorUIResource(BetterColors.currentColors[98]));
		table.put("List.foreground", new ColorUIResource(BetterColors.currentColors[99]));

	}

	@Override
	public String getName() {
		return "CustomLookAndFeel";
	}

	@Override
	public String getID() {
		return "CUstomLookAndFeel";
	}

	@Override
	public String getDescription() {
		return "CustomLookAndFeel";
	}

	@Override
	public boolean isNativeLookAndFeel() {
		return false;
	}

	@Override
	public boolean isSupportedLookAndFeel() {
		return true;
	}

	public static void saveUserTheme() {
		try {
			for (int i = 0; i < BetterColors.currentColors.length; i++) {
				Color color = BetterColors.currentColors[i];
				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
				int a = color.getAlpha();
				String hexColor = String.format("0x%02x%02x%02x%02x", r, g, b, a);
				colorSettingsValues[i] = hexColor;
				preferences.put(colorSettingsKeys[i], colorSettingsValues[i]);
				preferences.flush();
				PreferencesUtils.exportThemePreferences(preferences);
				BetterColors.savedColors[i] = BetterColors.currentColors[i];
			}
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	public static void loadDefaultTheme() {
		for (int i = 0; i < BetterColors.defaultColors.length; i++) {
			BetterColors.currentColors[i] = BetterColors.defaultColors[i];
		}
		BetterBorders.updateBorders();
		BetterBorders.saveBorderChanges();
		BetterBorders.updateBorders();
		saveUserTheme();
	}

	public static void loadDefaultDarkTheme() {
		for (int i = 0; i < BetterColors.defaultDarkColors.length; i++) {
			BetterColors.currentColors[i] = BetterColors.defaultDarkColors[i];
		}
		BetterBorders.updateBorders();
		BetterBorders.saveBorderChanges();
		saveUserTheme();
	}

	public static Color[] readFromRegistry() {
		Color[] newColors = new Color[colorSettingsKeys.length];
		for (int i = 0; i < colorSettingsKeys.length; i++) {
			newColors[i] = hex2Rgb(colorSettingsValues[i]);
		}
		return newColors;
	}

	private static String[] initializeColorSettings() {
		String[] newSettings = new String[colorSettingsKeys.length];
		for (int i = 0; i < colorSettingsKeys.length; i++) {
			newSettings[i] = preferences.get(colorSettingsKeys[i], null);
		}
		return newSettings;
	}

	private static Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(2, 4), 16), Integer.valueOf(colorStr.substring(4, 6), 16), Integer.valueOf(colorStr.substring(6, 8), 16),
		        Integer.valueOf(colorStr.substring(8, 10), 16));
	}
}