package utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	static Properties prop = new Properties();
	
	static 
	{
		{
			try {
				File src = new File(System.getProperty("user.dir")+"./configreader/dataFile.properties");
				FileInputStream fis= new FileInputStream(src);
				prop.load(fis);			
				
			} catch (IOException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	}
	public static String URL()
	{
		return prop.getProperty("URL");
	}
	
	public static String browser()
	{
		return prop.getProperty("browser");
	}
	
}
