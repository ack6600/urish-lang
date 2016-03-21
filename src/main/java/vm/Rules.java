package vm;
import java.util.Arrays;
import java.lang.*;
public class Rules
{
	public static void pass(String action)
	{
		if(Arrays.asList(action.toCharArray()).contains('('))
		{
			parseFunc(action);
		}
	}
	private static void parseFunc(String toParse)
	{
		System.out.println(toParse);
	}
	private static String determineArg(String toDetermine)
	{
		StringBuilder string = new StringBuilder(toDetermine);
		int firstP = 0;
		int secondP= 0;
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) == '(')
			{
				firstP = i;
			}
			if(string.charAt(i) == ')')
			{
				secondP = i;
			}
		}
		return string.substring(firstP+1,secondP);
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
