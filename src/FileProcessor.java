

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class FileProcessor {
	
	private BufferedReader file;
	private int noOfLines;
	private Vector<String> newli;

	public FileProcessor(String filename) throws NumberFormatException, FileNotFoundException, IOException
	{
		file = new BufferedReader(new FileReader(filename));
		noOfLines = Integer.parseInt(file.readLine());
		newli = new Vector<String>();
	}
	
	public void printList()
	{
		int i=0;
		while(i<newli.size())
		{
			System.out.println(newli.get(i));
			i++;
		}
	}
	
	public void run() throws NumberFormatException, IOException
	{
		String line;
		while((line = file.readLine())!=null)
		{	
			if (newli.size()==0)
			{
				newli.add(line);
				continue;
			}
			else if (newli.contains(line))
			{
				continue;
			}
			else
			{
				int index=0;
				int fullindex=newli.size();
				while(index<fullindex)
				{
					if(line.compareTo(newli.get(index))>0)
					{
						index++;
						continue;
					}
					newli.add(index,line);
					break;
				}
			}
		}
	}
}

