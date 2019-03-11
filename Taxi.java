public class Taxi
{
	private String regNb;
	private String driverName;
	private int nbOfSeats;
	private static final String ERROR_NULL_ARGUMENT = "Driver name and/or reg number should not be null";

	public Taxi(String driverName, String regNb)
	{	
		if(driverName == null || regNb == null)
		{
			throw new NullPointerException(ERROR_NULL_ARGUMENT);
		}
		this.driverName = driverName;
		this.regNb = regNb;			
		this.nbOfSeats = 4;
	}

	public String getRegNb()
	{
		return this.regNb;
	}
	
	public void setRegNb(String regNb)
	{
		this.regNb = regNb;
	}
	
	public String getDriverName()
	{
		return this.driverName;
	}

	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}

	public int getNbOfSeats()
	{
		return this.nbOfSeats;
	}

	public void setNbOfSeats(int nbOfSeats)
	{
		this.nbOfSeats = nbOfSeats;
	}

	public boolean equals(Object other)
	{
		boolean eq = false;
		if(other != null && other instanceof Taxi)
		{
		    Taxi t = (Taxi) other;
			eq = this.getRegNb().equals(t.getRegNb());
		}
		return eq;
	}

	public void display()
	{
		System.out.println("Taxi Driver Name:"+this.driverName);
		System.out.println("Taxi Registration Number:"+this.regNb);
		System.out.println("Number of seats available:"+this.nbOfSeats);
	}
	
}