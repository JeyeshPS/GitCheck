package utlities;

import org.openqa.selenium.WebDriver;

public class Datasharesetterandgetter 
{
	private WebDriver driver;
	private String homepagetxt;
	private String offertxt;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public String getHomepagetxt() {
		return homepagetxt;
	}
	public void setHomepagetxt(String homepagetxt) {
		this.homepagetxt = homepagetxt;
	}
	public String getOffertxt() {
		return offertxt;
	}
	public void setOffertxt(String offertxt) {
		this.offertxt = offertxt;
	}

}
