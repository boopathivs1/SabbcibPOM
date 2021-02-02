package wrappers;

import java.io.IOException;

public interface Wrappers {


	
	public void invokeApp(String browser) throws IOException;

	
	public void invokeApp(String browser, boolean bRemote);

	
	public void enterById(String idValue, String data);

	
	public void enterByName(String nameValue, String data);	

	
	public void enterByXpath(String xpathValue, String data);


	
	public boolean verifyTitle(String title);

	
	public void verifyTextById(String id, String text);

	
	public void verifyTextByXpath(String xpath, String text);

	
	public void verifyTextContainsByXpath(String xpath, String text);


	
	public void clickById(String id);

	
	public void clickByClassName(String classVal);

	
	public void clickByName(String name);


	
	public void clickByLink(String name);
	public void clickByLinkNoSnap(String name);

	
	public void clickByXpath(String xpathVal);

	
	public void clickByXpathNoSnap(String xpathVal);

	public String getTextById(String idVal);

	public String getTextByXpath(String xpathVal);

	public void selectVisibileTextById(String id, String value);

	public void selectIndexById(String id, int value);

	
	public void switchToParentWindow();

	
	public void switchToLastWindow();

	
	public void acceptAlert();

	
	public void dismissAlert();

	
	public String getAlertText();

	
	public long takeSnap();

	
	public void closeBrowser();


	public void closeAllBrowsers();

}
