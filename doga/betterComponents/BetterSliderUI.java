package doga.betterComponents;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.metal.MetalSliderUI;

/**
 * Custom Slider background and icon, I also use this for my game engine's main menu. :)
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterSliderUI extends MetalSliderUI {

	public static Icon icon = new ImageIcon(BetterSliderUI.class.getResource("/images/volumeSliderThumb.png"));

	public static BetterSliderUI createUI(JComponent c) {
		c.setOpaque(false);
		return new BetterSliderUI(); //Doesn't matter what color it is.
	}

	@Override
	public void paintThumb(Graphics g) {
		Rectangle knobBounds = thumbRect;

		g.translate(knobBounds.x, knobBounds.y);
		icon.paintIcon(slider, g, 0, 0);
		g.translate(-knobBounds.x, -knobBounds.y);
	}

	@Override
	protected Dimension getThumbSize() {
		Dimension size = new Dimension();
		size.width = icon.getIconWidth();
		size.height = icon.getIconHeight();
		return size;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		recalculateIfInsetsChanged();
		recalculateIfOrientationChanged();
		Rectangle clip = g.getClipBounds();

		if (slider.getPaintTrack() && clip.intersects(trackRect)) {
			int arc = 10;
			int trackHeight = 12;
			int trackWidth = 175;
			int fillTop = 10;
			int fillLeft = 12;

			((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			((Graphics2D) g).setStroke(new BasicStroke(4f));
			g.setColor(BetterColors.currentColors[57]);
			g.fillRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);

			int fillBottom = fillTop + trackHeight;
			int fillRight = auxilarry(((JSlider) c).getValue(), c, new Rectangle(fillLeft, fillTop, trackWidth, fillBottom - fillTop));

			g.setColor(BetterColors.currentColors[58]);
			g.fillRect(fillLeft + 1, fillTop + 1, fillRight - fillLeft, fillBottom - fillTop);

			g.setColor(BetterColors.currentColors[56]);
			g.drawRoundRect(fillLeft, fillTop, trackWidth, trackHeight, arc, arc);
		}
		
		
		/*
		if (slider.getPaintTicks() && clip.intersects(tickRect)) {
			g.setColor(Color.WHITE);
			paintTicks(g);
		}*/
		
		
		if (slider.hasFocus() && clip.intersects(focusRect)) {
			paintFocus(g);
		}
		if (clip.intersects(thumbRect)) {
			paintThumb(g);
		}
	}

	private int auxilarry(int value, JComponent c, Rectangle trackRect) {
		int min = ((JSlider) c).getMinimum();
		int max = ((JSlider) c).getMaximum();
		int trackLength = trackRect.width;
		double valueRange = (double) max - (double) min;
		double pixelsPerValue = (double) trackLength / valueRange;
		int trackLeft = trackRect.x;
		int trackRight = trackRect.x + (trackRect.width - 1);
		int xPosition;

		xPosition = trackLeft;
		xPosition += Math.round(pixelsPerValue * ((double) value - min));

		xPosition = Math.max(trackLeft, xPosition);
		xPosition = Math.min(trackRight, xPosition);

		return xPosition;
	}

	@Override
	public void paintMajorTickForHorizSlider(Graphics g, Rectangle tickBounds, int x) {/*
		int coordinateX = x;
		if (slider.getOrientation() == JSlider.HORIZONTAL) {
			g.setColor(BetterColors.currentColors[60]);
			g.drawLine(coordinateX - 1, 0, coordinateX - 1, tickBounds.height);
			g.drawLine(coordinateX, 0, coordinateX, tickBounds.height);
			g.drawLine(coordinateX + 1, 0, coordinateX + 1, tickBounds.height);
		}*/
	}

	@Override
	public void paintMinorTickForHorizSlider(Graphics g, Rectangle tickBounds, int x) {/*
		int coordinateX = x;
		if (slider.getOrientation() == JSlider.HORIZONTAL) {
			g.setColor(BetterColors.currentColors[59]);
			g.drawLine(coordinateX - 1, 0, coordinateX - 1, tickBounds.height / 2);
			g.drawLine(coordinateX, 0, coordinateX, tickBounds.height / 2);
			g.drawLine(coordinateX + 1, 0, coordinateX + 1, tickBounds.height / 2);
		}*/
	}
}
