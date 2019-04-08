package doga.betterComponents;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class BetterBorders {

	public static Border EMPTY = BetterBorderConstants.EMPTY;

	public static Border MENU_STANDARD_BORDER = BetterBorderConstants.MENU_STANDARD_BORDER;

	public static Border LABEL_STANDARD_BORDER = BetterBorderConstants.LABEL_STANDARD_BORDER;

	public static Border BUTTON_DEFAULT_BORDER = BetterBorderConstants.BUTTON_DEFAULT_BORDER;
	public static Border BUTTON_STANDARD_BORDER = BetterBorderConstants.BUTTON_STANDARD_BORDER;

	public static Border TOOLBAR_BUTTON_STANDARD_BORDER = BetterBorderConstants.TOOLBAR_BUTTON_STANDARD_BORDER;

	public static Border TOOLTIP_STANDARD_BORDER = BetterBorderConstants.TOOLTIP_STANDARD_BORDER;

	public static Border CHECKBOX_STANDARD_BORDER = BetterBorderConstants.CHECKBOX_STANDARD_BORDER;

	public static Border COMBOBOX_STANDARD_BORDER = BetterBorderConstants.COMBOBOX_STANDARD_BORDER;

	public static Border COLOR_CHOOSER_STANDARD_BORDER = BetterBorderConstants.COLOR_CHOOSER_STANDARD_BORDER;

	// public static Border TXTFIELD_STANDARD_BORDER =
	// BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
	// BetterColors.TXTFIELD_BORDER_COLOR_CLICKED,
	// BetterColors.TXTFIELD_BORDER_COLOR), new JTextField().getBorder());
	public static Border TXTFIELD_STANDARD_BORDER = BetterBorderConstants.TXTFIELD_STANDARD_BORDER;

	// public static Border TXTAREA_STANDARD_BORDER =
	// BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
	// BetterColors.TXTAREA_BORDER_COLOR_CLICKED,
	// BetterColors.TXTAREA_BORDER_COLOR), new JTextField().getBorder());
	public static Border TXTAREA_STANDARD_BORDER = BetterBorderConstants.TXTAREA_STANDARD_BORDER;

	public static Insets TABBED_PANE_INSETS = BetterBorderConstants.TABBED_PANE_INSETS;

	public static Border SPLIT_PANE_DIVIDER_BORDER = BetterBorderConstants.SPLIT_PANE_DIVIDER_BORDER;

	public static Border TITLED_BORDER_BORDER = BetterBorderConstants.TITLED_BORDER_BORDER;

	public static Border TABLE_SELECTION_STANDARD_BORDER = BetterBorderConstants.TABLE_SELECTION_STANDARD_BORDER;

	public static Border TABLE_HEADER_STANDARD_BORDER = BetterBorderConstants.TABLE_HEADER_STANDARD_BORDER;

	public static Border INTERNAL_FRAME_STANDARD_BORDER = BetterBorderConstants.INTERNAL_FRAME_STANDARD_BORDER;

	public static Border[] currentBorders = updateBorders();

	public static Border[] savedBorders = {
			   MENU_STANDARD_BORDER,
			   BUTTON_STANDARD_BORDER,
			   TOOLBAR_BUTTON_STANDARD_BORDER,
			   TOOLTIP_STANDARD_BORDER,
			   COMBOBOX_STANDARD_BORDER,
			   TXTFIELD_STANDARD_BORDER,
			   TXTAREA_STANDARD_BORDER,
			   SPLIT_PANE_DIVIDER_BORDER,
			   TITLED_BORDER_BORDER,
			   TABLE_SELECTION_STANDARD_BORDER,
			   TABLE_HEADER_STANDARD_BORDER,
			   INTERNAL_FRAME_STANDARD_BORDER,
	};

	public static Border[] updateBorders() {
		Color[] currentColors = BetterColors.currentColors;
		Border[] newBorders = {
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED, currentColors[5], currentColors[5]),
				BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, currentColors[19], currentColors[19]), BetterBorderConstants.BUTTON_DEFAULT_BORDER),
				BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 3, 0, 3), BorderFactory.createLineBorder(currentColors[81], 1, false)),
				BorderFactory.createLineBorder(currentColors[21], 2, false),
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED, currentColors[31], currentColors[31]),
				BorderFactory.createLineBorder(currentColors[42], 2, false),
				BorderFactory.createLineBorder(currentColors[49], 2, false),
				BorderFactory.createLineBorder(currentColors[78], 2, false),
				BorderFactory.createLineBorder(currentColors[76], 2, false), //OR 77
				BorderFactory.createLineBorder(currentColors[85], 2, true),
				BorderFactory.createLineBorder(currentColors[88], 1, false),
				BorderFactory.createLineBorder(currentColors[95], 6, false),
		};
		currentBorders = newBorders;
		return newBorders;
	}

	public static void revertBorderChanges() {
		for (int i = 0; i < savedBorders.length; i++) {
			currentBorders[i] = savedBorders[i];
		}
	}
	
	public static void saveBorderChanges() {
		for (int i = 0; i < currentBorders.length; i++) {
			savedBorders[i] = currentBorders[i];
		}
	}
}
