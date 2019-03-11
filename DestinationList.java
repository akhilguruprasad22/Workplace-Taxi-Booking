import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DestinationList 
{
	private ArrayList<Destination> destinationList;
	private static final String DESTINATION_DETAILS_FILE="Destination.txt";
	private static final String ERROR_READING = "Error during reading process: ";
	private static final String ERROR_NB_ARGUMENTS = "Input line should be 'destination,distance'";
	

	public DestinationList()
	{
		this.destinationList= new ArrayList<Destination>();
		try
		{
			readFile(DESTINATION_DETAILS_FILE);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void setDestinationList(ArrayList<Destination> destinationList)
	{
		this.destinationList = destinationList;
	}

	public ArrayList<Destination> getDestinationList()
	{
		return this.destinationList;
	}

	public boolean addDestination(Destination dest)
	{
		boolean added = false;
		if(dest != null)
		{
			added = destinationList.add(dest);
		}
		return added;
	}

	public void display()
	{
		for(Destination d:this.destinationList)
			System.out.println(d.getName());
	}

	public void readFile(String fileName) throws FileNotFoundException
	{
		File f = new File(fileName);
		Scanner scanner = new Scanner(f);
		while (scanner.hasNextLine())
		{
			try{
				String [] parts = scanner.nextLine().split(",");
				if(parts.length == 2)
				{
					this.addDestination(new Destination(parts[0],Double.parseDouble(parts[1])));								
				}
				else
				{
					System.out.println(ERROR_READING + ERROR_NB_ARGUMENTS);
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println(ERROR_READING + e.getMessage());
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(ERROR_READING + e.getMessage());
			} 
		}
	}

	public Destination getDest(String destName)
	{
		Destination dest = null;
		for(Destination destValid : destinationList)
		{
			if(destName != null && destName.equalsIgnoreCase(destValid.getName()))
			{
				dest = destValid;
				break;
			}
		}
		return dest;
	}
}