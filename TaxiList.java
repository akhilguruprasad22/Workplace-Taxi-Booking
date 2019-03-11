import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaxiList
{
	private ArrayList<Taxi> taxiList;
	private static final String TAXI_DETAILS_FILE="TaxiDetails.txt";
	private static final String ERROR_READING = "Error during reading process: ";
	private static final String ERROR_NB_ARGUMENTS = "Input line should be 'driver name,registration number'";
	
	public TaxiList(boolean fill)
	{	
		this.taxiList = new ArrayList<Taxi>();
		if(fill)
		{
			try
			{
				readFile(TAXI_DETAILS_FILE);	
			}
			catch(FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}		
	}
	
	public ArrayList<Taxi> getTaxiList()
	{
		return this.taxiList;
	}

	public void setTaxiList(ArrayList<Taxi> taxiList)
	{
		this.taxiList = taxiList;
	}

	public int getNbTaxi()
	{
		return this.taxiList.size();
	}

	public void addTaxi(Taxi t)
	{
		if(t != null)
		{
			taxiList.add(t);
		}
	}

	public int getSize()
	{
		return taxiList.size();
	}
	public void readFile(String fileName) throws FileNotFoundException
	{
		File f = new File(fileName);
		Scanner scanner = new Scanner(f);
		while (scanner.hasNextLine())
		{
			String inputLine = scanner.nextLine(); 
			if (inputLine.length() != 0)
			{
				processLine(inputLine);		
			}	
		}
	}
	public Taxi pop()
	{
		Taxi temp=null;
		if(getSize()!=0)
		{
			temp=taxiList.remove((int)(Math.random()*getSize()));
		}
		return temp;
	}
	private void processLine(String line)
	{
		String [] parts = line.split(",");
		if(parts.length == 2)
		{
			String driverName = parts[0];
			String regNb = parts[1].trim();	
			try
			{
				Taxi t = new Taxi(driverName, regNb);
				this.addTaxi(t); 
			}
			catch (NullPointerException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println(ERROR_READING + ERROR_NB_ARGUMENTS);
		}
	}
}