package com.nokia.sanjay.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.nokia.sanjay.exceptions.RegexpException;

/**
 * 
 * @author <a href=
 *         "https://www.youracclaim.com/badges/1cacfc10-a704-44ed-94b4-1cd7abbfd168/public_url"
 *         style="color:red; font-size:16; "><em>Sanjay Chauhan</em></a>
 */

public class Utilities {

	private static Properties prop;
	public static Date propertyFileLoadTime;

	public static String getPropertyValue(String propertyName) throws RegexpException {

		String propertyValue = null;
		if (null == prop) {
			try {
				loadProperties();
			} catch (IOException e) {
				throw new RegexpException(101, e.getMessage());
			}
		}

		propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}

	private static void loadProperties() throws IOException {

		String propFileName = Constants.configFileName;
		prop = new Properties();
		InputStream inputStream = Utilities.class.getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
			propertyFileLoadTime = new Date(System.currentTimeMillis());
			
			System.out.println("propertyFileLoadTime is : "+propertyFileLoadTime);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

	}

}
