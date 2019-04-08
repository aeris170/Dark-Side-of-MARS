package doga.betterComponents;

import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * Predefined borders for various components.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterBorderConstants {
	
	public static final Border EMPTY = BorderFactory.createEmptyBorder();
	
	public static final Border MENU_STANDARD_BORDER = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, BetterColors.MENU_BORDER_COLOR, BetterColors.MENU_BORDER_COLOR);

	public static final Border LABEL_STANDARD_BORDER = null; // <-- UNDEFINED

	public static final Border BUTTON_DEFAULT_BORDER = new JButton().getBorder();
	public static final Border BUTTON_STANDARD_BORDER = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, BetterColors.BUTTON_BORDER_COLOR, BetterColors.BUTTON_BORDER_COLOR), BetterBorderConstants.BUTTON_DEFAULT_BORDER);
	
	public static final Border TOOLBAR_BUTTON_STANDARD_BORDER = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3), BorderFactory.createLineBorder(BetterColors.TOOLBAR_BORDER_COLOR, 1, false));//BorderFactory.createEmptyBorder(1, 4, 1, 4);

	public static final Border TOOLTIP_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.TOOLTIP_BORDER_COLOR, 2, false);

	public static final Border CHECKBOX_STANDARD_BORDER = null; // <- UNDEFINED

	public static final Border COMBOBOX_STANDARD_BORDER = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, BetterColors.COMBOBOX_BORDER_COLOR, BetterColors.COMBOBOX_BORDER_COLOR);

	public static final Border COLOR_CHOOSER_STANDARD_BORDER = null; // <- UNDEFINED

	// public static final Border TXTFIELD_STANDARD_BORDER =
	// BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
	// BetterColors.TXTFIELD_BORDER_COLOR_CLICKED,
	// BetterColors.TXTFIELD_BORDER_COLOR), new JTextField().getBorder());
	public static final Border TXTFIELD_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.TXTFIELD_BORDER_COLOR, 2, false);

	// public static final Border TXTAREA_STANDARD_BORDER =
	// BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
	// BetterColors.TXTAREA_BORDER_COLOR_CLICKED,
	// BetterColors.TXTAREA_BORDER_COLOR), new JTextField().getBorder());
	public static final Border TXTAREA_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.TXTAREA_BORDER_COLOR, 2, false);

	public static final Insets TABBED_PANE_INSETS = new Insets(0, 0, 0, 0);
	
	public static final Border SPLIT_PANE_DIVIDER_BORDER = BorderFactory.createLineBorder(BetterColors.SPLIT_PANE_DIVIDER_GLOBAL_COLOR, 2, false);

	public static final Border TITLED_BORDER_BORDER = BorderFactory.createLineBorder(BetterColors.TITLED_BORDER_BORDER_COLOR, 2, false);

	public static final Border TABLE_SELECTION_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.TABLE_SELECTION_BORDER_COLOR, 2, true);
	
	public static final Border TABLE_HEADER_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.TABLE_HEADER_BORDER_COLOR, 1, false);
	
	public static final Border INTERNAL_FRAME_STANDARD_BORDER = BorderFactory.createLineBorder(BetterColors.INTERNAL_FRAME_BORDER_COLOR, 6, false);

}
