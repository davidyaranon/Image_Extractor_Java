import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileScanner 
{
	static Scanner scanner = new Scanner(System.in);
	static File listOfFilesContainingWord;
	static FileWriter writer;
	
	static 
	{
		try
		{
			listOfFilesContainingWord = new File("C:\\CeiSoftware\\OUTPUT.txt");
			writer = new FileWriter(listOfFilesContainingWord);
		}
		catch (final IOException e)
		{
			throw new ExceptionInInitializerError(e.getMessage());
		}
	}
	
	
	public static void showFiles(File[] files)
	{
		for(File f: files)
		{
			if(f.isDirectory())
			{
				showFiles(f.listFiles());
			}
			else
			{
				String input;
				try {
					scanner = new Scanner(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while(scanner.hasNextLine())
				{
					input = scanner.nextLine();
					System.out.println(input);
					if(input.contains("SubscriberKey"))
					{
						try
						{
							writer.write(f.getAbsolutePath() + '\n');
						}
						catch (final IOException e)
						{
							System.out.println("ERROR");
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
  public static void main(String args[]) throws IOException
  {
    	File directory = new File("C:\\CeiSoftware\\");
    	if(listOfFilesContainingWord.createNewFile())
    	{
    		
    	}
    	else
    	{
    		System.out.println("FILE EXISTS\n");
    	}
    	showFiles(directory.listFiles());
    	writer.close();
  }
}
