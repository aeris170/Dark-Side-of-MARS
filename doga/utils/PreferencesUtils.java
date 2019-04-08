package doga.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

/**
 * Preferences export and import to files. Needed because the theme-engine needs
 * such a functionality.
 * 
 * @author Doða Oruç
 * @verison 07.03.2018
 */
public class PreferencesUtils {

	public static void exportPreferences(Preferences preferences) {
		try {
			OutputStream os = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.home") + "/preferences.xml"));
			preferences.exportSubtree(os);
			os.close();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Preferences importPreferences(Preferences preferences) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.home") + "/preferences.xml"));
			try {
				Preferences.importPreferences(is);
			} catch (InvalidPreferencesFormatException e) {
				e.printStackTrace();
			}
			is.close();
			preferences.flush();
			return preferences;
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			exportDefaultPreferences();
			importPreferences(preferences);
			return preferences;
		}
		throw new RuntimeException("SHOULD COME HERE!, PREFERENCES_UTILS 47");
	}

	private static void exportDefaultPreferences() {
		try {
			InputStream defaultFile = PreferencesUtils.class.getClassLoader().getResourceAsStream("preferencesUI.xml");
			OutputStream newFile = new FileOutputStream(new File(System.getProperty("user.home") + "/preferences.xml"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = defaultFile.read(bytes)) != -1) {
				newFile.write(bytes, 0, read);
			}

			if (defaultFile != null) {
				try {
					defaultFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (newFile != null) {
				try {
					// outputStream.flush();
					newFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Copy done!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public static Preferences importThemePreferences(Preferences preferences) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.home") + "/themePreferences.xml"));
			try {
				Preferences.importPreferences(is);
			} catch (InvalidPreferencesFormatException e) {
				e.printStackTrace();
			}
			is.close();
			preferences.flush();
			return preferences;
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			exportDefaultPreferences();
			importPreferences(preferences);
			return preferences;
		}
		throw new RuntimeException("SHOULD COME HERE!, PREFERENCES_UTILS 47");
	}

	public static Preferences importDefaultThemePreferences(Preferences preferences) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(System.getProperty("user.home") + "/themePreferences.xml"));
			try {
				Preferences.importPreferences(is);
			} catch (InvalidPreferencesFormatException e) {
				e.printStackTrace();
			}
			is.close();
			preferences.flush();
			return preferences;
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			exportDefaultPreferences();
			importPreferences(preferences);
			return preferences;
		}
		throw new RuntimeException("SHOULD COME HERE!, PREFERENCES_UTILS 47");
	}

	public static Preferences importDefaultDarkThemePreferences(Preferences preferences) {
		try {
			InputStream is = PreferencesUtils.class.getClassLoader().getResourceAsStream("darkThemePreferences.xml");
			try {
				Preferences.importPreferences(is);
				preferences.flush();
			} catch (InvalidPreferencesFormatException e) {
				e.printStackTrace();
			}
			is.close();
			return preferences;
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			exportDefaultThemePreferences();
			importThemePreferences(preferences);
			return preferences;
		}
		throw new RuntimeException("SHOULD COME HERE!, PREFERENCES_UTILS");
	}

	public static void exportThemePreferences(Preferences preferences) {
		try {
			OutputStream os = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.home") + "/themePreferences.xml"));
			preferences.exportSubtree(os);
			os.close();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void exportDefaultThemePreferences() {
		try {
			InputStream defaultFile = PreferencesUtils.class.getClassLoader().getResourceAsStream("themePreferencesUI.xml");
			OutputStream newFile = new FileOutputStream(new File(System.getProperty("user.home") + "/themePreferences.xml"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = defaultFile.read(bytes)) != -1) {
				newFile.write(bytes, 0, read);
			}

			if (defaultFile != null) {
				try {
					defaultFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (newFile != null) {
				try {
					// outputStream.flush();
					newFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("Copy done!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
