package doga.betterComponents;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class BetterSplitPaneUI extends BasicSplitPaneUI {

	public static ComponentUI createUI(JComponent c) {
		return new BetterSplitPaneUI();
	}

	@Override
	public BasicSplitPaneDivider createDefaultDivider() {
		return new ZeroSizeDivider(this);
	}

	private class ZeroSizeDivider extends BasicSplitPaneDivider {
		
		private static final long serialVersionUID = 8394698839929427193L;
		
		private static final int DIVIDER_DRAG_OFFSET = 4;

		public ZeroSizeDivider(BasicSplitPaneUI ui) {
			super(ui);
			super.setBorder(BetterBorders.SPLIT_PANE_DIVIDER_BORDER);
			setBackground(BetterColors.currentColors[78]);
		}

		@Override 
		public void setBorder(Border border) {
			
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(getBackground());
			if (orientation == JSplitPane.HORIZONTAL_SPLIT) {
				g.fillRect(DIVIDER_DRAG_OFFSET - 2, 0, DIVIDER_DRAG_OFFSET + 2, getHeight() - 1);
			} else {
				g.fillRect(0, DIVIDER_DRAG_OFFSET - 2, getWidth() - 1, DIVIDER_DRAG_OFFSET + 2);
			}
			super.paint(g);
		}

		@Override
		protected void dragDividerTo(int location) {
			super.dragDividerTo(location + DIVIDER_DRAG_OFFSET);
		}

		@Override
		protected void finishDraggingTo(int location) {
			super.finishDraggingTo(location + DIVIDER_DRAG_OFFSET);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//ACTUAL JAVA IMPLEMENTATION BELOW!!!!! DON'T TRY TO UNDERSTAND. TAKEN DIRECTLY FROM ORACLE'S JAVA IMPLEMENTATION FILE(javax.swing.plaf.BasicSplitPaneDivider)
		
		
		/**
		 * Creates and return an instance of JButton that can be used to
		 * collapse the left component in the split pane.
		 */
		protected JButton createLeftOneTouchButton() {
			@SuppressWarnings("serial")
			JButton b = new JButton() {

				public void setBorder(Border b) {}

				public void paint(Graphics g) {
					if (splitPane != null) {
						int[] xs = new int[3];
						int[] ys = new int[3];
						int blockSize;

						// Fill the background first ...
						g.setColor(BetterColors.currentColors[78]);
						g.fillRect(0, 0, this.getWidth(), this.getHeight());
						g.setColor(BetterColors.currentColors[79]);
						// ... then draw the arrow.
						if (orientation == JSplitPane.VERTICAL_SPLIT) {
							blockSize = Math.min(getHeight(), 5);
							xs[0] = blockSize;
							xs[1] = 0;
							xs[2] = blockSize << 1;
							ys[0] = 0;
							ys[1] = ys[2] = blockSize;
							for(int i = 0; i < 3; i++) {
								xs[i] = xs[i] + 1;
								ys[i] = ys[i] + 1;
							}
							g.drawPolygon(xs, ys, 3); // Little trick to make
														// the
														// arrows of equal size
						} else {
							blockSize = Math.min(getWidth(), 5);
							xs[0] = xs[2] = blockSize;
							xs[1] = 0;
							ys[0] = 0;
							ys[1] = blockSize;
							ys[2] = blockSize << 1;
							for(int i = 0; i < 3; i++) {
								xs[i] = xs[i] + 1;
								ys[i] = ys[i] + 1;
							}
						}
						g.fillPolygon(xs, ys, 3);
					}
				}

				// Don't want the button to participate in focus traversable.
				public boolean isFocusTraversable() {
					return false;
				}
			};
			b.setMinimumSize(new Dimension(5, 5));
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			b.setRequestFocusEnabled(false);
			return b;
		}

		/**
		 * Creates and return an instance of JButton that can be used to
		 * collapse the right component in the split pane.
		 */
		protected JButton createRightOneTouchButton() {
			@SuppressWarnings("serial")
			JButton b = new JButton() {

				public void setBorder(Border border) {}

				public void paint(Graphics g) {
					if (splitPane != null) {
						int[] xs = new int[3];
						int[] ys = new int[3];
						int blockSize;

						// Fill the background first ...
						g.setColor(BetterColors.currentColors[78]);
						g.fillRect(0, 0, this.getWidth(), this.getHeight());

						// ... then draw the arrow.
						if (orientation == JSplitPane.VERTICAL_SPLIT) {
							blockSize = Math.min(getHeight(), 5);
							xs[0] = blockSize;
							xs[1] = blockSize << 1;
							xs[2] = 0;
							ys[0] = blockSize;
							ys[1] = ys[2] = 0;
							for(int i = 0; i < 3; i++) {
								xs[i] = xs[i] + 1;
								ys[i] = ys[i] + 1;
							}
						} else {
							blockSize = Math.min(getWidth(), 5);
							xs[0] = xs[2] = 0;
							xs[1] = blockSize;
							ys[0] = 0;
							ys[1] = blockSize;
							ys[2] = blockSize << 1;
							for(int i = 0; i < 3; i++) {
								xs[i] = xs[i] + 1;
								ys[i] = ys[i] + 1;
							}
						}
						g.setColor(BetterColors.currentColors[79]);
						g.fillPolygon(xs, ys, 3);
					}
				}

				// Don't want the button to participate in focus traversable.
				public boolean isFocusTraversable() {
					return false;
				}
			};
			b.setMinimumSize(new Dimension(5, 5));
			b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			b.setFocusPainted(false);
			b.setBorderPainted(false);
			b.setRequestFocusEnabled(false);
			return b;
		}
	}
}