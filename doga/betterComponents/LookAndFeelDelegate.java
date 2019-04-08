package doga.betterComponents;

import java.awt.Frame;
import java.awt.Window;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import doga.engine.ThemeEngine;
import mars.venus.VenusUI;

public class LookAndFeelDelegate {
	
	public static void setUIConstants() {
		try {
			CustomLookAndFeel laf = new CustomLookAndFeel();
			updateLAF(laf);
			VenusUI.mainUI.validate();
			VenusUI.mainUI.revalidate();
            ThemeEngine.frame.validate();
            ThemeEngine.frame.revalidate();
		} catch (NullPointerException e) {
			System.out.println("Dont' worry, be happy!\nLook And Feel Delegate error, VenusUI not initialized yet, after init the error will go away.");
		}
	}
	
	public static void setUIConstantsOnlyForThemeEngine() {
		try {
			CustomLookAndFeel laf = new CustomLookAndFeel();
			updateLAFOnlyForThemeEngine(laf);
			VenusUI.mainUI.validate();
			VenusUI.mainUI.revalidate();
            ThemeEngine.frame.validate();
            ThemeEngine.frame.revalidate();
		} catch (NullPointerException e) {
			System.out.println("Dont' worry, be happy!\nLook And Feel Delegate error, VenusUI not initialized yet, after init the error will go away.");
		}
	}

	private static void updateLAF(LookAndFeel value) {
		try {
			UIManager.setLookAndFeel(value);
			for (Frame frame : Frame.getFrames()) {
				updateLAFRecursively(frame);
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private static void updateLAFOnlyForThemeEngine(LookAndFeel value) {
		try {
			UIManager.setLookAndFeel(value);
			for (Frame frame : Frame.getFrames()) {
				updateLAFRecursivelyOnlyForThemeEngine(frame);
			}
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateLAFRecursively(Window window) {
		for (Window childWindow : window.getOwnedWindows()) {
			updateLAFRecursively(childWindow);
		}
			SwingUtilities.updateComponentTreeUI(window);
	}
	
	private static void updateLAFRecursivelyOnlyForThemeEngine(Window window) {/*
		for (Window childWindow : window.getOwnedWindows()) {
			updateLAFRecursively(childWindow);
		}
		if(window.equals(ThemeEngine.frame)) {
			SwingUtilities.updateComponentTreeUI(window);
		}*/
		SwingUtilities.updateComponentTreeUI(ThemeEngine.frame);
	}
}
