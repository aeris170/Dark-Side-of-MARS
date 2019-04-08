package doga.betterComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * A better looking scroolbar, though it still needs tweaking with it's paintThumb method.
 * See Eclipse Darkest-Dark theme for the ultimate aim of this. This is still not complete,
 * the next step is making it exactly how Darkest-Dark does.
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class BetterScrollBarUI extends BasicScrollBarUI {

	private Image thumb = createImage(1, 1, BetterColors.currentColors[69]);
	private Image track = createImage(1, 1, BetterColors.currentColors[68]);

    public static ComponentUI createUI(JComponent c) {
        return new BetterScrollBarUI();
    }

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		g.drawImage(thumb, r.x, r.y, r.width, r.height, null);
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
		g.drawImage(track, r.x, r.y, r.width, r.height, null);
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	private JButton createZeroButton() {
		JButton jbutton = new JButton();
		jbutton.setPreferredSize(new Dimension(0, 0));
		jbutton.setMinimumSize(new Dimension(0, 0));
		jbutton.setMaximumSize(new Dimension(0, 0));
		return jbutton;
	}

	private static Image createImage(int width, int height, Color color) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.dispose();
		return image;
	}
}
