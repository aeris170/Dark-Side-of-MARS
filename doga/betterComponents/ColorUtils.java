package doga.betterComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;

public class ColorUtils {

	public static BufferedImage rotateColors(BufferedImage image, Color color) {
		int width = image.getWidth();
		int height = image.getHeight();
		WritableRaster raster = image.getRaster();
		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				int[] pixels = raster.getPixel(xx, yy, (int[]) null);
				pixels[0] = color.getRed();
				pixels[1] = color.getGreen();
				pixels[2] = color.getBlue();
				raster.setPixel(xx, yy, pixels);
			}
		}
		return image;
	}
	
	public static BufferedImage imageIcon2BufferedImage(ImageIcon icon) {
		BufferedImage bufferedImage = new BufferedImage(
			    icon.getIconWidth(),
			    icon.getIconHeight(),
			    BufferedImage.TYPE_INT_RGB);
			Graphics g = bufferedImage.createGraphics();
			// paint the Icon to the BufferedImage.
			icon.paintIcon(null, g, 0,0);
			g.dispose();
			return bufferedImage;
	}
	
	public static ImageIcon bufferedImage2ImageIcon(BufferedImage bufferedImage) {
		return new ImageIcon(bufferedImage);
	}
}