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
		File outFileDNA = new File("DNA.txt");
		try
		{
			outputDNA = new PrintWriter(outFileDNA);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileDNA + " file.\n\n\n");
			System.exit(2);
		}
		File outFileRNA = new File("RNA.txt");
		try
		{
			outputRNA = new PrintWriter(outFileRNA);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileRNA + " file.\n\n\n");
			System.exit(3);
		}
		File outFileProtein = new File("protein.txt");
		try
		{
			outputProtein = new PrintWriter(outFileProtein);
		}
		catch (IOException e)
		{
			System.err.println("\n\n\nERROR: Cannot create " + outFileProtein + " file.\n\n\n");
			System.exit(4);
		}
	}
	public void getWords()
	{
		System.out.println("\n\n\n");
		boolean protein = false;
		boolean RNA = false;
		String num;

		while (input.hasNext())
		{
			num = input.next().charAt(0) +  "";
			letters = Integer.parseInt(num);

			word = input.nextLine().trim();
			for(int i = 0; i < word.length(); i++)
			{
				if (word.charAt(i)=='M')
				{
					protein = true;
					
				}
				else if (word.charAt(i) == 'U')
				{
					RNA = true;
				}

			}
			
			if (protein)
			{
				outputProtein.printf("%-5s", genes[letters] + ": ");
				outputProtein.println(word);
			}
			else if(RNA)
			{
				outputRNA.printf("%-5s", genes[letters] + ": ");
				outputRNA.println(word);
			}
			else
			{
				outputDNA.printf("%-5s", genes[letters] + ": ");
				outputDNA.println(word);
			}

			protein = false;
			RNA = false;

		}
		outputDNA.close();
		outputRNA.close();
		outputProtein.close();

	}
}
