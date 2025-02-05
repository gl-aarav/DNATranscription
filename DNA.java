import java.io.*;
import java.util.Scanner;

public class DNA 
{
	public static void main(String[] args) 
	{
		DNA dna = new DNA();
		dna.runIt();
	}

	public void runIt() 
	{
		try 
		{
			String[] genes = {"rol", "try", "cod", "Pil", "dig", "tal", "mv"};
			Scanner scanner = new Scanner(new File("Original.txt"));
			FileWriter dna = new FileWriter("DNA.txt");
			FileWriter rna = new FileWriter("RNA.txt");
			FileWriter protein = new FileWriter("protein.txt");

			while (scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				String sequence = new String ("");
				String gene = genes[1];

				if (sequence.matches("[AGTC]+")) dna.write(gene + ": " + sequence + "\n");
				else if (sequence.matches("[AGUC]+")) rna.write(gene + ": " + sequence + "\n");
				else if (sequence.contains("M")) protein.write(gene + ": " + sequence + "\n");
			}

			scanner.close(); 
			dna.close(); 
			rna.close(); 
			protein.close();
		}
		catch (IOException e) 
		{
		
		}
	}
}
