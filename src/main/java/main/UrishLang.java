package main;
import java.io.*;
import vm.UVM;
public class UrishLang
{
	public static void main(String args[])
	{
		System.out.println("Welcome to the ULang Virtual Machine");
		File inputCode = new File(args[0]);
		UVM uvm = null;
		try
		{
			uvm = new UVM(inputCode);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		uvm.run();
	}
}
