package utlities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result) 
	{
		
		int retry =0;
		int maxcount = 2;
		while(retry<=maxcount)
		{
			retry++;
			System.out.println(result.getName());
			return true;
		}
		
		return false;
	}

}
