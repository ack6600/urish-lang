package vm;
import java.lang.Runnable;
import java.lang.StringBuilder;
import java.io.*;
import java.util.ArrayList;
public class UVM implements Runnable
{
	private BufferedReader buffReader;
	private boolean shouldRun;
	public UVM(File toRun) throws FileNotFoundException
	{
		FileReader filereader = new FileReader(toRun);
		buffReader = new BufferedReader(filereader);
		shouldRun = true;
	}
	public void run()
	{
		String runningLine = "die";	
		System.out.println("Starting");
		while(shouldRun)
		{
			try
			{
				runningLine = buffReader.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			if(runningLine != null)
			{
				evaluate(runningLine);
			}
			else
			{
				return;
			}
		}
	}
	public void shouldRun(boolean shouldRun)
	{
		this.shouldRun = shouldRun;
	}
	private void evaluate(String toEvaluate)
	{
		StringBuilder string = new StringBuilder(toEvaluate);
		int stringStart = 0;
		ArrayList<String> actionList = new ArrayList<String>();
		for(int i = 0; i<string.length();i++)
		{
			if(string.charAt(i) == ' ')
			{
				actionList.add(string.substring(stringStart,i));
				stringStart = i+1;
			}
			else if(i == string.length()-1)
			{
				actionList.add(string.substring(stringStart,i+1));
			}
		}
		for(int k = 0; k < actionList.size();k++)
		{
			Rules.pass(actionList.get(k));
		}
	}
}
