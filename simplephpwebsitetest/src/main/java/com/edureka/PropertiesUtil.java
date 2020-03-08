package com.edureka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties propsTestCases = new Properties();
	private File fileTestCases = new File("props/testCases.properties");
	
	private FileInputStream fileISTestCases = null;
	
	public void loadTestCasesPropertyFile() {
		try {
			fileISTestCases = new FileInputStream(fileTestCases);
			propsTestCases.load(fileISTestCases);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getPropsValue(String key) {
		return propsTestCases.getProperty(key);
	}

}
