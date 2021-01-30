package com.iNetBanking.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {
	Properties prop;
	
	
	public ReadConfig() { 
		try {
			
			FileInputStream fis = new FileInputStream(new File("./Configuration/config.properties"));
			prop= new Properties();
			prop.load(fis);		
		}
		catch(IOException e) {
			System.out.println(e.getMessage());		}
		
	}
	
	public String getApplicationURL() {
		return prop.getProperty("baseUrl");
	}
	
	public String getUserName() {
		return prop.getProperty("userName");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	public String getChromePath() {
		return prop.getProperty("chromePath");
	}
	public String getFireFoxPath() {
		return prop.getProperty("fireFoxPath");
	}
	public String getIEPath() {
		return prop.getProperty("iePath");
	}


}
