/* Aarav Goyal
 * 02/04/2025
 * DNA.java
 */
import java.util.Scanner;
import java.io.*;
public class DNA {
	private Scanner input; 
	private PrintWriter outputDNA; 
	private PrintWriter outputRNA; 
	private PrintWriter outputProtein;

	private String inFileName; 
	private String outFileName; 
	int letters;
	String[] genes = {"rol","try","cod","Pil","dig","tal","mv"};
	String word = "";
	public DNA()
	{
		input = null;
		inFileName = new String("Original.txt");
		outFileName = new String("DNA.txt");

	}
	public static void main(String[] args)
	{
		DNA d = new DNA();
		d.runIt();
	}
	public void runIt()
	{
		openIt(); 	
		makeIt();
		getWords();
	}
	public void openIt()
	{
		File inFile = new File(inFileName);
		try
		{
			input = new Scanner(inFile);
		}
		catch(FileNotFoundException e)
		{
			System.err.printf("\n\n\nERROR: Cannot find/open file %s.\n\n\n",inFileName);
			System.exit(1);
		}
	}
	public void makeIt()
	{
		File outFile = new File("DNA.txt");
		try
		{
			outputDNA = new PrintWriter(outFile);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileName + 
					" file.\n\n\n");
			System.exit(2);
		}
		File outFileA = new File("RNA.txt");
		try
		{
			outputRNA = new PrintWriter(outFileA);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileName + 
					" file.\n\n\n");
			System.exit(2);
		}
		File outFileB = new File("protein.txt");
		try
		{
			outputProtein = new PrintWriter(outFileB);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileName + 
					" file.\n\n\n");
			System.exit(2);
		}
	}
	public void getWords()
	{
		System.out.println("\n\n\n");
		boolean M = false;
		boolean U = false;
		String number;

		while (input.hasNext())
		{
			number = input.next();
			number = number.charAt(0)+"";
			letters = Integer.parseInt(number);

			word = input.nextLine();
			word.trim();
			for(int i =0; i < word.length(); i++)
			{
				if (word.charAt(i)=='M')
				{
					M = true;
					
				}
				else if (word.charAt(i)=='U')
				{
					U = true;
					
				}

			}
			
			if (M)
			{
				outputProtein.printf("%-5s",genes[letters]+": ");
				outputProtein.println(word);
			}
			else if(U)
			{
				outputRNA.printf("%-5s",genes[letters]+": ");
				outputRNA.println(word);
			}
			else
			{
				outputDNA.printf("%-5s",genes[letters]+": ");
				outputDNA.println(word);
			}

			M = false;
			U = false;

		}
		outputDNA.close();
		outputRNA.close();
		outputProtein.close();

	}
}
