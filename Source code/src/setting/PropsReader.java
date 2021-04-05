package setting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsReader {
	
	public static String getValue(String filename, String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String value= "";

		try {
			System.out.println("> filename = " + filename);
			input = new FileInputStream(filename);

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			value= prop.getProperty(key);
			
			input.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
