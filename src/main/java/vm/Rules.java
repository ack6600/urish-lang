package vm;
import java.util.Arrays;
import java.lang.*;
public class Rules
{
	private static final String[] funcs = {"print"};
	public static void pass(String action)
	{
		if(Arrays.asList(funcs).contains(determineRoot(action)))
		{
			doAction(action);
		}
		else
		{
			System.out.println("Invalid Function");
		}
	}
	private static void doAction(String action)
	{
		System.out.println(action);
	}
	private static String determineRoot(String toDetermine)
	{
		StringBuilder string = new StringBuilder(toDetermine);
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == '(')
			{
				return string.substring(0,i);
			}
		}
		return "fafhakjwerhkajlgvbkheabklf";
	}
}
